package com.company;

import java.util.Iterator;

/**
 * Created by vnagpurkar on 7/4/16.
 */
public class CircularArray<E> implements Iterable<E> {

    private E[] array;
    private int size;
    private int head;
    private int current;

    public CircularArray(int size) {
        this.size = size;
        array = (E[]) new Object[size];
    }

    private int convert(int index) {

        if(index < 0) {
            index = index+ array.length;
        }
        return (head + index) % array.length;
    }

    public E get(int index) {

        return array[convert(index)];
    }

    public void rotate(int rightShift) {

        this.head = convert(rightShift);
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public E next() {
                current = current + 1;
                if(current < size) {
                    return array[current];
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("...");
            }
        };
    }
}

