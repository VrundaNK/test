package com.company.datastructures.graph;

/**
 * Created by vnagpurkar on 6/20/16.
 */
public class GraphNodeQueue {

    int head = 0;
    int tail = 0;
    int maxSize = 100;
    int count = 0;

    GraphNode[] elements = new GraphNode[100];

    public boolean isEmpty() {

        return this.head == tail;
    }

    public boolean isFull() {

        return tail == maxSize;
    }

    public int size() {
        return this.count;
    }

    public void enque (GraphNode newNode) {
        if(head < maxSize) {
            elements[head] = newNode;
            head++;
            count = count + 1;
        } else {
            throw new StackOverflowError();
        }
    }

    public GraphNode deque() {

        GraphNode data = null;
        if(tail < maxSize) {
            data = elements[tail];
            tail ++;
            count = count - 1;
        }
        return data;
    }

    public GraphNode peek() {

        return elements[tail];
    }
}
