package com.company.searching.LongestSequence;

import java.util.Comparator;

/**
 * Created by vnagpurkar on 7/26/16.
 */
public class HeightComparator implements Comparator<HeightWeight> {


    @Override
    public int compare(HeightWeight o1, HeightWeight o2){

        if(o1 == null || o2 == null) return 0;

        int height1 = o1.getHeight();
        int height2 = o2.getHeight();

        if(height1 > height2) {
            return 1;
        } else if(height1 < height2){
            return -1;
        }
        return 0;
    }
}
