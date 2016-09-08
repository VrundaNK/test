package com.company.Recursion;

/**
 * Created by vnagpurkar on 7/17/16.
 */
public class Box implements Comparable<Box>{

    private int height;
    private int weight;
    private int depth;

    public Box(int hight,  int weight, int depth) {
        this.height = hight;
        this.weight = weight;
        this.depth = depth;
    }

    public int getHight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public int compareTo(Box box2) {

        if(box2 == null) return 0;

        if(this.getHight() > box2.getHight()
                && this.getWeight() > box2.getWeight()
                && this.getDepth() > box2.getDepth()) {
            return -1;
        } else if(this.getHight() < box2.getHight()
                && this.getWeight() < box2.getWeight()
                && this.getDepth() < box2.getDepth()) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean canCreateAbove(Box bottom){

        // if this.compareTo(box2) >= 0, indicates that this <= bottom, hence bottom >= box,
        return this.compareTo(bottom) <= 0;
    }

}
