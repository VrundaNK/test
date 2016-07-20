package com.company.datastructures;

import com.company.datastructures.queue.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    // Implement a function to check if a binary tree is balanced. For the purposes of this
    // question, a balanced tree is defined to be a tree such that the heights of the two
    // subtrees of any node never differ by more than one.
    public static boolean isBalanced (TreeNode root) {

        int height = checkHeight(root);
        if(height == -1 ) {
            return false; // tree is not balanced
        } else {
            return true;
        }
    }

    private static int checkHeight(TreeNode root) {

        // let's assume checkHeight returns -1 when tree is not balanced
        if(root == null) {
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1) {
            return -1; // tree is not balanced
        }
        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1) {
            return -1;
        }
        int heightDiff = leftHeight - rightHeight;
        if(heightDiff > 1) {
            return -1; // tree is not balanced
        } else {
            return Math.max(checkHeight(root.left),checkHeight(root.right)) + 1;
        }
    }

    // Given a sorted (increasing order) array with unique integer elements, write an algorithm
    // to create a binary search tree with minimal height.
    // BST with minimal height, implies that middle element of the sorted array should be height of the tree,
    // so that half elements (left subtree) are lesser than root and helf elements (right subtree) are higher
    // than root.
    public static void printBSTWithMinimalHeight(int[] input) {

        TreeNode root = createBSTWithMinimalHeight(input, 0, input.length-1);

        System.out.println();
        printBSTInPostOrder(root);
        System.out.println();

    }

    private static TreeNode createBSTWithMinimalHeight(int[] input, int start, int end) {

        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(input[mid]);
        treeNode.left = createBSTWithMinimalHeight(input, start, mid-1);
        treeNode.right = createBSTWithMinimalHeight(input, mid+1, end);

        return treeNode;
    }

    private static void printBSTInPostOrder(TreeNode root) {

        printBSTInPostOrder(root.left);
        printBSTInPostOrder(root.right);
        System.out.print(root.getData() +",");
    }

    // Implement a function to check if a binary tree is a binary search tree
    // Method 1.
    // 1. traverse the binary tree in "inorder", and store values in array
    // 2. if BST then inorder traversal should have sorted elements in the array in ascending order
    // 3. if no BST then inorder traversal should not have sorted elements in the array
    // 4. hence by checking if the array is sorted or not we can understand if the binary tree is BST or not
    public static boolean isBSTMethod1(TreeNode root) {

        int[] temp = isBSTMethod1(root, new int[]{}, 0);
        for(int i=0; i<temp.length-1; i++) {
            if(temp[i] > temp[i]+1) {
                return false;
            }
        }
        return true;
    }

    private static int[] isBSTMethod1(TreeNode root, int[] temp, int i) {

        if(root == null) return temp;
        temp = isBSTMethod1(root.left, temp, ++i);
        temp[i] = root.getData();
        temp = isBSTMethod1(root.right, temp, ++i);

        return temp;
    }

    // Implement a function to check if a binary tree is a binary search tree
    // Method 2.
    // 1. traverse the binary tree in "inorder", and just save the last_printed value
    // 2. in left and right traversals of the trees, compare values with last_printed value
    // 3. if left is greater than last_printed, then return false, no BST
    // 4. if right is smaller than last_printed, then return false, no BST
    // 5. otherwise return true, binary tree is BST
    public static void isBSTMethod2(TreeNode root) {

        boolean isBST = isBSTMethod2(root, Integer.MIN_VALUE);
    }

    private static boolean isBSTMethod2(TreeNode root, int last_printed) {

        if(root == null) return true;

        if(!isBSTMethod2(root.left, last_printed)) {
            return false;
        }
        if(root.getData() <= last_printed) {
            return false;
        }
        if(!isBSTMethod2(root.right, last_printed)) {
            return false;
        }
        return true;
    }

    // Implement a function to check if a binary tree is a binary search tree
    // Method 3.
    // root.left.getData() <= root.getData() < root.right.getData()
    // for every leftSubstree calculate max and then if current node's data is higher than max, then binary tree is not BST
    // for every rightSubtree calculate min and then if current node's data is smaller than or equal to min, then binary tree is not BST
    // otherwise binary tree is BST
    public static boolean isBSTMethod3(TreeNode root) {

        return isBSTMethod3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTMethod3(TreeNode root, int min, int max) {

        if(root == null) return true;

        if(root.getData() <= min || root.getData() > max) {
            return false;
        }
        if(!isBSTMethod3(root.left, min, root.getData()) && !isBSTMethod3(root.right, root.getData(), max)) {
            return false;
        }
        return true;
    }

    // Given a binary tree, design an algorithm which creates a linked list of all the nodes at
    // each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
    // Method1: modifying preorder traversal
    public static void createLinkedListAtLevel(TreeNode root) {

        List<LinkedList<TreeNode>> result = createLinkedListAtLevel(root, new ArrayList<LinkedList<TreeNode>>(), 0);
    }

    private static List<LinkedList<TreeNode>> createLinkedListAtLevel(TreeNode root, List<LinkedList<TreeNode>> result, int level) {

        if(root == null) return result;

        LinkedList<TreeNode> currentList = result.get(level);
        if(currentList == null) {
            currentList = new LinkedList<TreeNode>();
        }

        currentList.add(root);
        result.add(currentList);
        result = createLinkedListAtLevel(root.left, result, level+1);
        result = createLinkedListAtLevel(root.right, result, level+1);

        return result;
    }

    // Given a binary tree, design an algorithm which creates a linked list of all the nodes at
    // each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
    // Method2: modifying Breadth First Search traversal
    public static List<LinkedList<TreeNode>> createLinkedListAtLevelMethod2(TreeNode root) {

        if(root == null) return null;

        List<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        current.add(root);

        while(current.size() > 0) {

            result.add(current);
            LinkedList<TreeNode> parents = current; // saving current level and moving to next level

            current = new LinkedList<TreeNode>();
            for(TreeNode parent: parents) {
                if(parent.left != null) {
                    current.add(parent.left);
                }
                if(parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    // Write an algorithm to find the 'next'node (i.e., in-order successor) of a given of a given node in
    // a binary search tree. You may assume that each node has a link to its parent
    // TreeNodeWithParent is a class, where every node has left and right child and also a link to its parent

    // 1. Inorder = Left -> Root -> Right
    // 2. Let's assume, n is a current node then,
    // 3. if n is the currently visited node then we need to visit, n's right subtree,
    //    hence, the next node should be leftmost node from it's right subtree
    // 4. if n does not have right subtree, then we are done with n node and we should move to parent of n node
    // 5. let's assume q is parent of n,
    //  5.1 if n is left child of q , then next node is q
    //  5.2 if n is the right child of q, then we are done with q, we should move to parent of q.
    // repeat step 5, 5.1, 5.2
    public static TreeNodeWithParent findNextNodeRecur(TreeNodeWithParent currentNode) {

        if(currentNode.getRight() != null) { // step 3
            return leftMostNodeInRightSubTree(currentNode);
        } else {

            TreeNodeWithParent parent = currentNode.getParent();
            while(parent != null) {
                if (currentNode == parent.getLeft()) { // step 5.1
                    return parent;
                } else {
                    currentNode = parent; // step 5.2
                    parent = currentNode.getParent();
                }
            }
        }
        return null;
    }

    private static TreeNodeWithParent leftMostNodeInRightSubTree(TreeNodeWithParent node) {

       while(node.getLeft() != null) {
           node = node.getLeft();
       }
       return node;
   }

    // Write an algorithm to find the 'next'node (i.e., pre-order successor) of a given of a given node in
    // a binary search tree. You may assume that each node has a link to its parent
    // TreeNodeWithParent is a class, where every node has left and right child and also a link to its parent
    // 1. Preorder = Root -> Left -> Right
    // 2. Let's assume, n is a current node then,
    // 3. n is root and is the currently visited node then we need to visit, n's left subtree,
    //    hence, the next node should be left child of n node
    // 4. if n does not have left child, then we need to visit, n's right subtree,
    //    hence, the next node should be right child of n node
    // 5. if n does not have right child, then we are done with n node and we should move to parent of n node
    // 6. let's assume q is parent of n,
    //  6.1 if q has right child, then next node is right child of q
    //  6.2 if q does not have the right child, then we are done with q, we should move to parent of q.
    // repeat step 6, 6.1, 6.2
    public static TreeNodeWithParent findNextNodeRecurPreOrder(TreeNodeWithParent currentNode) {

       if(currentNode.getLeft() != null) {
           return currentNode.getLeft();
       } else if(currentNode.getRight() != null) {
           return currentNode.getRight();
       } else {
           TreeNodeWithParent parent = currentNode.getParent();
           while(parent != null) {
               if(parent.getRight() != null) {
                   return parent.getRight();
               } else {
                   currentNode = parent;
                   parent = currentNode.getParent();
               }
           }
       }
        return null;
    }

    // You have two very large binary trees: Tl, with millions of nodes, and T2, with hundreds of nodes.
    // Create an algorithm to decide if T2 is a subtree of Tl.
    // A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n
    // is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical
    public static boolean t1ContainsT2(TreeNode t1, TreeNode t2) {

        if(t2 == null) return false;
        return isSubTree(t2, t2);
    }

    private static boolean isSubTree(TreeNode t1, TreeNode t2) {

        if(t1 == null) return false;

        if(t1.getData() == t2.getData()) {
            return matchTree(t1, t2);
        }
        return (isSubTree(t1.left, t2.left) || isSubTree(t1.right, t2.right));
    }

    private static boolean matchTree(TreeNode t1, TreeNode t2) {

        if(t1 == null && t2 == null) return true;

        if(t1 == null || t2 == null) return false;

        if(t1.getData() != t2.getData()) return false;

        return (matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right));
    }

    // Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
    // Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
    public static TreeNode firstCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {

        if(root == null) return null;
        if(root == node1 || root == node2) return root;

        boolean isOnLeftNode1 = isRootDescendentOfNode(root.left, node1);
        boolean isOnLeftNode2 = isRootDescendentOfNode(root.left, node2);

        // both nodes, node1 and node2 are on different sides then, root is first common ancestor
        if(isOnLeftNode1 != isOnLeftNode2) {
            return root;
        }

        // if both nodes are on left side then find common ancestor on left side
        TreeNode child_side;
        if(isOnLeftNode1 && isOnLeftNode2) {
            child_side = root.left;
        } else {
            child_side = root.right;
        }
        return firstCommonAncestor(child_side, node1, node2);
     }

    private static boolean isRootDescendentOfNode(TreeNode root, TreeNode node) {

        if(root == null) return false;
        if(root == node) return true;

        return (isRootDescendentOfNode(root.left, node) || isRootDescendentOfNode(root.right, node));
    }
}
class TreeNodeWithParent {

    private int data;
    private TreeNodeWithParent left;
    private TreeNodeWithParent right;
    private TreeNodeWithParent parent;

    public TreeNodeWithParent(int data, TreeNodeWithParent parent) {
        this.data = data;
        left = null;
        right = null;
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNodeWithParent getLeft() {
        return left;
    }

    public void setLeft(TreeNodeWithParent left) {
        this.left = left;
    }

    public TreeNodeWithParent getRight() {
        return right;
    }

    public void setRight(TreeNodeWithParent right) {
        this.right = right;
    }

    public TreeNodeWithParent getParent() {
        return parent;
    }

    public void setParent(TreeNodeWithParent parent) {
        this.parent = parent;
    }
}
