package com.example.insurance;

public class InsuranceCalculator {

    public double calculateInsurance(double income) {
        if (isGrateAndEquals(income, 10000)) {
            return calculateCommand(income, new insuranceStrategy(0, 0.365, 0));
        }
        if (isGrateAndEquals(income, 30000)) {
            return calculateCommand(income, new insuranceStrategy(10000, 0.2, 35600));
        }
        if (isGrateAndEquals(income, 60000)) {
            return calculateCommand(income, new insuranceStrategy(30000, 0.1, 76500));
        }
        return calculateCommand(income, new insuranceStrategy(60000, 0.02, 105600));
    }

    private double calculateCommand(double income, insuranceStrategy strategy) {
        return (income - strategy.adjustment()) * strategy.weight() + strategy.constant();
    }

    private boolean isGrateAndEquals(double income, int baseIncome) {
        return income <= baseIncome;
    }

}
