package com.everest;

import com.everest.model.OfferCode;
import com.everest.model.Package;
import com.everest.service.DiscountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    private DiscountService discountService;

    @BeforeEach
    void setUp() {
        discountService = new DiscountService();
    }

    @Test
    void calculateDiscounts() {
        Package pkg1 = new Package("PKG1", 5, 5, OfferCode.OFR001);
        Package pkg2 = new Package("PKG2", 15, 5, OfferCode.OFR002);
        Package pkg3 = new Package("PKG3", 10, 100, OfferCode.OFR003);
        List packages = List.of(pkg1, pkg2, pkg3);
        applyDiscounts(packages);
        assertEquals(175, pkg1.getTotalCost());
        assertEquals(0, pkg1.getDiscount());
        assertEquals(275, pkg2.getTotalCost());
        assertEquals(0, pkg2.getDiscount());
        assertEquals(665, pkg3.getTotalCost());
        assertEquals(35, pkg3.getDiscount());
    }

    private void applyDiscounts(List<Package> packages) {
        for (Package p : packages) {
            discountService.applyDiscount(p);
        }
    }
}
