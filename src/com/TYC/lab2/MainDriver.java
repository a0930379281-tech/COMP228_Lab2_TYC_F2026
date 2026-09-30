package com.TYC.lab2;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Array for five Interest objects
        Interest[] interests = new Interest[5];

        System.out.println("===== Interest Calculator =====");

        // Create 5 objects
        for (int i = 0; i < interests.length; i++) {

            System.out.println();
            System.out.println("Enter information for Object " + (i + 1));

            try {

                // Principal
                System.out.print("Enter principal: ");
                String principalInput = input.nextLine();

                // Principal must contain a decimal point
                if (!principalInput.contains(".")) {
                    throw new IllegalArgumentException(
                            "Principal must be a decimal value.");
                }

                BigDecimal principal =
                        new BigDecimal(principalInput);

                // Rate
                System.out.print("Enter interest rate: ");
                String rateInput = input.nextLine();

                // Rate must contain a decimal point
                if (!rateInput.contains(".")) {
                    throw new IllegalArgumentException(
                            "Rate must be a decimal value.");
                }

                BigDecimal rate =
                        new BigDecimal(rateInput);

                // Time
                System.out.print("Enter time in years: ");
                int time = Integer.parseInt(input.nextLine());

                // Create Interest object
                interests[i] =
                        new Interest(principal, rate, time);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Strings are not allowed.");

                i--;

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Invalid input: " + e.getMessage());

                i--;
            }
        }

        // Display all 5 objects
        System.out.println();
        System.out.println("===== Calculation Results =====");

        for (int i = 0; i < interests.length; i++) {

            System.out.println();
            System.out.println("Object " + (i + 1));

            interests[i].displayInterest();
        }

        // Demonstrate method overloading
        System.out.println();
        System.out.println("===== Method Overloading Demo =====");

        double doubleResult =
                Interest.calculateSimpleInterest(
                        1000.50,
                        5.25,
                        2.0);

        System.out.printf(
                "Simple Interest using double: $%.2f%n",
                doubleResult);

        BigDecimal bigDecimalResult =
                Interest.calculateSimpleInterest(
                        new BigDecimal("1000.50"),
                        new BigDecimal("5.25"),
                        new BigDecimal("2.0"));

        System.out.println(
                "Simple Interest using BigDecimal: $"
                        + bigDecimalResult);

        input.close();
    }
}