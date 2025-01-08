package com.company;

public class MSELoss extends LossFunction {

    @Override
    public double calculate(double[] predicted, double[] actual) {
        int n = predicted.length;
        double result = 0;
        for(int i=0;i<n;i++) {
            result += Math.pow(predicted[i] - actual[i], 2);
        }

        return result / n;
    }

    @Override
    public double gradient(double[] predicted, double[] actual) {
        return 0;
    }
}
