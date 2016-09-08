package com.company.datastructures.stack;

import com.company.datastructures.linkedList.MyLinkedList;
import com.company.datastructures.linkedList.Node;

/**
 * Created by vnagpurkar on 7/2/16.
 */
// stack implementation using linked list
public class Stack<E> {

    MyLinkedList<E> elements;
    Node<E> top = null;

    public Stack() {
        elements = new MyLinkedList<E>();
    }

    public boolean isEmpty() {

        return this.top == null;
    }

    public void push(E data) {

        elements.addAtBegining(data);
        top = elements.getHead();
    }

    public E pop() throws Exception{

        if(top == null) {
            throw new Exception("Stack is empty!!!!");
        } else {
            E data = top.getData();
            elements.setHead(top.getNext());
            top = elements.getHead();
            return data;
        }
    }

    public E peek() throws Exception {

        if(top == null) {
            throw new Exception("Stack is empty!!!");
        } else {
            E data = top.getData();
            return data;
        }
    }

}
