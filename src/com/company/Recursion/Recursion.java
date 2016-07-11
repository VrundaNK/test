package com.company.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by vnagpurkar on 7/4/16.
 */
public class Recursion {

    // Implement an algorithm to print all valid (e.g., properly opened and closed)
    // combinations of n-pairs of parentheses
    // EXAMPLE
    // Input: 3
    // Output: ((())), (()()), (())(), ()(()), ()()()
    public static void printParens(int n) {

        char[] str = new char[2*n];
        List<String> allParens = new ArrayList<String>();
        allParens = addParensRecur(allParens, n, n, str, 0);

        for(String s: allParens) {
            System.out.println(s);
        }
    }

    private static void printParensNonRecur(int n) {

        Stack<String> temp = new Stack<String>();
        int leftParen = 3;
        int rightParen = 3;
        temp.push("(");
        while(! temp.isEmpty() ) {

            while(leftParen > 0) {
                leftParen--;
                String current = temp.peek();
                temp.push(current+"(");
            }
            if(rightParen > leftParen) {
                String current = temp.peek();

            }


        }

    }

    private static List<String> addParensRecur(List<String> allParens, int leftParen, int rightParen,
                                          char[] str, int count) {

        if(leftParen < 0 || rightParen < leftParen) return null; // invalid condition

        if(leftParen == 0 && rightParen ==0) {
            allParens.add(String.valueOf(str));
        }

        if(leftParen > 0) {
            str[count] = '(';
            allParens = addParensRecur(allParens, leftParen-1, rightParen, str, count+1);
        }
        if(rightParen > leftParen) {
            str[count] = ')';
            allParens = addParensRecur(allParens, leftParen, rightParen-1, str,count+1);
        }
        return allParens;
    }

    // Write a method to compute all permutations of a string.
    public static void stringPermutations(String input) {

        List<String> allPerms = new ArrayList<String>();
        allPerms = addPerms(allPerms, "", input);

        for(String s: allPerms) {
            System.out.println(s);
        }
    }

    private static List<String> addPerms(List<String> allPerms, String prefix, String input) {

        int length = input.length();
        if(length == 0) {
            allPerms.add(prefix);
        } else {
            for(int i=0; i<length; i++) {

                allPerms = addPerms(allPerms, prefix+input.charAt(i), input.substring(0,i)+input.substring(i+1, length));
            }
        }
        return allPerms;
    }

    // A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
    // Implement a method to count how many possible ways the child can run up the stairs
    public static void printWays() {

    }

    private static int countways(int steps) {

        if(steps < 0) {
            return 0;
        }
        if(steps == 1) {
            return 1;
        }
        return countways(steps-1) + countways(steps-2) + countways(steps-3);
    }

    private static int countwaysDP(int steps, int[] map) {

        if(steps < 0) {
            return 0;
        }
        if(map[steps] > -1) {
            return map[steps];
        } else {
            map[steps] = countwaysDP(steps-1, map)+
                    countwaysDP(steps-2, map) +
                    countwaysDP(steps-3, map);
            return map[steps];
        }
    }

    // A magic index in an array A[l.. .n-l] is defined to be an index such that A[i] = i.
    // Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
    public static void findMagicIndexDistinct(int[] array) {

        System.out.println(getMagicIndexDistinct(array, 0, array.length-1));
    }

    private static int getMagicIndexDistinct(int[] array, int start, int end) {

        if(start < 0 || start > end || end >=array.length) {
            return -1;
        }
        int mid = (start + end) / 2;
        if(array[mid] == mid) {
            return mid;
        } else if(array[mid] > mid) {
            return getMagicIndexDistinct(array, start, mid-1);
        } else {
            return getMagicIndexDistinct(array, mid+1, end);
        }
    }

    // FOLLOW UP
    // What if the values are not distinct?
    public static void findMagicIndex(int[] array) {
        System.out.println(getMagicIndexDistinct(array, 0, array.length-1));
    }

    private static int getMagicIndex(int[] array, int start, int end) {

        if(start < 0 || start > end || end >= array.length) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midValue = array[mid];

        if(mid == midValue) {
            return mid;
        }
        int leftIndex = Math.min(mid-1, midValue);
        int left = getMagicIndex(array, start, leftIndex);
        if(left >= 0) {
            return left;
        }
        int rightIndex = Math.max(midValue, mid+1);
        int right = getMagicIndex(array, rightIndex, end);
        return right;
    }
}
