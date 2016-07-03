package com.company.sorting;

/**
 * Created by vnagpurkar on 6/23/16.
 */
public class SelectionSort {

    public static void printSelectionSort(int[] input) {

        if(input == null || input.length == 0) return;

        int temp;
        int minimum;
        for(int i=0; i<input.length; i++) {
            minimum = i;
            for(int j=i; j<input.length; j++) {
                if(input[j] < input[minimum]){
                    temp = minimum;
                    minimum = j;
                    j= temp;
                }
            }
            temp = input[i];
            input[i] = input[minimum];
            input[minimum] = temp;
        }

        System.out.println();
        for(int i=0; i<input.length; i++) {
            System.out.print(input[i]+",");
        }
        System.out.println();
    }
}
