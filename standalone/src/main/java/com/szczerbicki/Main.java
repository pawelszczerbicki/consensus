package com.szczerbicki;

import java.util.Random;

import static java.lang.Integer.parseInt;
import static java.lang.System.currentTimeMillis;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello clustering");
        new Main().start(parseInt(args[0]), parseInt(args[1]));
    }

    private void start(int threadsFrom, int threadsTo) {
        int size = 2000;
        int max = 1000;
        int groupsAmount = 3;

        Integer[][] data = generateRandomData(size, max);

        for (int i = threadsFrom; i <= threadsTo ; i++) run(size, max, groupsAmount, data, i);
    }

    private void run(int size, int max, int groupsAmount, Integer[][] data, int threads) {
        Consensus consensus2 = new Consensus(data, size, groupsAmount, max, 0, threads);
        long start2 = currentTimeMillis();
        consensus2.start(32, 2);
        System.out.println("Threads: " + threads + ", time [ms]: " + (currentTimeMillis() - start2));
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
//        for (Integer[] integers : data) {
//            for (Integer integer : integers) {
//                System.out.print(integer + ",");
//            }
//            System.out.println();
//        }
//        System.out.println("done");
        return data;
    }

    public int getRand(Random r, int index) {
        if (index % 3 == 0) return r.nextInt((100) + 1);
        if (index % 3 == 1) return r.nextInt((200) + 1) + 300;
        return r.nextInt((200) + 1) + 800;
    }
}