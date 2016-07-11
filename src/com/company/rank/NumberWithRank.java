package com.company.rank;

/**
 * Created by vnagpurkar on 7/6/16.
 */
public class NumberWithRank {

    int number;
    int rank;

    public NumberWithRank(int number) {
        this.number = number;
        this.rank = 0;
    }

    public int getNumber() {
        return number;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
