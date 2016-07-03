package com.company.searching;

/**
 * Created by vnagpurkar on 6/23/16.
 */
public class Searching {

    public static boolean isNumberPresentUsingBS (int[] input, int number) {

        boolean isPresent = false;
        int left = 0;
        int right = input.length - 1;
        int mid;

        while(left <= right) {

            mid = (left + right) / 2;
            if(number == input[mid]) {
                isPresent = true;
                break;
            }
            if(number > input[mid]) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return isPresent;
    }
}
