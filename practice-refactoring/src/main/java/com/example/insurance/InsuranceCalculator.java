package com.example.insurance;

import static com.example.insurance.InsuranceStrategy.getInstance;

public class InsuranceCalculator {

    public double calculateInsurance(double income) {
        if (isGrateAndEquals(income, 10000)) {
            return getInstance(10000, 0, 0.365, 0).calculateCommand(income);
        }
        if (isGrateAndEquals(income, 30000)) {
            return getInstance(30000, 10000, 0.2, 35600).calculateCommand(income);
        }
        if (isGrateAndEquals(income, 60000)) {
            return getInstance(60000, 30000, 0.1, 76500).calculateCommand(income);
        }
        return getInstance(0, 60000, 0.02, 105600).calculateCommand(income);
    }

    private boolean isGrateAndEquals(double income, int baseIncome) {
        return income <= baseIncome;
    }

}
