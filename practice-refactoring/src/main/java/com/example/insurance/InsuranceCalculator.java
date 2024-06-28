package com.example.insurance;

import java.util.List;

import static com.example.insurance.InsuranceStrategy.getInstance;

public class InsuranceCalculator {

    public static final InsuranceStrategy DEFAULT_INSTANCE = getInstance(0, 60000, 0.02, 105600);

    public double calculateInsurance(double income) {
        InsuranceStrategy instance1 = getInstance(10000, 0, 0.365, 0);
        InsuranceStrategy instance2 = getInstance(30000, 10000, 0.2, 35600);
        InsuranceStrategy instance3 = getInstance(60000, 30000, 0.1, 76500);
        List<InsuranceStrategy> insuranceStrategies = List.of(instance1, instance2, instance3);

        for (InsuranceStrategy strategy : insuranceStrategies) {
            if (strategy.isGrateAndEquals(income)) {
                return strategy.calculateCommand(income);
            }
        }

        return DEFAULT_INSTANCE.calculateCommand(income);
    }
}
