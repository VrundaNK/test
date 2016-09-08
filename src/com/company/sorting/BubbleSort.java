package com.company.sorting;

/**
 * Created by vnagpurkar on 6/22/16.
 */
public class BubbleSort {

    // sort numbers in ascending order
    public static void printBubbleSortedNumbers(int[] input) {

        int temp;

        for(int i=0; i< input.length; i++) {
            for(int j=i+1; j<input.length; j++) {

                if(input[i]>input[j]){
                    temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
        System.out.println();
        for(int i=0; i< input.length; i++) {
            System.out.print(input[i]+",");
        }
        System.out.println();
    }

    // sort numbers in descending order
    public static void printBubbleSortedNumbersDesc(int[] input) {

        int temp;

        for(int i=0; i<input.length; i++) {
            for(int j=i; j<input.length; j++) {

                if(input[i]<input[j]){
                    temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
        System.out.println();
        for(int i=0; i< input.length; i++) {
            System.out.print(input[i]+",");
        }
        System.out.println();
    }
}
