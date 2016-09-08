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

    private static void printPermutations(int[] numberArray, int startIndex) {

        if(startIndex == numberArray.length-1) {
            System.out.println();
            for(int i=0; i<numberArray.length; i++) {
                System.out.print(numberArray[i] + ",");
            }
        } else {
            int temp;
            for(int i= startIndex; i<numberArray.length; i++) {
                temp = numberArray[i];
                numberArray[i] = numberArray[startIndex];
                numberArray[startIndex] = temp;

                printPermutations(numberArray, startIndex+1);

                temp = numberArray[i];
                numberArray[i] = numberArray[startIndex];
                numberArray[startIndex] = temp;
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

    // How to convert numeric String to an int
    public static int convertNumericStringToInt(String numeric) throws NumberFormatException {

        int length = numeric.length();
        int number = 0;
        int c;
        for (int i = 0; i < length; i++) {
            c = numeric.charAt(i);
            if (48 <= c && c <= 57) {
                number = number * 10 + (c - 48);
            } else {
                throw new NumberFormatException();
            }
        }
        return number;
    }

    // arr1 = 1,1,2,3,3,4,5,7,9
    // arr2 = 1,1,2,2,5,8,9,10,10,10,100
    // similarityIndex = #unique elements/ total unique elements
    // # total unique elements = 1,2,3,4,5,7,8,9,10,100
    // # non-intersecting unique elements = 3,4,7,8,10,100
    // # intersecting unique elements = 1,2,5,9
    public static void getSimilarityIndex(int[] arr1, int[] arr2) {

        int count = 0;
        int countIntersecting = 0;
        int prevIntersecting = Integer.MIN_VALUE;
        int prevArr1 = Integer.MIN_VALUE;
        int prevArr2 = Integer.MIN_VALUE-1;

        int i = 0;
        int j = 0;

        while(i < arr1.length && j < arr2.length) {

            if(arr1[i] == arr2[j]) {

                if(prevIntersecting != arr1[i]) {
                    prevIntersecting = arr1[i];
                    countIntersecting++;
                    System.out.println("Prev Interesting "+ prevIntersecting);
                }
                prevArr1 = arr1[i];
                prevArr2 = arr2[j];
                i++;
                j++;
            } else if(arr1[i] > arr2[j]) {
                if(prevArr2 != arr2[j]) {
                    prevArr2 = arr2[j];
                    count++;
                    System.out.println("arr2[j] "+ arr2[j]);
                }
                j++;
            } else {
                if(prevArr1 != arr1[i]) {
                    prevArr1 = arr1[i];
                    count++;
                    System.out.println("arr1[i] "+ arr1[i]);
                }
                i++;
            }
        }
        while(i < arr1.length) {
            if(prevArr1 != arr1[i]) {
                prevArr1 = arr1[i];
                count++;
                System.out.println("arr1[i] "+ arr1[i]);
            }
            i++;
        }
        while(j < arr2.length) {
            if (prevArr2 != arr2[j]) {
                prevArr2 = arr2[j];
                count++;
                System.out.println("arr2[j] " + arr2[j]);
            }
            j++;
        }
        System.out.println("Count Unique But Not Intersecting " + count);
        System.out.println("Count Intersecting " + countIntersecting);
        System.out.println("Similarity Index " + (countIntersecting*100/(countIntersecting + count)));
    }
}

