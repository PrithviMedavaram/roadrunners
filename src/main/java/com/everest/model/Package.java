package com.everest.model;

public class Package {

    private String id;
    private double weight;
    private double distance;
    private OfferCode offerCode;

    private double discount;
    private double totalCost;
    private double estimatedDeliveryTime;

    public Package(String id, double weight, double distance, OfferCode offerCode) {
        this.id = id;
        this.weight = weight;
        this.distance = distance;
        this.offerCode = offerCode;
        this.totalCost = calculateBaseCost();
    }

    private double calculateBaseCost() {
        return 100
                + (weight * 10)
                + (distance * 5);
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public double getDistance() {
        return distance;
    }

    public OfferCode getOfferCode() {
        return offerCode;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalCost() {
        return totalCost - discount;
    }

    public double getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(double estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }
}
