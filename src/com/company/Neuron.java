package com.company;

import java.util.stream.IntStream;

public class Neuron {
    private double[] weight;
    private double bias;

    public Neuron(double[] weight, double bias) {
        this.weight = weight;
        this.bias = bias;
    }

    public double calcResult(double[] input) {
        double result = 0;
        for(int i = 0;i < input.length;i++) {
            result += input[i] * weight[i];
        }
        result += bias;

        return result;
    }

}
