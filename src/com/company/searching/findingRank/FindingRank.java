package com.company.searching.findingRank;

/**
 * Created by vnagpurkar on 7/26/16.
 */
public class FindingRank {
    /*
    Imagine you are reading in a stream of integers. Periodically, you wish to be able to
look up the rank of a number x (the number of values less than or equal to x). Implement
the data structures and algorithms to support these operations. That is, implement
the method track(int x), which is called when each number is generated,
and the method getRankOf'Number (int x), which returns the number of values
less than or equal to x (not including x itself).
     */

    //insert elements in binary search tree
    // property of binary search tree, for any given node, node.left < node.getData() and node.right > node.getData();
    // Hence, when we represent numbers in binary search tree form,
    // Rank of a number = number of elements less than or equal to x (not including x itself)
    // Hence, we can find Rank of a number by inorder traverse of the binary search tree

    private RankNode root;

    public void track(int x) {

        // insert number x in BST
        insertInBST(x, root);
    }

    public int getRankOf(int x) {

        return getRankOf(x);
    }

    private int getRankOfNode(int x, RankNode node) {

        if(node == null) return 0;

        if(node.getData() == x) {
            return node.getRank();
        }

        if(x < node.getData()) {
                // search in left subtree
                return getRankOfNode(x, node.getLeft());
        }
        else {
            //rank of leftSubtre + rank of root + rank of rightSubtree
            return node.getRank() + 1 + getRankOfNode(x, node.getRight());
        }
    }

    private RankNode insertInBST(int x, RankNode node) {

        if(node == null) {
            RankNode newNode = new RankNode(x);
            return newNode;
        }

        if(node.getData() == x) {
            return node;
        }

        if(x < node.getData()) {
            // there is a x which is less than node's data, hence rank of node will be increamented by 1
            node.setRank(node.getRank() + 1);
            node.setLeft(insertInBST(x, node.getLeft()));

        } else {
            node.setRight(insertInBST(x, node.getRight()));
        }
        return node;
    }
}