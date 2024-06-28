package com.example.insurance;

import java.util.List;

import static com.example.insurance.InsuranceStrategy.getInstance;

public class InsuranceCalculator {

    public static final InsuranceStrategy DEFAULT_INSTANCE = getInstance(0, 60000, 0.02, 105600);
    private final List<InsuranceStrategy> insuranceStrategies = List.of(
            getInstance(10000, 0, 0.365, 0),
            getInstance(30000, 10000, 0.2, 35600),
            getInstance(60000, 30000, 0.1, 76500)
    );

    public double calculateInsurance(double income) {

        for (InsuranceStrategy strategy : insuranceStrategies) {
            if (strategy.isGrateAndEquals(income)) {
                return strategy.calculateCommand(income);
            }
        }

        return DEFAULT_INSTANCE.calculateCommand(income);
    }
}
