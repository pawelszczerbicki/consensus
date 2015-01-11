package com.szczerbicki;


import com.szczerbicki.clustering.KmeansClustering;
import com.szczerbicki.resampling.Resampling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2014-12-13.
 */
public class Consensus {
    private Integer[][] data;
    private List<boolean[][]> connectivityMatrix = new ArrayList<>();
    private List<boolean[][]> indicatorMatrix = new ArrayList<>();

    public Consensus(Integer[][] data) {
        this.data = data;
    }

    public void start(int groupsAmount, int resamplingAmount) {
        for (int i = 0; i < groupsAmount; i++) {
            Integer[][] resampled = new Resampling().resample(resamplingAmount, data);
            connectivityMatrix.add(new KmeansClustering().perform().getConnectivityMatrix());
        }
    }

    private Double[][] consensusMatrix() {
        Double[][] consensus = new Double[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                consensus[i][j] = (double) (sumInPosition(connectivityMatrix, i, j) / sumInPosition(indicatorMatrix, i, j));
        return consensus;
    }

    private Integer sumInPosition(List<boolean[][]> matrices, Integer row, Integer col) {
        Integer sum = 0;
        for (boolean[][] matrix : matrices)
            if (matrix[row][col])
                sum++;
        return sum;
    }
}
