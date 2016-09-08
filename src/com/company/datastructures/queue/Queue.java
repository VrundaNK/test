package com.company.datastructures.queue;

import com.company.datastructures.TreeNode;

/**
 * Created by vnagpurkar on 6/19/16.
 */
public class Queue {

    int head = 0;
    int tail = 0;
    int maxSize = 100;
    int count = 0;

    TreeNode[] elements = new TreeNode[100];

    public boolean isEmpty() {

        return this.head == tail;
    }

    public boolean isFull() {

        return tail == maxSize;
    }

    public int size() {
        return this.count;
    }

    public void enque (TreeNode newNode) {
        if(head < maxSize) {
            elements[head] = newNode;
            head++;
            count = count + 1;
        } else {
            throw new StackOverflowError();
        }
    }

    public TreeNode deque() {

        TreeNode data = null;
        if(tail < maxSize) {
            data = elements[tail];
            tail ++;
            count = count - 1;
        }
        return data;
    }

    public TreeNode peek() {

        return elements[tail];
    }
}
