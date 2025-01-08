package com.company;

import java.util.Random;

public class Initializer {
    public static double[][] normalInitializer(int prevNeuronNum, int currNeuronNum) {
        Random random = new Random();
        double[][] result = new double[currNeuronNum][prevNeuronNum];
        for(int i=0;i<currNeuronNum;i++) {
            for(int j=0;j<prevNeuronNum;j++) {
                result[i][j] = random.nextGaussian();
            }
        }
        return result;
    }

    public static double[][] xavierInitializer(int prevNeuronNum, int currNeuronNum) {
        Random random = new Random();
        double[][] result = new double[currNeuronNum][prevNeuronNum];
        double stdDeviation = Math.sqrt((double) 1 / prevNeuronNum);
        for(int i=0;i<currNeuronNum;i++) {
            for(int j=0;j<prevNeuronNum;j++) {
                result[i][j] = random.nextGaussian() * stdDeviation;
            }
        }
        return result;
    }

    public static double[][] heInitializer(int prevNeuronNum, int currNeuronNum) {
        Random random = new Random();
        double[][] result = new double[currNeuronNum][prevNeuronNum];
        double stdDeviation = Math.sqrt((double) 2 / prevNeuronNum);
        for(int i=0;i<currNeuronNum;i++) {
            for(int j=0;j<prevNeuronNum;j++) {
                result[i][j] = random.nextGaussian() * stdDeviation;
            }
        }
        return result;
    }

    public static double[][] testInitializer(int prevNeuronNum, int currNeuronNum) {
        double[][] result = new double[currNeuronNum][prevNeuronNum];
        for(int i=0;i<currNeuronNum;i++) {
            for(int j=0;j<prevNeuronNum;j++) {
                result[i][j] = 2;
            }
        }
        return result;
    }
}
