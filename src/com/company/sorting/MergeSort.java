package com.company.sorting;

/**
 * Created by vnagpurkar on 7/6/16.
 */
public class MergeSort {

    public static int[] mergeSort(int[] input) {

        int[] helper = new int[input.length];
        return mergeSort(input, helper, 0, input.length-1);
    }

    private static int[] mergeSort(int[] input, int[] helper, int left, int right) {

        if(left < right) {

            int middle = (left + right)/2;
            mergeSort(input, helper, left, middle);
            mergeSort(input, helper, middle+1, right);
            input = merge(input, helper, left, middle, right);
        }
        return input;
    }

    private static int[] merge(int[] input, int[] helper, int left, int middle, int right) {

        //1. copy both halves (left to middle-1 and middle- right) into helper
        for(int i=left; i<= right; i++) {

            helper[i] = input[i];
        }

        int helperLeft = left;
        int helperRight = middle+1;
        int current = left;

        // 2. compare two halves and merge back in input array
        // Iterate through helper array. Compare the left and right half,
        // copying back the smaller element from the two halves into the original array.
        while(helperLeft <= middle && helperRight <= right) {

            if(helper[helperLeft] <= helper[helperRight]) {
                input[current] = helper[helperLeft];
                helperLeft++;
            } else {
                input[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        // 3. copy remaining elements if any from left array
        // Copy the rest of the left side of the array into the target array
        while(helperLeft <= middle) {
            input[current] = helper[helperLeft];
            helperLeft++;
            current++;
        }
        return input;
    }
}
