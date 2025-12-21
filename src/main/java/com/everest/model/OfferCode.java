package com.everest.model;

public enum OfferCode {

    OFR001(
            "10% discount (70–200kg, 0–200km)",
            70, 200, 0, 200, 0.10
    ),
    OFR002(
            "7% discount (100–250kg, 50–150km)",
            100, 250, 50, 150, 0.07
    ),
    OFR003(
            "5% discount (10–150kg, 50–250km)",
            10, 150, 50, 250, 0.05
    ),
    NONE(
            "No discount",
            0, 0, 0, 0, 0.0
    );

    private final String description;
    private final double minWeight;
    private final double maxWeight;
    private final double minDistance;
    private final double maxDistance;
    private final double discountRate;

    OfferCode(
            String description,
            double minWeight,
            double maxWeight,
            double minDistance,
            double maxDistance,
            double discountRate
    ) {
        this.description = description;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.discountRate = discountRate;
    }

    public boolean isApplicable(double weight, double distance) {
        return weight >= minWeight && weight <= maxWeight
                && distance >= minDistance && distance <= maxDistance;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public String getDescription() {
        return description;
    }
}
