package com.everest;

import com.everest.model.*;
import com.everest.model.Package;
import com.everest.service.DiscountService;
import com.everest.service.ETAService;
import com.everest.util.InputUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class RoadRunnersApplication implements CommandLineRunner {

    private final DiscountService discountService;
    private final ETAService etaService;

    public RoadRunnersApplication(
            DiscountService discountService,
            ETAService etaService
    ) {
        this.discountService = discountService;
        this.etaService = etaService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RoadRunnersApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);

        int count = InputUtil.readInt(scanner, "Enter number of packages: ");
        List<Package> packages = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("\nPackage " + (i + 1));

            String id = InputUtil.readString(scanner, "ID: ");
            double weight = InputUtil.readDouble(scanner, "Weight (kg): ");
            double distance = InputUtil.readDouble(scanner, "Distance (km): ");

            System.out.println("Offer Code: 1.NONE  2.OFR001  3.OFR002  4.OFR003");
            int choice = InputUtil.readInt(scanner, "Choose: ");

            OfferCode offer = OfferCode.values()[choice - 1];

            Package pkg = new Package(id, weight, distance, offer);
            discountService.applyDiscount(pkg);
            packages.add(pkg);
        }

        List<Vehicle> vehicles = List.of(
                new Vehicle(200, 70),
                new Vehicle(200, 70)
        );

        etaService.calculateETAs(packages, vehicles);

        System.out.println("\nFINAL OUTPUT:");
        packages.forEach(p ->
                System.out.printf(
                        "%s | Cost: %.2f | Discount: %.2f | ETA: %.2f hrs%n",
                        p.getId(),
                        p.getTotalCost(),
                        p.getDiscount(),
                        p.getEstimatedDeliveryTime()
                )
        );
    }
}
