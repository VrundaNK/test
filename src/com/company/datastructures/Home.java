package com.company.datastructures;

/**
 * Created by vnagpurkar on 6/9/16.
 */
public class Home {

    // Sum of Fibonacci Numbers
    public static void sumFibinacci(int n) {

        int number1 = 1;
        int number2 = 1;

        int sum = number1+number2;
        int temp;


        for(int i=3; i<=n; i++){

            temp = number2;
            number2 = number1 + number2;
            number1 = temp;

            System.out.println(String.format("Sum+number2 = %d+%d= %d", sum, number2,+ sum + number2));
            sum = sum + number2;
        }
        System.out.println("Sum of n fibonacci numbers is " +sum);
    }

    // Find minimum number of coins that make a given value
    public static void getLeastPossibleCoins(int value, int[] denominations) {

        //System.out.println(leastCoins(denominations, denominations.length, value));

    }

    /*private static int leastCoins(int[] denominations, int m, int value) {

        if(denominations.length == 0 || value == 0) return 0;

        if(m < 0) return 0;

        for(int i=0; i<m; i++) {

            int sub
        }
    }*/

}
