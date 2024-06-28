package com.example.insurance.refactor;

public record InsuranceStrategy(int baseIncome, int adjustment, double weight, int constant) {

    static InsuranceStrategy getInstance(int baseIncome, int adjustment, double weight, int constant) {
        return new InsuranceStrategy(baseIncome, adjustment, weight, constant);
    }

    double calculateCommand(double income) {
        return (income - adjustment) * weight + constant;
    }

    boolean isGrateAndEquals(double income) {
        return income <= baseIncome;
    }
}
