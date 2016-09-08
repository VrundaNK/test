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

    // Given a sorted array of strings which is interspersed with empty strings,
    // write a method to find the location of a given string
    public static int findLocationOfString(String[] strings, String search) {

        if(search == null || strings== null || strings.length == 0) {
            return -1;
        }
        return binarySearchWithEmptyStrings(strings, search, 0, strings.length-1);
    }

    private static int binarySearchWithEmptyStrings(String[] strings, String search, int start, int end) {

        if(start > end) return -1;

        int mid = (start + end) / 2;

        if(strings[mid].isEmpty() && !search.isEmpty()){
            int left = mid-1;
            int right = mid + 1;
            while(true) {

                if(left < start || right > end) {
                    return - 1;
                } else if(start >= left && !strings[left].isEmpty()){
                    mid = left;
                    break;
                } else if(right<=end && !strings[right].isEmpty()){
                    mid = right;
                    break;
                }
                right++;
                left--;
            }
        }

        if(strings[mid].equals(search)){
            return mid;
        } else if(strings[mid].compareTo(search) > 1){
            return binarySearchWithEmptyStrings(strings, search, start, mid-1);
        } else {
            return binarySearchWithEmptyStrings(strings, search, start, mid+1);
        }
    }

    // Given an MX N matrix in which each row and each column is sorted in ascending order,
    // write a method to find an element.
    public static void findAnElement(int[][] matrix, int search) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int i = 0;
        int j = columns-1;

        while(i < rows && j >= 0){

            if(search == matrix[i][j]){
                System.out.println(String.format("Search element=%d is found at matrix[%d][%d]", search, i, j));
                return;
            }
            if(search > matrix[i][j]){
                i++;
            } else if(search < matrix[i][j]) {
                j--;
            }
        }

        System.out.println(String.format("Search element=%d is not found in given matrix.", search));
    }

    // Given a sorted array of n integers that has been rotated an unknown number of times,
    // write code to find an element in the array. You may assume that the array was originally sorted in increasing order.
    public static void findElement(int[] array, int d) {

        int location = binarySearch(array, d, 0, array.length-1);
    }

    private static int binarySearch(int[] array, int d, int left, int right){

        if(left > right) return -1;

        int mid = (left + right) / 2;

        if(d == array[left]) {
            return mid; // found element
        }

        if(array[left] < array[mid]) { // left array is properly sorted

            if(d >= array[left] && d <= array[mid]){
                return binarySearch(array, d, left, mid-1);
            } else {
                return binarySearch(array, d, mid+1, right);
            }

        } else if(array[left] > array[mid]) { // right side is properly sorted
            if(d <= array[mid] && d <= array[right]) {
                return binarySearch(array, d, mid+1, right);
            } else {
                return binarySearch(array, d, left, mid-1);
            }

        } else if(array[left] == array[mid]) { // left side is having all repeating elements
            return binarySearch(array, d, mid+1, right);
        } else { // otherwise do regular search on both sides

            if(d < array[mid]) {
                return binarySearch(array, d, left, mid-1);
            } else {
                return binarySearch(array, d, mid+1, right);
            }
        }
    }

}
