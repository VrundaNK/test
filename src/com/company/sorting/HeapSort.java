package com.company.sorting;

/**
 * Created by vnagpurkar on 6/24/16.
 */
public class HeapSort {

    public static void heapSort(int[] input) {

        // 1. max heapify
        input= heapify(input);
        System.out.println("Heap Sort Ascending");
        System.out.println();
        for(int i=0; i<input.length; i++) {
            System.out.print(input[i]+",");
        }
        System.out.println();
        // 2. sort using max heap property
        // in maxHeapify largest element will be present at root
        // hence, everytime we maxheapify place largest element in the array
        int temp;
        int n = input.length;
        for(int i=n-1; i>=0; i--) {
            temp = input[0];
            input[0] = input[i];
            input[i] = temp;
            input = maxHeapify(input, --n, 0);
        }
        System.out.println();
        for(int i=0; i<input.length; i++) {
            System.out.print(input[i]+",");
        }
        System.out.println();
    }

    private static int[] heapify(int[] input) {

        for(int i=input.length/2; i>=0; i--){
           input = maxHeapify(input, input.length,i);
        }
        return input;
    }

    private static int[] maxHeapify(int[] input, int n, int current) {

        int left = 2 * current + 1;
        int right = 2 * current + 2;
        int max = current;

        int temp;
        if(left < n && input[max] < input[left]) {
            max = left;
        }
        if(right < n && input[max] < input[right]) {
            max = right;
        }
        if(max != current) {
            temp = input[current];
            input[current] = input[max];
            input[max] = temp;
            input = maxHeapify(input, n, max);
        }
        return input;
    }

    public static void heapSortDesc(int[] input) {

        if(input == null || input.length == 0) return;
        // 1. heapify input (min heapify)
        input = heapify(input, input.length);
        System.out.println("Heap Sort Descending");
        System.out.println();
        for(int i=0; i<input.length; i++) {
            System.out.print(input[i]+",");
        }
        System.out.println();
        // 2. sort array
        int temp;
        int n = input.length;
        for(int i = n-1; i>=0; i--) {
            temp = input[0];
            input[0] = input[i];
            input[i] = temp;

            input = minHeapify(input, --n, 0);
        }
        System.out.println();
        for(int i=0; i<input.length; i++) {
            System.out.print(input[i]+",");
        }
        System.out.println();
    }

    private static int[] heapify(int[] input, int n) {

        for(int i=n/2; i>=0; i--) {
            input = minHeapify(input, n, i);
        }
        return input;
    }

    private static int[] minHeapify(int[] input, int n, int current) {

        int left = 2 * current + 1;
        int right = 2 * current + 2;
        int min = current;

        int temp;
        if(left < n && input[min] > input[left]) {
            min = left;
        }
        if(right < n && input[min] > input[right]) {
            min = right;
        }
        if(min != current) {
            temp = input[current];
            input[current] = input[min];
            input[min] = temp;
            input = minHeapify(input, n, min);
        }
        return input;
    }
}
