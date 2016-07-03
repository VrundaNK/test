package com.company.datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vnagpurkar on 6/19/16.
 */
public class BinarySearchTree {

    TreeNode root;

    public TreeNode getRoot() {
        return this.root;
    }

    public void add(int data) {
        this.root = insertRecursively(root, data);
    }

    private TreeNode insertRecursively(TreeNode node, int data) {

        TreeNode current = new TreeNode(data);
        if(node == null) {
            node = current;
        }
        else if(node.getData() < data) {
            node.right = insertRecursively(node.right, data);
        } else {
            node.left = insertRecursively(node.left, data);
        }
        return node;
    }

    public void printBinaryTreeInOrder(TreeNode root) {

        if(root == null) return;
        System.out.println(root.getData());
        printBinaryTreeInOrder(root.left);
        printBinaryTreeInOrder(root.right);
    }

    // Find sum/pair in BST
    public static void printSumPairInBST(TreeNode root, int sum) {

        if(root == null) return;
        // 1. Read binary search tree in InOrder so that numbers are stored in array
        Set<Integer> numbers= inOrder(root, new HashSet<Integer>());
        // 2.
        int secondNumber;
        for(Integer i: numbers) {
            secondNumber = sum - i;
            if(numbers.contains(secondNumber)) {
                System.out.println(String.format("Sum Pair in BST = (%d, %d)",i,secondNumber));
            }
        }
    }

    private static Set<Integer> inOrder(TreeNode root, Set<Integer> numbers) {

        if(root == null) return numbers;

        numbers = inOrder(root.left, numbers);
        numbers.add(root.getData());
        numbers = inOrder(root.right, numbers);

        return numbers;

    }
}
