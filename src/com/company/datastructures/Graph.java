package com.company.datastructures;

import java.util.ArrayList;

/**
 * Created by vnagpurkar on 6/20/16.
 */
public class Graph {

    GraphNode vertex;

    public GraphNode getVertex() {
        return this.vertex;
    }

    public void populateGraph() {

        GraphNode node1 = new GraphNode(1);
        this.vertex = node1;
        GraphNode node2 = new GraphNode(3);
        ArrayList<GraphNode> adj = new ArrayList<GraphNode>();
        adj.add(node2);
        node1.adj = adj;

        node1 = new GraphNode(2);
        adj = new ArrayList<GraphNode>();
        adj.add(node1);
        node2.adj = adj;

        node2 = new GraphNode(4);
        adj = new ArrayList<GraphNode>();
        adj.add(node2);
        node1.adj = adj;

        node1 = new GraphNode(6);
        adj = new ArrayList<GraphNode>();
        adj.add(node1);
        node2.adj = adj;

        node2 = new GraphNode(5);
        adj = new ArrayList<GraphNode>();
        adj.add(node2);
        node1.adj = adj;

        node1 = new GraphNode(7);
        adj = new ArrayList<GraphNode>();
        adj.add(node1);
        GraphNode node3 = new GraphNode(21);
        adj.add(node3);
        node2.adj = adj;

        GraphNode node4 = new GraphNode(9);
        GraphNode node5 = new GraphNode(11);
        adj = new ArrayList<GraphNode>();
        adj.add(node4);
        adj.add(node5);
        node1.adj = adj;

        node4 = new GraphNode(12);
        adj = new ArrayList<GraphNode>();
        adj.add(node4);
        node3.adj = adj;

    }

}
