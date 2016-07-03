package com.company.sorting;

/**
 * Created by vnagpurkar on 6/22/16.
 */
public class InsertionSort {

    public static void printInsertionSort(int[] input) {

        int temp;
        for(int i=0; i<input.length; i++) {
            for(int j=i; j-1>=0; j--) {
                if(input[j] < input[j-1]) {
                    temp = input[j-1];
                    input[j-1]= input[j];
                    input[j] = temp;
                }
            }
        }

        System.out.println();
        for(int i=0; i<input.length; i++) {
            System.out.print(input[i]+",");
        }
        System.out.println();
    }
}
