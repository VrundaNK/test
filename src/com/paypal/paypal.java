package com.paypal;

import com.company.datastructures.linkedList.MyLinkedList;
import com.company.datastructures.linkedList.Node;

/**
 * Created by vnagpurkar on 7/12/16.
 */
public class Paypal {

    // Replace element of an array with the nearest bigger number at the right side of an array in O(n)
    // input: {7, 5, 6, 3, 4, 1, 2, 9, 11}
    // output: {9, 6, 9, 4, 9, 2, 9, 11, -1}
    public static void printArray(int[] input) {

        int length = input.length;
        int current;
        int[] storage = new int[length];
        storage[length - 1] = input[length - 1];
        input[length - 1] = -1;
        int k = length - 1;
        for (int i = length - 2; i >= 0; i--) {
            current = input[i];
            while (k < input.length && k >= 0) {
                if (storage[k] > input[i]) {
                    storage[k - 1] = input[i];
                    input[i] = storage[k];
                    break;
                }
                k++;
            }
            storage[--k] = current;
        }

        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ",");
        }
        System.out.println();
    }

    // in linkedlist how to find 1/3 and 2/3 nodes efficiently
    public static void printOneThirdTwoThirdEfficiently(MyLinkedList<Integer> list) {
        Node<Integer> first = list.getHead();
        Node<Integer> second = first.getNext();
        Node<Integer> third = second.getNext();

        while(third.getNext() != null) {

            first = first.getNext();
            second = second.getNext().getNext();
            third = third.getNext().getNext().getNext();
        }

        System.out.println("1/3 of node = "+first.getData());
        System.out.println("2/3 of node = "+second.getData());
    }
}
