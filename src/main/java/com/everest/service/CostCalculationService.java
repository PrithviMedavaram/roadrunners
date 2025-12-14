package com.everest.service;

import com.everest.model.Offer;
import com.everest.model.Package;

public class CostCalculationService {

    private static final int BASE_WEIGHT_COST = 10;
    private static final int BASE_DISTANCE_COST = 5;

    public double calculateBaseCost(double baseCost, Package pkg) {
        return baseCost + (pkg.getWeight() * BASE_WEIGHT_COST) + (pkg.getDistance() * BASE_DISTANCE_COST);
    }

    public double calculateDiscount(double cost, Offer offer) {
        if (offer == null) return 0;
        return Math.min(cost * offer.getDiscountPercentage() / 100, offer.getMaxDiscount());
    }
}
