package com.company;

public class CrossEntropyLoss extends LossFunction {
    @Override
    public double calculate(double[] predicted, double[] actual) {
        int n = predicted.length;
        double delta = 1e-7;
        double result = 0;
        for(int i=0;i<n;i++) {
            result -= actual[i] * Math.log(predicted[i] + delta);
        }

        return result;
    }

    @Override
    public double gradient(double[] predicted, double[] actual) {
        return 0;
    }
}
