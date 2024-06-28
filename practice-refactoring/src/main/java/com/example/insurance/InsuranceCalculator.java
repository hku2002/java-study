package com.example.insurance;

public class InsuranceCalculator {

    public double calculateInsurance(double income) {
        if (isGrateAndEquals(income, 10000)) {
            return income * 0.365 + 0;
        }
        if (isGrateAndEquals(income, 30000)) {
            return (income - 10000) * 0.2 + 35600;
        }
        if (isGrateAndEquals(income, 60000)) {
            return (income - 30000) * 0.1 + 76500;
        }
        return (income - 60000) * 0.02 + 105600;
    }

    private static boolean isGrateAndEquals(double income, int i) {
        return income <= i;
    }

}
