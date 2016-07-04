package com.company.searching;

import com.company.datastructures.graph.GraphNode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by vnagpurkar on 6/23/16.
 */
public class Searching {

    public static boolean isNumberPresentUsingBS (int[] input, int number) {

        boolean isPresent = false;
        int left = 0;
        int right = input.length - 1;
        int mid;

        while(left <= right) {

            mid = (left + right) / 2;
            if(number == input[mid]) {
                isPresent = true;
                break;
            }
            if(number > input[mid]) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return isPresent;
    }

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
