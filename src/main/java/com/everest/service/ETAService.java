package com.everest.service;

import com.everest.model.Package;
import com.everest.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ETAService {

    public Map<String, Double> calculateDeliveryTimes(
            List<Package> packages,
            List<Vehicle> vehicles
    ) {
        Map<String, Double> result = new HashMap<>();

        packages.sort(Comparator.comparingDouble(Package::getWeight).reversed());

        for (Package pkg : packages) {

            Vehicle vehicle = vehicles.stream()
                    .min(Comparator.comparingDouble(Vehicle::getAvailableAt))
                    .orElseThrow(() -> new IllegalStateException("No vehicles available"));

            double travelTime = pkg.getDistance() / vehicle.getSpeed();
            double deliveryTime = vehicle.getAvailableAt() + travelTime;

            vehicle.assign(travelTime);

            pkg.setEstimatedDeliveryTime(deliveryTime);

            result.put(pkg.getId(), deliveryTime);
        }

        return result;
    }
}
