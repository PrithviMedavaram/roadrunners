package com.everest;

import com.everest.model.OfferCode;
import com.everest.model.Package;
import com.everest.model.Vehicle;
import com.everest.service.ETAService;
import com.everest.service.DiscountService;
import com.everest.util.InputUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class RoadRunnersApplication implements CommandLineRunner {

    private final ETAService etaService;
    private final DiscountService discountService;

    public RoadRunnersApplication(
            ETAService etaService,
            DiscountService discountService
    ) {
        this.etaService = etaService;
        this.discountService = discountService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RoadRunnersApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);

        int packageCount =
                InputUtil.readInt(scanner, "Enter number of packages: ");

        List<Package> packages = new ArrayList<>();

        for (int i = 0; i < packageCount; i++) {
            System.out.println("\nEnter package details:");

            String id =
                    InputUtil.readString(scanner, "Package ID: ");
            double weight =
                    InputUtil.readDouble(scanner, "Weight (kg): ");
            double distance =
                    InputUtil.readDouble(scanner, "Distance (km): ");
            OfferCode offerCode =
                    InputUtil.readOfferCode(scanner);

            packages.add(new Package(id, weight, distance, offerCode));
        }

        packages.forEach(Package::calculateCost);

        System.out.println("\nDelivery Cost Details:");
        packages.forEach(pkg ->
                System.out.printf(
                        "%s %.0f %.0f %.2f %n",
                        pkg.getId(),
                        pkg.getDiscount(),
                        pkg.getTotalCost(),
                        pkg.getBaseCost()
                )
        );

        List<Vehicle> vehicles = List.of(
                new Vehicle(200, 70),
                new Vehicle(200, 70)
        );

        etaService.calculateETAs(packages, vehicles);

        System.out.println("\nEstimated Delivery Times:");
        System.out.println("\nETAs:");
        for (Package pkg : packages) {
            System.out.printf(
                    "%s %.0f %.0f %.2f%n",
                    pkg.getId(),
                    pkg.getDiscount(),
                    pkg.getTotalCost(),
                    pkg.getEta()
            );
        }

    }
}
