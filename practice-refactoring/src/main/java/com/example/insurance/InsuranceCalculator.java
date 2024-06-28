package com.example.insurance;

public class InsuranceCalculator {

    public double calculateInsurance(double income) {
        if (isGrateAndEquals(income, 10000)) {
            return calculateCommand(income, 0, 0.365, 0);
        }
        if (isGrateAndEquals(income, 30000)) {
            return calculateCommand(income, 10000, 0.2, 35600);
        }
        if (isGrateAndEquals(income, 60000)) {
            return calculateCommand(income, 30000, 0.1, 76500);
        }
        return calculateCommand(income, 60000, 0.02, 105600);
    }

    private static double calculateCommand(double income, int adjustment, double weight, int constant) {
        return (income - adjustment) * weight + constant;
    }

    private static boolean isGrateAndEquals(double income, int i) {
        return income <= i;
    }

}
