package com.everest.service;

import com.everest.model.Package;
import com.everest.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ETAService {

    public void calculateETAs(
            List<Package> packages,
            List<Vehicle> vehicles
    ) {
        List<Package> sortedPackages = new ArrayList<>(packages);


        sortedPackages.sort(
                Comparator.comparingDouble(Package::getWeight).reversed()
        );

        for (Package pkg : packages) {

            Vehicle vehicle = vehicles.stream()
                    .min(Comparator.comparingDouble(Vehicle::getAvailableAt))
                    .orElseThrow();

            double travelTime = pkg.getDistance() / vehicle.getSpeed();
            double eta = vehicle.getAvailableAt() + travelTime;

            pkg.setEstimatedDeliveryTime(eta);
            vehicle.assign(travelTime);
        }
    }
}
