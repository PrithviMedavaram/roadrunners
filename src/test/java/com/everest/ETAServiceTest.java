package com.everest;

import com.everest.model.OfferCode;
import com.everest.model.Package;
import com.everest.model.Vehicle;
import com.everest.service.ETAService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class ETAServiceTest {

    private ETAService etaService;

    @BeforeEach
    void setUp() {

        etaService = new ETAService();
    }

    @Test
    void shouldCalculateETAForSinglePackage() {
        Package pkg = new Package("PKG1", 10, 100, OfferCode.NONE);
        List<Package> packages = List.of(pkg);
        List<Vehicle> vehicles = List.of(
                new Vehicle(200, 50)
        );
        etaService.calculateETAs(packages, vehicles);
    }
}
