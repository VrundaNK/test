package com.company;

/**
 * Created by vnagpurkar on 6/29/16.
 */
public class Puzzles {

    // Given heights of buildings, find the water clogged above them. when it rains.Width of all are same and placed next to each other with no space in between them.
    // Example: heights are : 4,2.6 Water clogged will be 2 units above 2nd building
    // Trapping Rain Water

    // int[] towerHeights;
    // int[] heightOnLeft;
    // int[] heightOnRight;

    public static void printUnitsOfTrappedWater(int[] towerHeights) {

        int n =  towerHeights.length;
        int[] heightOnLeft = new int[n];
        int[] heightOnRight = new int[n];

        int waterTrapped = 0;

        for(int i=0; i<n; i++) {

            heightOnLeft[i] = maximum(towerHeights[i], (i>0) ? heightOnLeft[i-1] : 0);
        }

        for(int i=n-1; i>=0; i--) {
            heightOnRight[i] = maximum(towerHeights[i], (i<n-1) ? heightOnRight[i+1] : 0);
        }

        for(int i=0; i<n; i++) {
            waterTrapped = waterTrapped + (minimum(heightOnLeft[i], heightOnRight[i]) - towerHeights[i]);
        }

        System.out.println(waterTrapped);
    }

    private static int maximum(int number1, int number2) {

        if(number1 > number2) return number1;

        return number2;
    }

    private static int minimum(int number1, int number2) {

        if(number1 < number2) return number1;

        return number2;
    }

}
