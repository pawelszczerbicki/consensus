package com.szczerbicki;


import com.szczerbicki.clustering.KmeansClustering;
import com.szczerbicki.resampling.Resampling;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * Created by Pawel on 2014-12-13.
 */
public class Consensus {
    private Integer[][] data;
    private List<boolean[][]> connectivityMatrix = new ArrayList<>();
    private List<boolean[][]> indicatorMatrix = new ArrayList<>();
    private Double[][] consensusMatrix;
    private int dataSize;
    private int groupsAmount;
    private int maxValue;
    private int minValue;
    private ExecutorService pool;

    public Consensus(Integer[][] data, int dataSize, int groupsAmount, int maxValue, int minValue, int threads) {
        this.data = data;
        this.dataSize = dataSize;
        this.groupsAmount = groupsAmount;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.pool = newFixedThreadPool(threads);
    }

    public Consensus start(int iterations, int resamplingAmount) {
        //TODO resapmling should return random subset of original data
        for (int i = 0; i < iterations; i++)
            runOnThread(resamplingAmount);
        pool.shutdown();
        try {
            pool.awaitTermination(500, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consensusMatrix(iterations);
        return this;
    }

    private void runOnThread(int resamplingAmount) {
        pool.execute(() ->
                connectivityMatrix.add(new KmeansClustering(new Resampling().resample(resamplingAmount, data), dataSize, groupsAmount, maxValue, minValue).perform().getConnectivityMatrix()));
    }

    public Double[][] getConsensusMatrix() {
        return consensusMatrix;
    }

    private void consensusMatrix(int iterations) {
//TODO iterations should contains sum in position for elements present in investiated data
        consensusMatrix = new Double[dataSize][dataSize];
        for (int i = 0; i < dataSize; i++)
            for (int j = 0; j < dataSize; j++)
                consensusMatrix[i][j] = (sumInPosition(connectivityMatrix, i, j) / iterations);
    }

    private Double sumInPosition(List<boolean[][]> matrices, Integer row, Integer col) {
        Double sum = 0d;
        for (boolean[][] matrix : matrices)
            if (matrix[row][col])
                sum++;
        return sum;
    }
}
