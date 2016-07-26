package com.company.searching;

import com.company.datastructures.TreeNode;
import com.company.datastructures.graph.GraphNode;
import com.company.datastructures.graph.GraphNodeQueue;
import com.company.datastructures.queue.Queue;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by vnagpurkar on 6/19/16.
 */
public class BreadthFirstSearch {

    // breadth first search for a tree
    public void breadthFirstSearchOnTree(TreeNode node) {

        if(node == null) return;
        Queue queue = new Queue();
        queue.enque(node);

        while( !queue.isEmpty() ) {
            node = queue.deque();
            System.out.print(node.getData() +",");
            if(node.getLeft() != null) {
                queue.enque(node.getLeft());
            }
            if(node.getLeft() != null) {
                queue.enque(node.getRight());
            }
        }
    }


    // breadth first search for a graph, using queue of graph nodes
    public void breadthFirstSearchOnGraph(GraphNode vertex) {

        if (vertex == null) return;
        GraphNodeQueue queue = new GraphNodeQueue();
        queue.enque(vertex);

        while( !queue.isEmpty() ) {
            vertex = queue.deque();
            System.out.print(vertex.getValue() +",");

            for(GraphNode graphNode : vertex.getAdj()) {
                if( !queue.isFull()) {
                    queue.enque(graphNode);
                }
            }
        }
    }

    // Breadth First Search, using java.util.Queue
    public void bfs(GraphNode node) {

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
                if(!n.getVisited()) {
                    System.out.println(current.getValue());
                    current.setVisited(true);
                    queue.add(n);
                }

            }
        }

    }
}
