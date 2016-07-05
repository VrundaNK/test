package com.company.datastructures;

import com.company.datastructures.graph.GraphNode;
import com.company.datastructures.graph.GraphNodeQueue;
import com.company.datastructures.queue.Queue;

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
            if(node.left != null) {
                queue.enque(node.left);
            }
            if(node.right != null) {
                queue.enque(node.right);
            }
        }
    }


    // breadth first search for a graph
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
}
