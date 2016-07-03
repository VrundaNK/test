package com.company.datastructures;

import java.util.Stack;

/**
 * Created by vnagpurkar on 6/19/16.
 */
public class DepthFirstSearch {

    // Depth First Search on graph
    public void depthFirstSearchOnGraph(GraphNode vertex) {

        if (vertex == null) return;

        Stack<GraphNode> stack = new Stack<GraphNode>();

        stack.push(vertex);
        vertex.visited = true;

        while( !stack.isEmpty() ) {
            vertex = stack.pop();
            System.out.print(vertex.getValue() + ",");

            for(GraphNode graphNode : vertex.adj) {
                if(!graphNode.visited) {
                    stack.push(graphNode);
                    graphNode.visited = true;
                }
            }
        }
    }
}
