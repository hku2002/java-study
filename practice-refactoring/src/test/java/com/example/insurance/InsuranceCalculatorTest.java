package com.example.insurance;

import com.example.insurance.refactor.InsuranceCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InsuranceCalculatorTest {

    @Test
    @DisplayName("수입별 보험료 계산로직이 올바르게 return 되는지 확인한다.")
    void testCalculateInsuranceByIncome() {

        InsuranceCalculator calculator = new InsuranceCalculator();
        assertThat(calculator.calculateInsurance(5_000)).isEqualTo(1_825);
        assertThat(calculator.calculateInsurance(25_000)).isEqualTo(38_600);
        assertThat(calculator.calculateInsurance(50_000)).isEqualTo(78_500);
        assertThat(calculator.calculateInsurance(100_000)).isEqualTo(106_400);

    }

}
