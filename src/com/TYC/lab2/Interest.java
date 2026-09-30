package com.TYC.lab2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Interest {

    // Instance variables
    private BigDecimal principal;
    private BigDecimal rate;
    private int time;

    // Constructor with validation
    public Interest(BigDecimal principal, BigDecimal rate, int time) {

        if (principal == null || principal.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Principal must be greater than 0.");
        }

        if (rate == null || rate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Rate must be greater than 0.");
        }

        if (time <= 0) {
            throw new IllegalArgumentException(
                    "Time must be greater than 0.");
        }

        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    // Simple Interest using BigDecimal
    // SI = P * R * T / 100
    public BigDecimal calculateSimpleInterest() {

        return principal
                .multiply(rate)
                .multiply(BigDecimal.valueOf(time))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    // Compound Interest using BigDecimal
    // CI = P(1 + R/100)^T - P
    public BigDecimal calculateCompoundInterest() {

        BigDecimal rateDecimal = rate.divide(
                BigDecimal.valueOf(100),
                10,
                RoundingMode.HALF_UP);

        BigDecimal amount = principal.multiply(
                BigDecimal.ONE.add(rateDecimal).pow(time));

        return amount.subtract(principal)
                .setScale(2, RoundingMode.HALF_UP);
    }

    // Overloaded Simple Interest method using double
    public static double calculateSimpleInterest(
            double principal,
            double rate,
            double time) {

        return principal * rate * time / 100;
    }

    // Overloaded Simple Interest method using BigDecimal
    public static BigDecimal calculateSimpleInterest(
            BigDecimal principal,
            BigDecimal rate,
            BigDecimal time) {

        return principal
                .multiply(rate)
                .multiply(time)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    // Display object information
    public void displayInterest() {

        System.out.println("Principal: $" + principal);
        System.out.println("Rate: " + rate + "%");
        System.out.println("Time: " + time + " year(s)");
        System.out.println("Simple Interest: $"
                + calculateSimpleInterest());
        System.out.println("Compound Interest: $"
                + calculateCompoundInterest());
    }
}