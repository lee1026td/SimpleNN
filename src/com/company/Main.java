package com.company;

public class Main {
    public static void main(String[] args) {

        /*
        Network n = new Network(
                new Layer(8, 10, "he", "relu"),
                new Layer(10, 10, "he", "relu"),
                new Layer(10, 10, "he", "relu"),
                new Layer(10, 10, "he", "relu"),
                new Layer(10, 8, "he", "relu"),
                new Layer(10, 1, "xavier", "sigmoid")
        );
        double[] input = {3.1, 0.5, 2.3, 0.4, 1.2, 7.3, 2.7, 5.9};

        double[] result = n.predict(input);
        */
        double[][] input = {
                {1, 2, 3},
                {2, 3, 4},
                {4, 1, 3},
                {5, 2, 5}
        };

        Network n = new Network(
                new Layer(3, 5, "he", "relu"),
                new Layer(5, 5, "he", "relu"),
                new Layer(5, 2, "xavier", "sigmoid")
        );

        double[][] result = n.predict(input);

        for(double[] a : result) {
            for(double b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }


    }
}
