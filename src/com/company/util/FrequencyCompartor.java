package com.company.util;

import java.util.Comparator;

/**
 * Created by vnagpurkar on 6/26/16.
 */
public class FrequencyCompartor implements Comparator<Frequency> {

    @Override
    public int compare(Frequency frequency1, Frequency frequency2) {

        if(frequency1 == null || frequency2 == null) return 0;
        if (frequency1.getFrequency() > frequency2.getFrequency()) return -1;
        if (frequency1.getFrequency() < frequency2.getFrequency()) return 1;
        return 0;
    }
}
