package com.company.datastructures;

/**
 * Created by vnagpurkar on 6/17/16.
 */
public class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public int getData() {
        return this.data;
    }
}
