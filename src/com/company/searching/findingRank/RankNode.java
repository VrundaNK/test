package com.company.searching.findingRank;

/**
 * Created by vnagpurkar on 7/26/16.
 */
public class RankNode {

    private int data;
    private RankNode left;
    private RankNode right;
    private int rank;

    public RankNode(int data) {

        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public RankNode getLeft() {
        return left;
    }

    public void setLeft(RankNode left) {
        this.left = left;
    }

    public RankNode getRight() {
        return right;
    }

    public void setRight(RankNode right) {
        this.right = right;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
