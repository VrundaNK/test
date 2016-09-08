package com.company.datastructures;

/**
 * Created by vnagpurkar on 6/17/16.
 */
public class DoublyLinkedNode<Integer> {

    DoublyLinkedNode<Integer> prev;
    int data;
    DoublyLinkedNode<Integer> next;

    public DoublyLinkedNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

}