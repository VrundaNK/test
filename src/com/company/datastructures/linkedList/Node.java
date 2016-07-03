package com.company.datastructures.linkedList;

/**
 * Created by vnagpurkar on 6/16/16.
 */
public class Node<E> {

    E data;
    Node next;

    public Node(E data) {

        this.data = data;
        this.next = null;
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return this.data;
    }

    public  Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
