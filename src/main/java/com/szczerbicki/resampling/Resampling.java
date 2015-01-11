package com.szczerbicki.resampling;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Pawel on 2014-12-14.
 */
public class Resampling {

    public Integer[][] resample(int resamplingAmount, Integer[][] originalData) {
        Set<Integer> selected = new HashSet<>();
        Integer[][] resampled = new Integer[resamplingAmount][originalData[0].length];
        if (resamplingAmount > originalData.length)
            throw new IllegalStateException("There is not enough samples");

        for (int i = 0; i < resamplingAmount; i++) {
            int position = getUniqueRandom(selected, originalData.length);
            System.arraycopy( originalData[position], 0, resampled[i], 0, originalData[position].length );
        }
        return resampled;
    }

    private int getUniqueRandom(Set<Integer> selected, int max) {
        Random random = new Random();
        int randomized;
        do {
            randomized = random.nextInt(max);
        } while (selected.contains(randomized));

        selected.add(randomized);
        return randomized;
    }
}
