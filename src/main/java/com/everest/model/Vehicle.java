package com.everest.model;

public class Vehicle {

    private final double maxLoad;
    private final double speed;
    private double availableAt;

    public Vehicle(double maxLoad, double speed) {
        this.maxLoad = maxLoad;
        this.speed = speed;
        this.availableAt = 0.0;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAvailableAt() {
        return availableAt;
    }

    public void assign(double travelTime) {
        this.availableAt += travelTime;
    }
}
