package com.everest.model;

public class Package {

    private final String id;
    private final double weight;
    private final double distance;
    private final OfferCode offerCode;

    private double baseCost;
    private double discount;
    private double totalCost;
    private double eta;


    public Package(String id, double weight, double distance, OfferCode offerCode) {
        this.id = id;
        this.weight = weight;
        this.distance = distance;
        this.offerCode = offerCode;
    }

    public void calculateCost() {
        this.baseCost = 100 + (weight * 10) + (distance * 5);

        if (offerCode.isApplicable(weight, distance)) {
            this.discount = baseCost * offerCode.getDiscountRate();
        } else {
            this.discount = 0;
        }

        this.totalCost = baseCost - discount;
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

    public double getBaseCost() {
        return baseCost;
    }

    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public OfferCode getOfferCode() {
        return offerCode;
    }

    public double getEta() {
        return eta;
    }

    public void setEta(double eta) {
        this.eta = eta;
    }
}
