package com.company.searching;

/**
 * Created by vnagpurkar on 6/23/16.
 */
public class Searching {

    // Binary search, is used to search a number in sorted array
    public static boolean isNumberPresentUsingBS (int[] input, int number) {

        int left = 0;
        int right = input.length - 1;
        int mid;

        while(left <= right) {

            mid = (left+right)/ 2;
            if (input[mid] == number) {
                return true;
            }
            if(number > input[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean binarySearchRecursive(int[] input, int x) {

        return binarySearchRecursive(input, 0, input.length-1, x);
    }

    private static boolean binarySearchRecursive(int[] input, int left, int right, int number) {

        if(left > right) return false;

        int mid = (left + right) / 2;

        if(input[mid] == number) {
            return true;
        }
        if(number > input[mid]) {
            return binarySearchRecursive(input, mid+1, right, number);
        } else {
            return binarySearchRecursive(input, left, mid-1, number);
        }
    }


}
