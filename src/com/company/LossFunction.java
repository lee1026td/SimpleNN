package com.company;

public abstract class LossFunction {
    public abstract double calculate(double[] predicted, double[] actual);
    public abstract double gradient(double[] predicted, double[] actual);
}
