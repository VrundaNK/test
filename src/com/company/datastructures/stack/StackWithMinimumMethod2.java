package com.company.datastructures.stack;

/**
 * Created by vnagpurkar on 7/2/16.
 */
public class StackWithMinimumMethod2 extends java.util.Stack<Integer> {

    // How would you design a stack which, in addition to push and pop, also has a
    // function min which returns the minimum element? Push, pop and min should all
    // operate in 0(1) time.
    int[] minimums;
    private static int SIZE = 100;
    int top;

    public StackWithMinimumMethod2() {
        minimums = new int[SIZE];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int data) {
        if(top == SIZE-1) {
            throw new StackOverflowError();
        } else {
            if(data < minimums[top]) {
                minimums[++top] = data;
            }
            super.push(data);
        }
    }

    public Integer pop() {
        if(top == -1) {
            throw new Error("Stack is empty");
        } else {
            int value = super.pop();
            if(value == minimums[top]) {
               top--;
            }
            return value;
        }
    }

    public Integer peek() {
        if(top == -1) {
            throw new Error("Stack is empty");
        } else {
            return super.peek();
        }
    }

    public Integer getMinimumNumber() {
        if(top == -1) {
            throw new Error("Stack is empty");
        } else {
            return this.peek();
        }
    }
}
