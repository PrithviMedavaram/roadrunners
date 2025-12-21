package com.everest.service;

import com.everest.model.OfferCode;
import com.everest.model.Package;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public void applyDiscount(Package pkg) {

        OfferCode offer = pkg.getOfferCode();

        if (offer == null || offer == OfferCode.NONE) {
            pkg.setDiscount(0);
            return;
        }

        if (offer.isApplicable(pkg.getWeight(), pkg.getDistance())) {
            double discount =
                    pkg.getTotalCost() * offer.getDiscountRate();

            pkg.setDiscount(discount);
        } else {
            pkg.setDiscount(0);
        }
    }
}
