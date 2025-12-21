package com.everest.util;

import java.util.Scanner;
import com.everest.model.OfferCode;


public final class InputUtil {

    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    public static OfferCode readOfferCode(Scanner scanner) {
        System.out.println("\nSelect Offer Code:");

        OfferCode[] codes = OfferCode.values();
        for (OfferCode code : OfferCode.values()) {
            System.out.println(code.name() + " - " + code.getDescription());
        }

        while (true) {
            System.out.print("Enter choice (1-" + codes.length + "): ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= codes.length) {
                    return codes[choice - 1];
                }
            } catch (NumberFormatException ignored) {}

            System.out.println("Invalid choice. Please try again.");
        }
    }


    public static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
