package com.company.datastructures.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vnagpurkar on 7/2/16.
 */
public class SetOfStacks {

    List<stack<Integer>> elements;
    int top;
    int lastStackIndex;
    private static int threshold = 10;

    public SetOfStacks() {

        lastStackIndex = -1;
        top = -1;
        elements = new ArrayList<stack<Integer>>();
        addNewStack();
    }

    private stack<Integer> addNewStack() {

        lastStackIndex = lastStackIndex+1;
        elements.add(new stack<Integer>(threshold));
        return elements.get(lastStackIndex);
    }

    private stack<Integer> getLastStack() {
        if(lastStackIndex == -1){
            throw new Error("SetOfStack is empty");
        }
        return elements.get(lastStackIndex);
    }

    private stack<Integer> getStackAt(int index) {
        if(index == -1){
            throw new Error("SetOfStack is empty");
        }
        return elements.get(index);
    }

    private void removeEmptyStack(int index){
        elements.remove(index);
        lastStackIndex = lastStackIndex--;
    }

    public void push (int data) {
        stack<Integer> lastStack = this.getLastStack();
        if(lastStack.isFull()){
            lastStack = addNewStack();
        }
        lastStack.push(data);
    }

    public int pop() {
        if(lastStackIndex == -1){
            throw new Error("SetOfStack is empty");
        }
        stack<Integer> lastStack = this.getLastStack();
        if(lastStack.isEmpty()) {
            removeEmptyStack(lastStackIndex);
        }
        lastStack = this.getLastStack();
        return lastStack.pop();
    }

    public int popAt(int stackIndex) {
        stack<Integer> currentStack = getStackAt(stackIndex);
        if(currentStack.isEmpty()) {
            System.out.println("Requested stack is empty");
        }
        int value = currentStack.pop();
        leftShiftElements(stackIndex);
        return value;
    }

    private void leftShiftElements(int currentStackIndex) {
        int total = elements.size();
        for(int i=currentStackIndex; i<total-1; i++){
            stack<Integer> currentStack = elements.get(i);
            stack<Integer> nextStack = elements.get(i+1);
            while(!currentStack.isFull() && !nextStack.isEmpty()) {
                currentStack.push(nextStack.getBottomElement());
                nextStack.leftShiftElementsByOne();
            }
        }
    }


    class stack<E> {

        int[] data;
        int top;
        int bottom;
        int maxSize;

        public stack(int capacity) {
            this.maxSize = capacity;
            data = new int[maxSize];
            bottom = 0;
            top = -1;
        }

        public int getTop() {
            return top;
        }

        public void push(int data) throws Error {
            if (top == maxSize) {
                throw new StackOverflowError();
            } else {
                this.data[++top] = data;
            }
        }

        public int pop() {
            int val = data[top];
            this.top = this.top-1;
            return val;
        }

        public int peek() {
            return data[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == maxSize-1;
        }

        public int getBottomElement() {
            if (this.top == -1) return -1;
            else {
                return data[bottom++];
            }
        }

        public void leftShiftElementsByOne() {

            for (int i = 0; i <top; i++) {
                data[i] = data[i+1];
            }
            bottom=0;
            top--;
        }
    }

}
