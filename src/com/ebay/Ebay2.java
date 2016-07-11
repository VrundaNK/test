package com.ebay;

/**
 * Created by vnagpurkar on 7/7/16.
 */
public class Ebay2 {

    // find number of 1s in 32 bit integer
    public static int numberOfOnes(int number) {

        int count = 0;
        while(number > 0) {

            number = number & (number-1);
            count++;
        }

        return count;
    }

    // Given a sorted integer array and a number, find the start and end indexes of n in the array
    public static void printStartAndEndIndexesOfN(int[] array, int n) {

        // 1. find first occurrence of number n using binary search
        int start = findFirstIndexUsingBinarySearch(array, n, 0, array.length-1);
        if(start == -1) {
            System.out.println("Element is not present in array");
        } else {
            // 2. find last occurrence of number n using binary search
            int end = findLastIndexUsingBinarySearch(array, n, start, array.length - 1);
            if(start == end) // only one occurance of n
            {
                System.out.println(String.format("{ %d }",start));
            } else {
                System.out.println(String.format("{ %d, %d }", start, end));
            }
        }
    }

    private static int findFirstIndexUsingBinarySearch(int[] array, int n, int left, int right) {

        if(left > right) {
            return -1; // element is not present in array
        }

        int mid = (left + right) / 2;

        if(array[mid] == n) {
            if(mid == 0) return mid; // 0th element  = n , hence first index
            if(array[mid-1] != n) {
                return mid;
            } else {
                return findFirstIndexUsingBinarySearch(array, n, left, mid-1);
            }
        } else if(array[mid] > n){
            return findFirstIndexUsingBinarySearch(array, n, left, mid-1);
        } else {
            return findFirstIndexUsingBinarySearch(array, n, mid+1, right);
        }
    }

    private static int findLastIndexUsingBinarySearch(int[] array, int n, int left, int right) {

        if(left > right) {
            return -1; // element is not present in array
        }

        int mid = (left + right) / 2;

        if(array[mid] == n) {
            if(mid == array.length - 1) return mid; // element is last in array, hence return last index
            else if(array[mid+1] != n) {
                return mid;
            }
            else {
                return findLastIndexUsingBinarySearch(array, n, mid+1, right);
            }
        } else if (array[mid] > n) {
            return findLastIndexUsingBinarySearch(array, n, left, mid-1);
        } else {
            return findLastIndexUsingBinarySearch(array, n, mid+1, right);
        }
    }
}
