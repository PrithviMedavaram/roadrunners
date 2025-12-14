package com.everest.service;

import com.everest.model.Offer;
import com.everest.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Optional<Offer> getOfferByCode(String code) {
        return offerRepository.findByCode(code);
    }
}
