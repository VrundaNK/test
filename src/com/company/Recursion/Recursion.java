package com.company.Recursion;

import java.awt.Color;
import java.util.*;

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

        char[] str = new char[2 * n];
        List<String> allParens = new ArrayList<String>();
        allParens = addParensRecur(allParens, n, n, str, 0);

        for (String s : allParens) {
            System.out.println(s);
        }
    }

    private static List<String> addParensRecur (List < String > allParens,int leftParen, int rightParen,
        char[] str, int count) {

        if (leftParen < 0 || rightParen < leftParen) return null; // invalid condition

        if (leftParen == 0 && rightParen == 0) {
            allParens.add(String.valueOf(str));
        }

        if (leftParen > 0) {
            str[count] = '(';
            allParens = addParensRecur(allParens, leftParen - 1, rightParen, str, count + 1);
        }
        if (rightParen > leftParen) {
            str[count] = ')';
            allParens = addParensRecur(allParens, leftParen, rightParen - 1, str, count + 1);
        }
        return allParens;
    }

    // this method stores the result of intermediate steps in recursive approach to print parenthesis
    // hence, this is dynamic programing approach
    public static void printParensDP(int n) {

        char[] temp = new char[2*n];
        printParenRecur(new ArrayList<String>(), n, n, temp, 0);
    }

    private static void printParenRecur(List<String> output, int leftParen, int rightParen, char[] temp, int count) {

        if(leftParen < 0 || rightParen < leftParen) return;

        if(leftParen == 0 && rightParen == 0) {
            System.out.println(String.valueOf(temp));
        }

        if(leftParen > 0) {
            temp[count] = '(';
            printParenRecur(output, leftParen-1, rightParen, temp, count+1);
        }

        if(rightParen > 0 && rightParen > leftParen) {
            temp[count] = ')';
            printParenRecur(output, leftParen, rightParen-1, temp, count+1);
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

    // Implement the "paint fill" function that one might see on many image editing programs.
    // That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
    // fill in the surrounding area until the color changes from the original color
    public static Color[][] paintFill(Color[][] screen, Point p, Color newColor ) {

        int x = p.getX();
        int y = p.getY();

       return paintFillRecursively(screen, p.getX(), p.getY(), screen[y][x], newColor);
    }

    // Point P on the screen is represented as (x coordinate, y coordinate)
    // 2 dimentional array is represented by columns (left -> right) and
    //                                         rows (top -> bottom)
    // Hence Columns in 2 dimentional array are represented by x coordinates
    // while Rows in 2 dimentional array are represented by y coordinates
    // Hence, Screen[y][x] is the 2 dimentional represention of Points (x,y)
    private static Color[][] paintFillRecursively(Color[][] screen, int x, int y,
                                                Color originalColor, Color newColor) {
        if(x < 0 || x >= screen[0].length
            || y < 0 || y >= screen.length) {
            return screen;
        }

        if(screen[y][x] == originalColor) {
            screen[y][x] = newColor;
            screen = paintFillRecursively(screen, x-1, y, originalColor, newColor);
            screen = paintFillRecursively(screen, x+1, y, originalColor, newColor);
            screen = paintFillRecursively(screen, x, y-1, originalColor, newColor);
            screen = paintFillRecursively(screen, x, y+1, originalColor, newColor);
        }
        return screen;
    }

    // Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent),
    // write code to calculate the number of ways of representing n cents.
    public static void getNumberOfWays() {

        int n = 100; // we are expecting to make 100 cents;
        // we need to make 100 using infinite coins of (25, 10, 5, 1)

        System.out.println("Number of ways of getting 100 cents using infinite coins of 25,10,5,1 = "+makeChange(n, 25));
    }

    private static int makeChange(int n, int denom) {

        int nextDenom = 0;

        switch(denom) {

            case 25:
                nextDenom = 10;
                break;
            case 10:
                nextDenom = 5;
                break;
            case 5:
                nextDenom = 1;
                break;
            case 1:
                return 1;
            default:
                nextDenom=0;
                break;
        }

        int ways = 0;
        for(int i=0; i*denom <=n; i++) {
            ways = ways + makeChange(n-(i*denom), nextDenom);
        }

        return ways;
    }

    // Write an algorithm to prim all ways of arranging eight queens on an 8x8 chess board
    // so that none of them share the same row, column or diagonal.
    // In this case,"diagonal" means all diagonals, not just the two that bisect the board.
    public static void getWaysOfArrangeQueens(int boardSize){

        List<Integer[]> result = new ArrayList<Integer[]>();
        Integer[] columns = new Integer[boardSize];
        result =  placeQueens(0, columns,result, boardSize);
        System.out.println("Number of ways to arrange 8 queens "+result.size());
    }

    private static List<Integer[]> placeQueens(int row, Integer[]columns, List<Integer[]> results, int boardSize) {

        if(row == boardSize-1) {
            results.add(columns.clone());
        } else {

            for(int col =0; col < boardSize; col++) {

                if(checkIfValidColumn(columns, row, col)) // check if col is valid {
                {
                    columns[row] = col;
                    placeQueens(row + 1, columns, results, boardSize);
                }
            }
        }
        return results;
    }

    private static boolean checkIfValidColumn(Integer[] columns, int currentRow, int col) {

        for(int nextRow=0; nextRow<currentRow; nextRow++) {

            int nextColumn = columns[nextRow];

            if(nextColumn == col) {
                return false;
            } else {
                // to check if elements are in diagonal, check the row distance and column distance
                // between new position (nextRow, nextColumn) and currentPosition(currentRow, col)
                int rowDistance = Math.abs(nextRow-currentRow);
                int colDistance = Math.abs(nextColumn-col);
                if(rowDistance== colDistance) {
                    return false;
                }
            }
        }
        return true;
    }

    // You have a stack of n boxes, with widths wi, heights hi and depths di. The boxes cannot be rotated and
    // can only be stacked on top of one another if each box in the stack is strictly larger than
    // the box above it in width, height and depth.
    // Implement a method to build the tallest stack possible, where the height of a stack is the sum of the heights of each box.
    public static List<Box> getTallestStack(Box[] boxes) {

        List<Box> maxStack = createStackRecur(boxes, boxes[0]);

        return maxStack;

    }

    private static List<Box> createStackRecur(Box[] boxes, Box bottom) {

        int maxHight = Integer.MIN_VALUE;
        List<Box> maxStack = null;
        for(int count=0; count<boxes.length; count++) {

            if(boxes[count].canCreateAbove(bottom)) {
                List<Box> newStack = createStackRecur(boxes, bottom);

                if(newStack.size() > maxHight) {
                    maxHight = newStack.size();
                    maxStack = newStack;
                }
            }
        }
        if(maxStack == null) {
            maxStack = new Stack<Box>();
        }
        if(bottom != null) {
            maxStack.add(0, bottom); // add box at bottom
        }
        return maxStack;
    }

    // if we store results of intermediate step, then we can reuse the previously calculated stacks and stack heights
    // hence, cache intermediate results in Map<Box, List<Box>>
    private static List<Box> createStackDP(Box[] boxes, Box bottom) {

        int maxHeight = Integer.MIN_VALUE;
        List<Box> maxStack = null;

        Map<Box, List<Box>> results = new HashMap<Box, List<Box>>();
        for(int count = 0; count< boxes.length; count++) {

            if(bottom != null && results.containsKey(bottom)) {
                return results.get(bottom);
            } else {

                if(boxes[count].canCreateAbove(bottom)) {
                    List<Box> newStack = createStackDP(boxes, bottom);

                    if(newStack.size() > maxHeight) {
                        maxHeight = newStack.size();
                        maxStack = newStack;
                    }
                }
            }

            if(maxStack == null) {
                maxStack = new ArrayList<Box>();
            }

            if(bottom != null) {
                maxStack.add(0,bottom);
                results.put(bottom, maxStack);
            }
        }
        return maxStack;
    }
}

