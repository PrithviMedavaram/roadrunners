package com.everest;

import com.everest.model.OfferCode;
import com.everest.model.Package;
import com.everest.service.DiscountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    private DiscountService discountService;

    @BeforeEach
    void setUp() {
        discountService = new DiscountService();
    }

    @Test
    void shouldApplyDiscountWhenOfferIsApplicable() {
        Package pkg = new Package("PKG1", 5, 5, OfferCode.OFR001);
        discountService.applyDiscount(pkg);
        assertEquals(175, pkg.getTotalCost());
        assertEquals(0, pkg.getDiscount());
        assertEquals(
                175.0,
                pkg.getTotalCost() - pkg.getDiscount()
        );
    }


}
