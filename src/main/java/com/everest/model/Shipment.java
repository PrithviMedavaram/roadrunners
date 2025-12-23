package com.everest.model;

import java.util.ArrayList;
import java.util.List;

public class Shipment implements Comparable<Shipment> {

    private final List<Package> packages;
    private final double totalWeight;
    private final double maxDistance;

    public Shipment(List<Package> packages) {
        this.packages = new ArrayList<>(packages);
        this.totalWeight = packages.stream()
                .mapToDouble(Package::getWeight)
                .sum();
        this.maxDistance = packages.stream()
                .mapToDouble(Package::getDistance)
                .max()
                .orElse(0);
    }

    @Override
    public int compareTo(Shipment other) {
        // Priority 1: Maximum packages (more is better)
        if (this.packages.size() != other.packages.size()) {
            return Integer.compare(other.packages.size(), this.packages.size());
        }

        // Priority 2: Maximum weight (heavier is better when package count is same)
        if (Math.abs(this.totalWeight - other.totalWeight) > 0.01) {
            return Double.compare(other.totalWeight, this.totalWeight);
        }

        // Priority 3: Minimum distance (deliver first when count and weight are same)
        return Double.compare(this.maxDistance, other.maxDistance);
    }

    public List<Package> getPackages() {
        return new ArrayList<>(packages);
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public int getPackageCount() {
        return packages.size();
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "packages=" + packages.size() +
                ", totalWeight=" + totalWeight +
                ", maxDistance=" + maxDistance +
                '}';
    }
}