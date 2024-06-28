package com.example.insurance;

public class InsuranceCalculator {

    public double calculateInsurance(double income) {
        if (isGrateAndEquals(income, 10000)) {
            return new insuranceStrategy(0, 0.365, 0).calculateCommand(income);
        }
        if (isGrateAndEquals(income, 30000)) {
            return new insuranceStrategy(10000, 0.2, 35600).calculateCommand(income);
        }
        if (isGrateAndEquals(income, 60000)) {
            return new insuranceStrategy(30000, 0.1, 76500).calculateCommand(income);
        }
        return new insuranceStrategy(60000, 0.02, 105600).calculateCommand(income);
    }

    private boolean isGrateAndEquals(double income, int baseIncome) {
        return income <= baseIncome;
    }

}
