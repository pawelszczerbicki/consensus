package com.szczerbicki.resampling;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Pawel on 2014-12-14.
 */
public class Resampling {

    public Integer[][] resample(int resamplingAmount, Integer[][] originalData) {
        Integer[][] resampled = originalData.clone();
        if (resamplingAmount > originalData.length)
            throw new IllegalStateException("There is not enough samples");

        for (int i = 0; i < resamplingAmount; i++) {
            int src = getUniqueRandom(originalData.length, null);
            int dst = getUniqueRandom(originalData.length, src);
            int col = Math.random() < 0.5 ? 1 : 0;
            Integer tmp = resampled[src][col];
            resampled[src][col] = resampled[dst][col];
            resampled[dst][col] = tmp;
        }
        return resampled;
    }

    private int getUniqueRandom(int max, Integer randomizedBefore) {
        Random random = new Random();
        int randomized;

        do randomized = random.nextInt(max);
        while (randomizedBefore != null && randomizedBefore == randomized);

        return randomized;
    }
}
