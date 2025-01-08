package com.company;

import java.util.HashMap;

public class Network {
    private int layersNum;
    private HashMap<Integer, Layer> network;
    private Layer lastLayer;

    public Network(Layer ... layers) {
        layersNum = layers.length;
        network = new HashMap<>();

        for(int i=0;i<layersNum;i++) {
            assert i <= 1 || network.get(i).getInputDimension() == network.get(i - 1).getOutputDimension();
            network.put(i+1, layers[i]);
        }

        lastLayer = network.get(layersNum);
        lastLayer.setLastLayer();
    }

    public int getSize() {
        return layersNum;
    }

    public double[] predict(double[] input) {
        double[] result = input;
        int layerNum = 1;
        for(int key : network.keySet()) {
            Layer layer = network.get(key);
            result = layer.forwardPropagation(result);
            //System.out.println("LAYER " + layerNum++);
            for(double d : result) System.out.print(d + " ");
            System.out.println();
        }
        return result;
    }

    public double[][] predict(double[][] input) {
        double[][] result = input;  // 초기 입력 데이터

        for (int key : network.keySet()) {
            Layer layer = network.get(key);
            result = layer.forwardPropagation(result);  // 현재 레이어의 결과를 다음 레이어로 전달
            /*
            for (double[] a : result) {
                for (double b : a) {
                    System.out.print(b + " ");
                }
                System.out.println();
            }
            */
        }
        return result;
    }



}
