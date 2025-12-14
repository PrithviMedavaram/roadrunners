package com.everest;

import com.everest.model.Package;
import com.everest.model.Vehicle;
import com.everest.service.ETAService;
import com.everest.util.InputUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class RoadRunnersApplication implements CommandLineRunner {

    private final ETAService etaService;

    public RoadRunnersApplication(ETAService etaService) {
        this.etaService = etaService;
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
            String offerCode =
                    InputUtil.readString(scanner, "Offer Code: ");

            packages.add(new Package(id, weight, distance, offerCode));
        }

        // Vehicles — per problem statement
        List<Vehicle> vehicles = List.of(
                new Vehicle(1, 200, 70),
                new Vehicle(2, 200, 70)
        );

        Map<String, Double> etaMap =
                etaService.calculateDeliveryTimes(packages, vehicles);

        System.out.println("\nEstimated Delivery Times:");
        etaMap.forEach((id, eta) ->
                System.out.printf("%s -> %.2f hours%n", id, eta)
        );
    }
}
