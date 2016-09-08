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
        printBinaryTreeInOrder(root.left);
        System.out.println(root.getData());
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

    // delete a node from binary search tree
    public static TreeNode deleteANode(TreeNode root, int data) {

        if(root == null) return root;

        if(data < root.getData()) {
            if(root.left == null) {
                System.out.println(String.format("The data %d to delete is not present in tree", data));
            }
            root.left = deleteANode(root.left, data);
        } else if(data > root.getData()) {
            if(root.right == null) {
                System.out.println(String.format("The data %d to delete is not present in tree", data));
            }
            root.right = deleteANode(root.right, data);
        } else { // data == root.getData(), hence we need to delete root,
            // 1. node to delete is the leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // 2. node to delete has only one child
            else if(root.left == null) {
                root = deleteANode(root.right, data);
            } else if(root.right == null) {
                root = deleteANode(root.left, data);
            }
            // 3. node to delete has both children
            // find minimum of right subtree, and copy that minimum value at root.
            else {
                TreeNode temp = findMin(root.right, root.right);
                root.setData(temp.getData());
                root.right = deleteANode(root.right, temp.getData());
            }
        }
        return root;
    }

    private static TreeNode findMin(TreeNode root, TreeNode minimumValueNode) {

        if(root == null) return minimumValueNode;
        if(root.getData() < minimumValueNode.getData()) {
            root = findMin(root.left, root);
        }
        return root;
    }

    // find if binary tree is binary search tree
    public static boolean checkIfBinarySearchTree(TreeNode root) {

        return traverseInOrder(root, true);
    }

    private static boolean traverseInOrder(TreeNode root, boolean result) {

        if(root == null) {
            return true;
        }
        result = traverseInOrder(root.left, result);
        if(root.left!= null && root.left.getData() < root.getData()
           && root.right != null && root.right.getData() > root.getData()){
            result = result && true;
        } else {
            result = result && false;
        }
        result = traverseInOrder(root.right, result);

        return result;
    }


}
