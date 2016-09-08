package com.company.datastructures.stack;

/**
 * Created by vnagpurkar on 7/2/16.
 */
public class StackUsingArray {

    // Describe how you could use a single array to implement three stacks
    int[] elements;
    private static int SIZE = 100;
    private static int STACKNUMBER = 3;
    int[] tops;

    public StackUsingArray() {

        elements = new int[SIZE*STACKNUMBER];
        tops = new int[STACKNUMBER];
        for(int i=0; i< tops.length; i++) {
            tops[i] = -1;
        }
    }

    public void push(int stackNumber, int data) {

        int maximumSize = ((stackNumber)*SIZE/STACKNUMBER) - 1;
        if(tops[stackNumber] == maximumSize) {
            throw new StackOverflowError();
        } else {
            tops[stackNumber] = tops[stackNumber]+1;
            elements[tops[stackNumber]] = data;
        }
    }

    public int pop(int stackNumber) throws Exception {
        if(tops[stackNumber] == -1) {
            throw new Exception("Stack is empty");
        } else {
            int data = elements[tops[stackNumber]];
            tops[stackNumber] = tops[stackNumber] - 1;
            return data;
        }
    }

    public int peek(int stackNumber) throws Exception{
        if(tops[stackNumber] == -1) {
            throw new Exception("Stack is empty");
        } else {
            return elements[tops[stackNumber]];
        }
    }
}
