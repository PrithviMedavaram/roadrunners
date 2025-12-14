package com.everest.model;

public class Vehicle {
    private int id;
    private double maxWeight;
    private double speed;
    private double availableAt;

    public Vehicle(int id, double maxWeight, double speed) {
        this.id = id;
        this.maxWeight = maxWeight;
        this.speed = speed;
        this.availableAt = 0;
    }

    public boolean canCarry(double weight) {
        return weight <= maxWeight;
    }

    public void assign(double tripTime) {
        this.availableAt += tripTime * 2;
    }

    public double getAvailableAt() {
        return availableAt;
    }

    public double getSpeed() {
        return speed;
    }
}
