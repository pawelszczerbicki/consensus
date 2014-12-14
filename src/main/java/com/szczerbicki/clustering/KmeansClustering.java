package com.szczerbicki.clustering;

import java.util.ArrayList;

/**
 * Created by Pawel on 2014-12-14.
 */
public class KmeansClustering {

    private final int NUM_CLUSTERS = 3;
    private final int TOTAL_DATA = 7;

    private final double SAMPLES[][] = new double[][]{{1.0, 1.0},
            {1.5, 2.0},
            {3.0, 4.0},
            {5.0, 7.0},
            {3.5, 5.0},
            {4.5, 5.0},
            {3.5, 4.5}};

    private ArrayList<Data> dataSet = new ArrayList<>();
    private ArrayList<Centroid> centroids = new ArrayList<>();

    private void initialize() {
        centroids.add(new Centroid(1.0, 1.0));
        centroids.add(new Centroid(5.0, 7.0));
    }

    public KmeansClustering perform() {
        initialize();
        final double bigNumber = Math.pow(10, 10);
        double minimum;
        double distance;
        int sampleNumber = 0;
        int cluster = 0;
        boolean isStillMoving = true;
        Data newData;

        while (dataSet.size() < TOTAL_DATA) {
            newData = new Data(SAMPLES[sampleNumber][0], SAMPLES[sampleNumber][1]);
            dataSet.add(newData);
            minimum = bigNumber;
            for (int i = 0; i < NUM_CLUSTERS; i++) {
                distance = dist(newData, centroids.get(i));
                if (distance < minimum) {
                    minimum = distance;
                    cluster = i;
                }
            }
            newData.cluster(cluster);

            for (int i = 0; i < NUM_CLUSTERS; i++) {
                int totalX = 0;
                int totalY = 0;
                int totalInCluster = 0;
                for (Data aDataSet : dataSet) {
                    if (aDataSet.cluster() == i) {
                        totalX += aDataSet.X();
                        totalY += aDataSet.Y();
                        totalInCluster++;
                    }
                }
                if (totalInCluster > 0) {
                    centroids.get(i).X(totalX / totalInCluster);
                    centroids.get(i).Y(totalY / totalInCluster);
                }
            }
            sampleNumber++;
        }

        while (isStillMoving) {
            for (int i = 0; i < NUM_CLUSTERS; i++) {
                int totalX = 0;
                int totalY = 0;
                int totalInCluster = 0;
                for (Data aDataSet : dataSet)
                    if (aDataSet.cluster() == i) {
                        totalX += aDataSet.X();
                        totalY += aDataSet.Y();
                        totalInCluster++;
                    }
                if (totalInCluster > 0) {
                    centroids.get(i).X(totalX / totalInCluster);
                    centroids.get(i).Y(totalY / totalInCluster);
                }
            }

            isStillMoving = false;

            for (Data tempData : dataSet) {
                minimum = bigNumber;
                for (int j = 0; j < NUM_CLUSTERS; j++) {
                    distance = dist(tempData, centroids.get(j));
                    if (distance < minimum) {
                        minimum = distance;
                        cluster = j;
                    }
                }
                tempData.cluster(cluster);
                if (tempData.cluster() != cluster) {
                    tempData.cluster(cluster);
                    isStillMoving = true;
                }
            }
        }
        return this;
    }

    public boolean[][] getConnectivityMatrix() {
        return toConnectivityMatrix();
    }

    private double dist(Data d, Centroid c) {
        return Math.sqrt(Math.pow((c.Y() - d.Y()), 2) + Math.pow((c.X() - d.X()), 2));
    }

    private boolean[][] toConnectivityMatrix() {
        boolean[][] connectivity = new boolean[dataSet.size()][dataSet.size()];
        for (Data data : dataSet)
            dataSet.stream().filter(data1 -> data.cluster() == data1.cluster()).forEach(data1 -> connectivity[dataSet.indexOf(data)][dataSet.indexOf(data1)] = true);
        return connectivity;
    }
}
