package com.company.datastructures;

import com.company.datastructures.queue.Queue;

import java.util.Stack;

/**
 * Created by vnagpurkar on 6/17/16.
 */
public class BinaryTree {

    TreeNode root;
    Queue temp = new Queue();

    public TreeNode getRoot() {
        return this.root;
    }

    /*public void add(int data) {
        add(this.root, data);
    }*/

    //Linked complete binary tree & its creation
    public void add( int data) {

        TreeNode current = new TreeNode(data);
        if(temp.isEmpty() && root == null) {
            root = current;
            temp.enque(current);
        } else {

            while( !temp.isEmpty()) {
                TreeNode position = temp.peek();
                if(position.left == null) {
                    position.left = current;
                    temp.enque(current);
                    break;
                } else if(position.right == null) {
                    position.right = current;
                    temp.enque(current);
                    break;
                } else {
                    position = temp.deque();
                }
            }
        }
    }

    public void printBinaryTreePreOrder(TreeNode root) {

        if(root == null) return;
        System.out.print(root.getData() +",");
        printBinaryTreePreOrder(root.left);
        printBinaryTreePreOrder(root.right);
    }

    public void printBinaryTreeInOrder(TreeNode root) {

        if(root == null) return;
        printBinaryTreeInOrder(root.left);
        System.out.print(root.getData() +",");
        printBinaryTreeInOrder(root.right);
    }

    public void printBinaryTreePostOrder(TreeNode root) {

        if(root == null) return;
        printBinaryTreePostOrder(root.left);
        printBinaryTreePostOrder(root.right);
        System.out.print(root.getData()+",");
    }

    // Find size of the tree
    public void printSizeOfTree(TreeNode root) {

        System.out.println("Size of tree is "+size(root));
    }

    private int size(TreeNode root) {

        if(root == null) return 0;
        return ( size(root.left) + 1 + size(root.right));
    }

    // Write Code to Determine if Two Trees are Identical
    public boolean areIdentical(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null) return true;

        return (root1.getData() == root2.getData())
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right);
    }

    // Write a Program to Find the Maximum Depth or Height of a Tree
    public int getMaxDepthOfTree(TreeNode root) {

        if(root == null) return 0;

        return (max(getMaxDepthOfTree(root.left), getMaxDepthOfTree((root.right))) + 1);

    }

    private int max(int number1, int number2) {

        if(number1 >= number2) return number1;
        else return number2;

    }

    // Iterative Preorder Traversal | Set 1
    public void nonRecursivePreOrder(TreeNode root) {

        if(root == null) return;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);

        while( !nodeStack.isEmpty()) {
            root = nodeStack.peek();
            System.out.print(nodeStack.pop().getData() + ",");

            if (root.right != null) {
                nodeStack.push(root.right);
            }
            if (root.left != null) {
                nodeStack.push(root.left);
            }
        }
    }

    // Iterative Postorder Traversal | Set 1 (Using Two Stacks)
    public void nonRecursivePostOrder(TreeNode root) {

        Stack<TreeNode> nodeStack1 = new Stack<TreeNode>();
        Stack<TreeNode> nodeStack2 = new Stack<TreeNode>();
        nodeStack1.push(root);

        while( !nodeStack1.isEmpty() ) {

            root = nodeStack1.pop();
            nodeStack2.push(root);
            if(root.left != null) {
                nodeStack1.push(root.left);
            }
            if(root.right != null) {
                nodeStack1.push(root.right);
            }
        }

        while ( !nodeStack2.isEmpty() ) {
            System.out.print(nodeStack2.pop().getData() +",");
        }
    }

    // Iterative Postorder Traversal | Set 2 (Using One Stack)
    public void nonRecursivePostOrderUsingOneStack(TreeNode root) {

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode temp;

        while(root != null) {
            if(root.right != null) {
                nodeStack.push(root.right);
            }
            nodeStack.push(root);
            root = root.left;
        }

        while( !nodeStack.isEmpty() ) {
            root = nodeStack.pop();
            if(!nodeStack.isEmpty()
                    && root.right != null
                    && root.right.getData() == nodeStack.peek().getData()) {
                temp = root;
                root = nodeStack.pop();
                System.out.print(root.getData() +",");
                nodeStack.push(temp);
            } else {
                System.out.print(root.getData()+",");
            }
        }
    }

    public void nonRecursiveInOrder(TreeNode root) {

        if(root == null) return;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        while(true) {
            while( root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            if(!nodeStack.isEmpty()) {
                root = nodeStack.pop();
                System.out.print(root.getData() +",");
                root = root.right;
            } else {
                break;
            }
        }
    }
}
