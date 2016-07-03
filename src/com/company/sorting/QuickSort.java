package com.company.sorting;

/**
 * Created by vnagpurkar on 6/23/16.
 */
public class QuickSort {

    public static void printQuickSort(int[] input) {

        if(input == null || input.length == 0) return;

        input = quickSort(input, 0, input.length-1);

        System.out.println();
        for(int i=0; i<input.length; i++) {
            System.out.print(input[i]+",");
        }
        System.out.println();
    }

    private static int[] quickSort(int[] input, int left, int right) {

        int i = left;
        int j = right;
        int pivot = (left + right) / 2;
        int temp;

        while(i <= j) {

            while(input[i] < input[pivot]) {
                i++;
            }
            while(input[j] > input[pivot]) {
                j--;
            }
            if(i <= j) {
                temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }
        if(left < j) {
            input = quickSort(input, left, j);
        }
        if(i < right) {
            input = quickSort(input, i, right);
        }
        return input;
    }
}
