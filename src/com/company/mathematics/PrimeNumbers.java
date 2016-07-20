package com.company.mathematics;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by vnagpurkar on 7/2/16.
 */
public class PrimeNumbers {

    // Generating a List of Primes: The Sieve of Eratosthenes
    // The Sieve of Eratosthenes is a highly efficient way to generate a list of primes. It works by
    // recognizing that all non-prime numbers are divisible by a prime number

    //  One modification to below program is to only use odd numbers in the array,
    // which would allow us to reduce our space usage by half
    public static void printListOfPrimeNumbers(int max) {

        // 1. create array of flags to set numbers which are not prime
        boolean[] flags = new boolean[max+1];

        //1. start with smallest prime number = 2;
        System.out.println("List of prime numbers ");
        int prime = 2;
        int i = 0;
        int count;
        while(prime<=max && i<=max) {

            count = 0;
            System.out.print(prime+",");
            for(;i>1 && i<=max;i+=prime) {
                // to get multiples of prime numbers you can use two methods
                // 1. increment by prime, i = i+prime
                // 2. check if i%prime==0
                if(i%prime==0 && !flags[i]) {
                    flags[i] = !flags[i]; // set flag to true for all multiples of prime numbers (non prime numbers),

                    count++;
                }

            }
            System.out.println(count);
            for(i=2; i<=max; i++) {
                if(!flags[i]) { // if flag is false, then that is next prime number
                    prime = i;
                    break;
                }
            }
            if(i>max) {
                break;
            }
        }
    }

    // Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7
    public static void findKthNumber(int k) {

        int[] result = new int[k]; // result of k prime numbers which are made from 3,5 and 7
        Queue<Integer> q3 = new PriorityQueue<Integer>();
        Queue<Integer> q5 = new PriorityQueue<Integer>();
        Queue<Integer> q7 = new PriorityQueue<Integer>();

        int count = 0;
        result[count++] = 1; // 1 = 3^0 * 5^0 * 7^0
        q3.add(1*3);
        q5.add(1*5);
        q7.add(1*7);

        int queIndex;
        int magicNumber=0;
        while(count < k) {

            int num1 = !q3.isEmpty() ? q3.peek() : 0;
            int num2 = !q5.isEmpty() ? q5.peek() : 0;
            int num3 = !q7.isEmpty() ? q7.peek() : 0;
            queIndex = findQueIndexOfMinimumNumber(num1, num2, num3);
            switch (queIndex) {
                case 1:
                    magicNumber = q3.remove();
                    q3.add(3*magicNumber);
                    q5.add(5*magicNumber);
                    q7.add(7*magicNumber);
                    break;
                case 2:
                    magicNumber = q5.remove();
                    q5.add(5*magicNumber);
                    q7.add(7*magicNumber);
                    break;
                case 3:
                    magicNumber = q7.remove();
                    q7.add(7*magicNumber);
                    break;
                default:
                    break;
            }
            result[count++] = magicNumber;
        }

        // print the result, output
        System.out.println();
        for(int i=0; i<k; i++) {
            System.out.print(result[i]+",");
        }
        System.out.println();
    }

    private static int findQueIndexOfMinimumNumber(int num1, int num2, int num3) {

        int queIndex=0;
        if(num1 < num2) {
            if(num1 < num3) {
                queIndex=1; // num1<num2 and num1 < num3, num1 is minimum
            } else { // num1 < num2 and num3 < num1, hence num3<num1<num2
                queIndex = 3;
            }
        } else {
            if(num3 > num2) // num1> num2, num3 > num2
                queIndex = 2;
            else { // num1>num2, num3<num2, hence num3 < num2 < num1
                queIndex = 3;
            }
        }
        return queIndex;
    }


}
