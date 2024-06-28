package com.example.insurance;

public record insuranceStrategy(int adjustment, double weight, int constant) {
    double calculateCommand(double income) {
        return (income - adjustment) * weight + constant;
    }
}
