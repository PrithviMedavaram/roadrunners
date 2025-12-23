package com.everest.model;

public class Vehicle {

    private final double maxWeight;
    private final double speed;
    private double availableAt = 0.0;

    public Vehicle(double maxWeight, double speed) {
        this.maxWeight = maxWeight;
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAvailableIn() {
        return availableAt;
    }

    public void addReturnTime(double time) {
        this.availableAt += time;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setAvailableIn(double availableAt) {
        this.availableAt = availableAt;
    }
}
