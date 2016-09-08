package com.company.datastructures;

/**
 * Created by vnagpurkar on 6/26/16.
 */
public class Heap {

    // Given a binary min heap, insert a new member.
    public static void insertInBinaryMinHeap(int[] heap, int number) {

        System.out.println();
        for(int i=0; i<heap.length; i++) {
            System.out.print(heap[i] +",");
        }
        System.out.println();
        int count = 0;
        while(count < heap.length && heap[count] != 0) {
            count++;
        }
        if(count < heap.length -1) {
            heap[count] = number;
            insertWithMinHeapify(heap, count);
        } else {
            System.out.println("Heap is full cannot insert new element");
        }

        System.out.println();
        for(int i=0; i<heap.length; i++) {
            System.out.print(heap[i] +",");
        }
        System.out.println();
    }

    private static void insertWithMinHeapify(int[] heap,int current) {

        int parent;
        if(current%2 != 0) {
            parent = (current-1)/2;
        } else {
            parent = (current -2)/2;
        }

        if(parent >= 0 && heap[parent] > heap[current]) {
            int temp = heap[current];
            heap[current] = heap[parent];
            heap[parent] = temp;
            insertWithMinHeapify(heap, parent);
        }

    }

    // Given a binary max heap, insert a new member.
    public static void insertInBinaryMaxHeap(int[] heap, int newNumber) {

        System.out.println();
        for(int i=0; i<heap.length; i++) {
            System.out.print(heap[i] +",");
        }
        System.out.println();
        int count = 0;
        while(count < heap.length && heap[count] != 0) {
            count++;
        }
        // max heapify given number array
        for(int i=heap.length; i>=0; i--){
            heap = maxHeapify(heap,count, i);
        }
        for(int i=0; i<heap.length; i++) {
            System.out.print(heap[i] +",");
        }
        System.out.println();
        // insert new element in the array

        if(count < heap.length) {
            heap[count] = newNumber;
            insertWithMaxHeapify(heap, count);
        } else {
            System.out.println("Heap is full cannot insert new element");
        }

        System.out.println();
        for(int i=0; i<heap.length; i++) {
            System.out.print(heap[i] +",");
        }
        System.out.println();
    }

    private static int[] maxHeapify(int[] heap, int n, int current) {

        int left = 2 * current + 1;
        int right  = 2 * current + 2;
        int max = current;

        if(left < n && heap[left] > heap[current]) {
            max = left;
        }
        if(right < n && heap[right] > heap[current]) {
            max = right;
        }

        if(max != current) {
            int temp = heap[current];
            heap[current] = heap[max];
            heap[max] = temp;
            heap = maxHeapify(heap, n, max);
        }
        return heap;
    }

    private static void insertWithMaxHeapify(int[] heap, int current) {

        int parent;
        if(current %2 != 0) {
            parent = (current - 1) / 2;
        } else {
            parent = (current - 2) / 2;
        }

        if(parent >=0 && heap[parent] < heap[current]) {
            int temp = heap[parent];
            heap[parent] = heap[current];
            heap[current] = temp;
            insertInBinaryMaxHeap(heap, parent);
        }
    }
}
