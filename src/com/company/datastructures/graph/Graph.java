package com.company.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

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

    // Given a directed graph, design an algorithm to find out whether there is a route between two nodes
    // This can be doen by doing Depth First Search and Breadth First Search

    // Using BFS - Breadth First Search
    public static boolean isRouteBetweenNodesBFS(GraphNode vertex, GraphNode node1, GraphNode node2) {

        if(node1== null || vertex == null || node2 == null) return false;

        GraphNodeQueue queue = new GraphNodeQueue();
        node1.setVisiting(true);
        queue.enque(node1);

        GraphNode current;
        while (!queue.isEmpty()) {

            current = queue.deque();
            List<GraphNode> adjacents = current.getAdj();
            for(GraphNode g: adjacents) {
                if(!g.getVisiting()) {
                    if (g == node2){
                        return true;
                    }else{
                        g.setVisiting(true);
                        queue.enque(g);
                    }
                }
            }
            current.setVisited(true);
        }
        return false;
    }

    // Using DFS - Depth First Search
    public static boolean isRouteBetweenNodesDFS(GraphNode vertex, GraphNode node1, GraphNode node2) {

        if(node1== null || vertex == null || node2 == null) return false;

        java.util.Stack<GraphNode> stack = new java.util.Stack<GraphNode>();
        node1.setVisiting(true);
        stack.push(node1);

        GraphNode current;
        while (!stack.isEmpty()) {

            current = stack.pop();
            List<GraphNode> adjacents = current.getAdj();
            for(GraphNode g: adjacents) {
                if(!g.getVisiting()) {
                    if (g == node2){
                        return true;
                    }else{
                        g.setVisiting(true);
                        stack.push(g);
                    }
                }
            }
            current.setVisited(true);
        }
        return false;
    }

}
