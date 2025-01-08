package com.company;

import java.util.Arrays;

public class ActivationFunction {
    public static double identical(double value) { return value; }

    public static double relu(double value) {
        return Math.max(0, value);
    }

    public static double sigmoid(double value) {
        return 1 / (1 + Math.exp(-value));
    }

    public static double stepFunc(double value) {
        return value > 0 ? 1 : 0;
    }

    public static double[] softmax(double[] values) {
        double[] result = new double[values.length];
        double max = Arrays.stream(values).max().getAsDouble();
        double denominator = 0;
        for(double val : values) denominator += Math.exp(val - max);

        for(int i=0;i<result.length;i++) {
            result[i] = Math.exp(values[i] - max) / denominator;
        }

        return result;
    }
}
