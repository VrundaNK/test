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
    public static void lessEfficientStartAndEndIndexesOfN(int[] array, int n) {

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

    // 1. find first index of n using binary search
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

    // 2. find last index of n using binary search
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

    // Given a sorted integer array and a number, find the start and end indexes of n in the array
    public static void printStartAndEndIndexesOfN(int[] array, int n) {

        int[] indexes = new int[] {-1, -1};
        indexes = findIndexesUsingBinarySearch(array, n, 0, array.length-1, indexes);
        if(indexes[0] == -1 && indexes[1] == -1) {
            System.out.println("Element is not present in array");
        } else {
            if(indexes[0] == -1 || indexes[1] == -1 || indexes[0] == indexes[1]) { // only one occurance of n
                System.out.println(String.format("{ %d }", indexes[0] == -1 ? indexes[1] : indexes[0]));
            } else {
                System.out.println(String.format("{ %d, %d }", indexes[0], indexes[1]));
            }
        }
    }

    private static int[] findIndexesUsingBinarySearch(int[] array, int n, int left, int right, int[] indexes) {

        if(left > right) return indexes;

        int mid = (left + right) / 2;

        if(array[mid] == n) {

            if(mid == 0 || array[mid-1] != n) { // this is first index,
                indexes[0] = mid;
                if(indexes[1] == -1) { // now we should search on right side, last index, if last index is not found
                    indexes = findIndexesUsingBinarySearch(array, n, mid + 1, right, indexes);
                }
            } else if (mid == array.length -1 || array[mid+1] != n) { // this is last index,
                indexes[1] = mid;
                if(indexes[0] == -1) { // now we should search on left side, first index, if first index is not found
                    indexes = findIndexesUsingBinarySearch(array, n, left, mid - 1, indexes);
                }
            } else { // if mid is not first or last index, we should search on both left and right side
                indexes = findIndexesUsingBinarySearch(array, n, left, mid-1, indexes);
                indexes = findIndexesUsingBinarySearch(array, n, mid+1, right, indexes);
            }

        } else if(array[mid] > n) {
            indexes = findIndexesUsingBinarySearch(array, n, left, mid-1, indexes);
        } else {
            indexes = findIndexesUsingBinarySearch(array, n, mid+1, right, indexes);
        }
        return indexes;
    }



}
