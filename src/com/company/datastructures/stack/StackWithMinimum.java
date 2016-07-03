package com.company.datastructures.stack;

/**
 * Created by vnagpurkar on 7/2/16.
 */
public class StackWithMinimum {

    // How would you design a stack which, in addition to push and pop, also has a
    // function min which returns the minimum element? Push, pop and min should all
    // operate in 0(1) time.

    NodeWithMin[] elements;
    private static int SIZE = 100;
    int top;

    public StackWithMinimum() {
        elements = new NodeWithMin[SIZE];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int data) {
        if(top == SIZE-1) {
            throw new StackOverflowError();
        } else {
            int minimumNumber = elements[top].getMinimum();
            NodeWithMin newNode = new NodeWithMin();
            newNode.setData(data);
            if(data < minimumNumber) {
                minimumNumber = data;
            }
            newNode.setMinimum(minimumNumber);
            elements[++top] = newNode;
        }
    }

    public int pop() {
        if(top == -1) {
            throw new Error("Stack is empty");
        } else {
            return elements[top--].getData();
        }
    }

    public int peek() {
        if(top == -1) {
            throw new Error("Stack is empty");
        } else {
            return elements[top].getData();
        }
    }

    public int getMinimumNumber() {
        if(top == -1) {
            throw new Error("Stack is empty");
        } else {
            return elements[top].getMinimum();
        }
    }

 }
