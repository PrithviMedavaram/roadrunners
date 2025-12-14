package com.everest.model;

public class DeliveryResult {
    private String packageId;
    private double discount;
    private double totalCost;
    private double deliveryTime;

    public DeliveryResult(String packageId, double discount, double totalCost, double deliveryTime) {
        this.packageId = packageId;
        this.discount = discount;
        this.totalCost = totalCost;
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String toString() {
        return packageId + " " + (int)discount + " " + (int)totalCost + " " + String.format("%.2f", deliveryTime);
    }
}
