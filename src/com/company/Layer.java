package com.company;

import java.util.stream.IntStream;

public class Layer {
    private Neuron[] neuralLayer;
    private int inputDimension;
    private int outputDimension;
    private String weightInitializer;
    private String activationFunc;
    private boolean isLastLayer;

    public Layer(int inputDimension, int outputDimension, String weightInitializer, String activationFunc) {
        this.inputDimension = inputDimension;
        this.outputDimension = outputDimension;
        this.weightInitializer = weightInitializer;
        this.activationFunc = activationFunc;

        neuralLayer = new Neuron[outputDimension];
        createNeurons();
    }

    private void createNeurons() {
        double[][] weights;

        switch(weightInitializer) {
            case "xavier" :
                weights = Initializer.xavierInitializer(inputDimension, outputDimension);
                break;
            case "he" :
                weights = Initializer.heInitializer(inputDimension, outputDimension);
                break;
            case "test" :
                weights = Initializer.testInitializer(inputDimension, outputDimension);
                break;
            default:
                weights = Initializer.normalInitializer(inputDimension, outputDimension);
                break;
        }
        /*
        System.out.println("WEIGHTS");
        for(double[] a : weights) {
            for(double b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }*/

        for(int i=0;i<outputDimension;i++) {
            neuralLayer[i] = new Neuron(weights[i], 0);
        }
    }

    public void setLastLayer() {
        this.isLastLayer = true;
    }

    private double getActivationFuncResult(double result) {
        if(activationFunc.equals("relu")) {
            return ActivationFunction.relu(result);
        } else if(activationFunc.equals("sigmoid")) {
            return ActivationFunction.sigmoid(result);
        } else if(activationFunc.equals("step")) {
            return ActivationFunction.stepFunc(result);
        } else if(activationFunc.equals("ident")) {
            return ActivationFunction.identical(result);
        } else {
            return 0;
        }
    }

    public int getInputDimension() {
        return inputDimension;
    }

    public int getOutputDimension() {
        return outputDimension;
    }

    public double[] forwardPropagation(double[] input) {
        double[] resultArr = new double[outputDimension];
        for(int i=0;i<outputDimension;i++) {
            resultArr[i] = getActivationFuncResult(neuralLayer[i].calcResult(input));
        }
        return resultArr;
    }

    public double[][] forwardPropagation(double[][] input) {
        int sampleNum = input.length;  // 샘플 개수
        double[][] resultArr = new double[sampleNum][outputDimension];  // 수정된 크기 설정

        // 각 샘플에 대해 forward propagation 수행
        IntStream.range(0, sampleNum).parallel().forEach(i -> {
            for (int j = 0; j < outputDimension; j++) {
                resultArr[i][j] = getActivationFuncResult(neuralLayer[j].calcResult(input[i]));
            }
        });
        return resultArr;
    }


    public double[][] transposeArr(double[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        double[][] resultArr = new double[col][row];

        for(int i=0;i<col;i++) {
            for(int j=0;j<row;j++) {
                resultArr[i][j] = arr[j][i];
            }
        }

        return resultArr;
    }

}
