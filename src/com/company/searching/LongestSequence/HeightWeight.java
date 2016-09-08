package com.company.searching.LongestSequence;

import java.util.Comparator;

/**
 * Created by vnagpurkar on 7/26/16.
 */
public class HeightWeight implements Comparable<HeightWeight>{

    private int height;
    private int weight;

    public HeightWeight(int height, int weight){

        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o){

        if (this == null || o == null) return false;

        HeightWeight second = (HeightWeight) o;

        if(this.height == second.height) {
            if(this.weight == second.weight){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode(){

        int result = this.weight;
        result = 31 * result + this.height;

        return result;
    }

    @Override
    public int compareTo(HeightWeight o){

        if(o == null) {
            return 0;
        }
        if(this.getHeight() != o.getHeight()) {
            return ((Integer)this.getHeight()).compareTo(o.getHeight());
        }
        return ((Integer)this.getWeight()).compareTo(o.getWeight());
    }

    public boolean isBefore(HeightWeight o){

        if(o == null) return false;
        return (this.compareTo(o) == 1
                || this.compareTo(o) == 0);
    }

}
