package com.company.mathematics;

/**
 * Created by vnagpurkar on 7/2/16.
 */
public class PrimeNumbers {

    // Generating a List of Primes: The Sieve of Eratosthenes
    // The Sieve of Eratosthenes is a highly efficient way to generate a list of primes. It works by
    // recognizing that all non-prime numbers are divisible by a prime number
    public static void printListOfPrimeNumbers(int max) {

        boolean[] flags = new boolean[max+1];

        int nextPrimeNumber;
        // 2 is the smallest prime number
        for(int i=2; i<max; i++) {

            if(!flags[i]) {
                for (int j = 2; j < flags.length; j++) {
                    if (j!=i && j % i == 0) {
                        flags[j] = true;
                    }
                }
            }
        }
        System.out.println("List of prime numbers ");
        for(int i=2; i<flags.length; i++) {
            if(!flags[i])
            System.out.print(i+",");
        }
        System.out.println();
    }


}
