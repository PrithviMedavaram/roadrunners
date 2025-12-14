package com.everest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private double discountPercentage;

    private double maxDiscount;

    protected Offer() {

    }

    public Offer(String code, double discountPercentage, double maxDiscount) {
        this.code = code;
        this.discountPercentage = discountPercentage;
        this.maxDiscount = maxDiscount;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double getMaxDiscount() {
        return maxDiscount;
    }
}
