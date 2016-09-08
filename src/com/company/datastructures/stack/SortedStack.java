package com.company.datastructures.stack;

/**
 * Created by vnagpurkar on 7/2/16.
 */
// Write a program to sort a stack in ascending order (with biggest items on top).
// You may use at most one additional stack to hold items, but you may not copy the
// elements into any other data structure (such as an array). The stack supports the
// following operations: push, pop, peek, and isEmpty.
public class SortedStack {

    int[] data;
    int top;
    int SIZE = 10;

    public SortedStack(){
        data = new int[SIZE];
        top = -1;
    }

    public void push(int val) {
        if(top == -1) {
            this.data[++top]= val;
        } else if(top == SIZE-1){
            throw new Error("Stack is full");
        } else {
            java.util.Stack<Integer> temp = new java.util.Stack<Integer>();
            while(val < this.peek()) {
                temp.push(this.pop());
            }
            this.data[++top] = val;
            while(!temp.isEmpty()) {
                this.push(temp.pop());
            }
        }

    }

    public int pop() {
        int val = data[top];
        top = top - 1;
        return val;
    }

    public int peek() {
        if(!this.isEmpty()) {
            return data[top];
        }
        return -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

}
