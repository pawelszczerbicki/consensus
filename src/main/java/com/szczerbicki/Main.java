package com.szczerbicki;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello clustering");
        new Main().start();
    }

    private void start() {
        int size = 99;
        int max = 1000;
        int groupsAmount = 3;

        printConsensus(new Consensus(generateRandomData(size, max), size, groupsAmount, max, 0).start(2, 2).getConsensusMatrix());
    }

    private void printConsensus(Double[][] consensusMatrix) {
        for (Double[] weights : consensusMatrix) {
            for (Double weight : weights) System.out.print(weight + ",");

            System.out.println("");
        }
    }

    private Integer[][] generateRandomData(int size, int max) {
        Integer data[][] = new Integer[size][2];
        Random rand = new Random();
        for (int row = 0; row < size; row++)
            for (int col = 0; col < 2; col++)
                data[row][col] = getRand(rand, row);
        for (Integer[] integers : data) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
        System.out.println("done");
        return data;
    }

    public int getRand(Random r, int index) {
        if (index < 33) return r.nextInt((100) + 1);
        if (index >=
                33 && index < 66) return r.nextInt((200) + 1) + 300;
        return r.nextInt((200) + 1) + 800;
    }
}