package com.company.datastructures;

import java.util.ArrayList;

/**
 * Created by vnagpurkar on 6/19/16.
 */
public class GraphNode {

    int value;
    ArrayList<GraphNode> adj;
    boolean visited;

    GraphNode(int value) {
        this.value = value;
        this.adj = new ArrayList<GraphNode>();
        this.visited = false;
    }

    public int getValue() {
        return this.value;
    }
}
