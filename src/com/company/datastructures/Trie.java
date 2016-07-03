package com.company.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vnagpurkar on 6/22/16.
 */
public class Trie {

    class TrieNode {

        // Map will have more than 2 values while working with character or integer Trie, this is boolean Trie
        // Only two values possible - true, false,
        // Hence any node can have at the most two children, hence this trie is similar to binary tree
        //Map<Boolean, TrieNode> nodes = new HashMap<Boolean, TrieNode>();
        private TrieNode[] children = new TrieNode[2]; // children[0] is 0 or left child, children[1] is 1 or right child
        private boolean isEnd;

        public TrieNode[] getChildren() {
            return this.children;
        }

        public TrieNode getNextTrieNode(Boolean value) {

            if(value)
            return children[1];

            return children[0];
        }

        public void insert(Boolean value, TrieNode node) {

            if(value) {
                children[1] = node;
            } else {
                children[0] = node;
            }
        }
    }

    TrieNode root = new TrieNode();

    public TrieNode getRoot() {
        return this.root;
    }

    public void insert(boolean value, boolean isEnd) {

        TrieNode next = new TrieNode();
        next.isEnd = isEnd;

        // inserting first node
        if(root.getChildren().length == 0) {
            root.insert(new Boolean(value), next);
        } else {
            // insert other nodes
            TrieNode current = root;
            while( true ) {

                TrieNode[] children = current.getChildren();
                if(value) {
                     if(children[1] == null) {
                         current.insert(value, next);
                         break;
                     } else {
                         current = children[1];
                     }
                } else {
                    if(children[0] == null) {
                        current.insert(value, next);
                        break;
                    } else {
                        current = children[0];
                    }
                }
            }
        }
    }

    // Print unique rows in a given boolean matrix
    public void printUniqueRows(boolean[][] booleanMatrix) {

        boolean isEnd;
        for(int row = 0; row<booleanMatrix.length; row++) {

            for(int col=0; col<booleanMatrix[row].length; col++) {

                isEnd = false;
                if(col == booleanMatrix[row].length - 1) {
                    isEnd = true;
                }
                insert(booleanMatrix[row][col], isEnd);
            }
        }

        TrieNode current = root;
    }
}
