package com.everest.service;

import com.everest.model.Package;
import com.everest.model.Shipment;
import com.everest.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ETAService {

    public void calculateETAs(List<Package> packages, List<Vehicle> vehicles) {
        List<Package> remaining = new ArrayList<>(packages);

        while (!remaining.isEmpty()) {
            // Step 1: Find the vehicle that will be available first
            Vehicle nextVehicle = vehicles.stream()
                    .min(Comparator.comparingDouble(Vehicle::getAvailableIn))
                    .orElseThrow(() -> new IllegalStateException("No vehicles available"));

            double currentTime = nextVehicle.getAvailableIn();

            // Step 2: Find the optimal shipment combination
            Shipment bestShipment = findOptimalShipment(remaining, nextVehicle.getMaxWeight());

            if (bestShipment == null || bestShipment.getPackages().isEmpty()) {
                break; // No valid shipment possible
            }

            // Step 3: Calculate delivery time for each package
            double maxDistance = bestShipment.getMaxDistance();

            for (Package pkg : bestShipment.getPackages()) {
                double deliveryTime = currentTime + (pkg.getDistance() / nextVehicle.getSpeed());
                pkg.setEta(deliveryTime);
                remaining.remove(pkg);
            }

            // Step 4: Update vehicle availability (round trip to farthest destination)
            double roundTripTime = 2 * (maxDistance / nextVehicle.getSpeed());
            nextVehicle.setAvailableIn(currentTime + roundTripTime);
        }
    }

    private Shipment findOptimalShipment(List<Package> packages, double maxWeight) {
        List<Shipment> allCandidates = new ArrayList<>();

        // Generate all valid combinations using simple recursion
        generateCombinations(packages, 0, new ArrayList<>(), maxWeight, allCandidates);

        // Return the best shipment according to priority rules
        return allCandidates.stream()
                .min(Comparator.naturalOrder())
                .orElse(null);
    }

    private void generateCombinations(
            List<Package> packages,
            int index,
            List<Package> current,
            double maxWeight,
            List<Shipment> result) {

        // Base case: we've considered all packages
        if (index == packages.size()) {
            // Only add non-empty combinations
            if (!current.isEmpty()) {
                result.add(new Shipment(new ArrayList<>(current)));
            }
            return;
        }

        Package currentPackage = packages.get(index);
        double currentWeight = current.stream()
                .mapToDouble(Package::getWeight)
                .sum();

        // Option 1: Include this package (if it fits)
        if (currentWeight + currentPackage.getWeight() <= maxWeight) {
            current.add(currentPackage);
            generateCombinations(packages, index + 1, current, maxWeight, result);
            current.remove(current.size() - 1); // backtrack
        }

        // Option 2: Skip this package
        generateCombinations(packages, index + 1, current, maxWeight, result);
    }

}