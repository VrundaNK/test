package com.company.datastructures;

import java.util.Iterator;

/*
Implement a Circular Array class that supports an array-like data structure which
can be efficiently rotated. The class should use a generic type, and should support
iteration via the standard for (Obj o : circuLarArray) notation.
 */
public class CircularArray<T> implements Iterable<T> {

    private int size;
    private int head = 0;
    private T[] circularArray;
    private int count = 0;

    public CircularArray(int size) {

        this.size = size;
        circularArray = (T[]) new Object[size];
    }

    /*
     current reflects the offset from the rotated head, not from the actual start of the raw array.
     */
    public void add(T data, int index){

        circularArray[convert(index)] = data;

    }

    public T get(int index) {

        if(index < 0 || index >= size-1) {
            throw new ArrayIndexOutOfBoundsException("Index out of bound");
        }
        return circularArray[convert(index)];
    }

    public void rotate(int rightShift) {

        head = convert(rightShift);
    }

    private int convert(int index) {

        if(index < 0) {
            index = index+size;
        }

        return (head+index)%size;
    }

    @Override
    public Iterator<T> iterator() {

        count = 0;
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {

                return count < size;
            }

            @Override
            public T next() {

                T value = circularArray[convert(count)];
                count++;
                return value;
            }

            @Override
            public void remove() {

                throw new UnsupportedOperationException();
            }
        };
    }
}