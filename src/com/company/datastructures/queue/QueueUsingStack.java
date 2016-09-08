package com.company.datastructures.queue;

import java.util.Stack;

/**
 * Created by vnagpurkar on 6/29/16.
 */
public class QueueUsingStack<T> {

    // 1. Make EnQue expensive, Deque simple
    // use two stacks - newestStack and oldestStack
    // In Enqueue - elements are inserted newestStack at top and are reversed inserted (from top-> bottom) in oldestStack
    // while deQue - just oldestStack.pop()

    // 2. Make DeQueue operation expensive and EnQue simple
    // use two stacks - newestStack and oldestStack
    // In Enqueue - newestStack.push(new element) i.e. elements are inserted newestStack at top
    // In Dequeue - elements are reversed inserted (from top-> bottom) in oldestStack, then return oldestStack.pop()

    private Stack<T> newestStack;
    private Stack<T> oldestStack;

    public QueueUsingStack(){

        newestStack = new Stack<T>();
        oldestStack = new Stack<T>();
    }

    public int getSize(){

        return newestStack.size()+oldestStack.size();
    }

    public void enQueue(T data){

        newestStack.push(data);
    }

    private void reverseInsertInOldestStack(){

        while(!newestStack.isEmpty()) {

            oldestStack.push(newestStack.pop());
        }
    }

    public T deQueue(){

        if(!oldestStack.isEmpty()){
            return oldestStack.pop();
        }
        return null;
    }

    public T peek() {

        if(!oldestStack.isEmpty()){
            return oldestStack.peek();
        }
        return null;
    }
}
