package com.company.datastructures.queue;

import com.company.datastructures.linkedList.MyLinkedList;
import com.company.datastructures.linkedList.Node;

/**
 * Created by vnagpurkar on 7/2/16.
 */
public class QueueUsingLinkedList<E> {

    MyLinkedList<E> elements;
    Node<E> head;
    Node<E> tail;

    public QueueUsingLinkedList() {
        elements = new MyLinkedList<E>();
        head = null;
        tail = null;
    }

    public void enqueue(E data) {

        tail = elements.addAtTail(data);
        head = elements.getHead();
    }

    public E dequeue() throws Exception {

        if(head == null) {
            throw new Exception("Queue is empty!!!!");
        } else {
            Node<E> first = elements.getHead();
            elements.setHead(head.getNext());
            head = elements.getHead();
            return first.getData();
        }
    }
}
