package com.company.datastructures;

/**
 * Created by vnagpurkar on 6/28/16.
 */
public class Number {

    // print permutations of given number
    // permutations of 123 = 123, 132, 213, 231, 312, 321
    public static void printPermutations(int[] numberArray) {

        printPermutations(numberArray, 0);
    }

    private static void printPermutations(int[] input, int startIndex) {

        if(startIndex == input.length-1) {
            for(int i=0; i<input.length; i++) {
                System.out.print(input[i]+",");
            }
            System.out.println();
        }
        else {
            int temp;
            for (int i = startIndex; i < input.length; i++) {

                temp = input[i];
                input[i] = input[startIndex];
                input[startIndex] = temp;
                printPermutations(input, startIndex + 1);
            }
        }

    }

    // Count trailing zeroes in factorial of a number
    // Trailing 0s in n! = Count of 5s in prime factors of n! = floor(n/5) + floor(n/25) + floor(n/125) + ....
    public static int numberOfTrailingZeros(int number) {

        // trailing zero comes from 10, which is 5*2
        // hence number of trailing zeros = (number of 5s and 2s)
        // number of 2s in factorial of n is always greater than equal to number of 5s
        // hence, number of trailing zeros = number of 5s
        // number of 5s in factors of n in n! = floor(n/5)
        // thus number of trailing 0s = floor(n/5) + floor(n/25) + floor(n/125)....

        // 1. brute force method to count 5s = is count 5s in each factor of number n
        // 2. more efficient method is to count multiples of 5 (5,25,125...) in factors of n
        // 3. even more efficient method is count trailing zeros = = floor(n/5) + floor(n/25) + floor(n/125)....

        // 2. using method 2
        int trailingZeros = 0;
        int count = 0;
        for (int i = 5; (number / i) > 0; i = i * 5) {
            count = count + (number / i);
        }
        trailingZeros = count;

        trailingZeros = 0;
        // 3. using method 3
        for (int i = 5; i <= number; i = i * 5) {
            trailingZeros = trailingZeros + (int) Math.floor(number / i);
        }
        return trailingZeros;
    }
}
