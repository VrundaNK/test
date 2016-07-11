package com.company.searching;

import com.company.datastructures.graph.GraphNode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by vnagpurkar on 7/6/16.
 */
public class BredthFirstSearch {

    // Breadth First Search
    public static void bfs(GraphNode node) {

        java.util.Queue<GraphNode> queue = new PriorityQueue<GraphNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode current = queue.remove();
            if(!current.getVisited()) {
                System.out.println(current.getValue());
                current.setVisited(true);
            }

            List<GraphNode> adjacents = current.getAdj();
            for(GraphNode n : adjacents) {
                if(!n.getVisited()){
                    System.out.println(current.getValue());
                    current.setVisited(true);
                    queue.add(n);
                }
            }
        }
    }
}
