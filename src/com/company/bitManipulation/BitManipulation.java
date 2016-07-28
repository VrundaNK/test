package com.company.bitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vnagpurkar on 7/25/16.
 */
public class BitManipulation {

    /*
    You are given two 32-bit numbers, N and M, and two bit positions, land j. Write
a method to insert M into N such that M starts at bit j and ends at bit i. You can
assume that the bits j through i have enough space to fit all of M. That is, if
M = 10011, you can assume that there are at least 5 bits between j and i. You
would not, for example, have j = 3 and i = 2, because M could not fully fit
between bit 3 and bit 2.
EXAMPLE
Input: N = 10000000000, M = 10011, i = 2, j = 6
Output: N = 10001001100
     */
    public static void mergeNumbers(int N, int M, int i, int j) {

        //j > i,
        // we need to clear bits j to i in number N
        // 1. mask left will clear bits from MSB to i
        // 2. mask right will clear bits from j to 0;

        int allOnes = ~0;
        int leftMask = ~(allOnes << i);
        int rightMask = allOnes << j;
        int mask = leftMask | rightMask;

        N = N & mask;

        // we need to left shift M by i so that j=MSB of M and i= LSB of N
        M = M << i;

        N = N | M;

        System.out.println("Result is "+ N);
    }

    /*
    Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
print the binary representation. If the number cannot be represented accurately
in binary with at most 32 characters, print "ERROR."
     */
    public static void doubleToBinary(double number){

        if(number <= 0 || number >= 1) {
            System.out.println("Error");
            return;
        }

        double temp;
        StringBuilder binaryRepresentation = new StringBuilder(".");

        while(number > 0){

            if(binaryRepresentation.length() >= 32){
                System.out.println("Error");
                return;
            }

            temp = number * 2;
            if(temp >= 1){
                binaryRepresentation.append("1");
                number = temp - 1;
            } else {
                binaryRepresentation.append("0");
                number = temp;
            }
        }
        System.out.println("Binary representation "+ binaryRepresentation.toString());
    }
    /*
    Explain what the following code does: ((n & (n-1)) == 0) - This determines if n is power of 2.
     */

    /*
    Write a function to determine the number of bits required to convert integer A to integer B.
     */
    public static void findDifferentBits(int a, int b) {

        int bitDiff = 0;
        // number of bits different in A and B = number of 1's in A^B
        int XorResult = a^b;
        int lsb = 0;
        while(XorResult != 0) {

            lsb = XorResult & 1;
            bitDiff = bitDiff+ lsb;
            XorResult = XorResult >> 1;
        }

        System.out.println("the number of bits required to convert integer A to integer B "+ bitDiff);
    }

    public static void findDifferentBitsMethod2(int a, int b) {

        int bitDiff = 0;
        // number of bits different in A and B = number of 1's in A^B
        // Instead of right shifting by 1 XorResult = XorResult >> 1,
        // we can flip the LSB in XorResult until XorResult is 0,
        // fliping LSB (0 to 1 and 1 to 0) means subtracting 1 from number,
        // thus the count measured until the number becomes 1 is the number of bits required to convert integer A to integer B

        int XorResult = a ^ b;

        while( XorResult > 0) {
            bitDiff++;
            XorResult = XorResult & (XorResult-1);
        }
        System.out.println("the number of bits required to convert integer A to integer B using method 2 "+ bitDiff);
    }

    /*
    Write a program to swap odd and even bits in an integer with as few instructions as possible
    (e.g., bit 0 and bit! are swapped, bit 2 and bit 3 are swapped, and so on).
     */
    /*
    bit positions = 7 6 5 4 3 2 1 0
    odd positions = 7,5,4,1
    even positions = 6,4,2,0
    to read bits in odd positions = mask = 10101010 (0xAA)
    to read bits in even positions = mask = 01010101 (0x55)

    1. int oddBits = read odd bits only and right shift those by 1
    2. int evenBits = read even bits only and left shit those by 1
    3. result = odd | even
     */
     public static void swapBits(int number){

         int maskToReadOddBits = 0xAA;
         int maskToReadEvenBits = 0x55;
         int oddBits = number & maskToReadOddBits;
         oddBits = oddBits >> 1; // shift odd bits to even positions

         int evenBits = number & maskToReadEvenBits;
         evenBits = evenBits << 1; // shift even bits to odd positions

         int result = evenBits | oddBits;

         System.out.print("swap odd and even bits in an integer "+ result);
     }

    /*
    Given a positive integer, print the next smallest and the next largest number that have
    the same number of 1 bits in their binary representation
     */
    /*
    Let's assume i and j bits in number n,
    if i < j, and we change i to 1 and j to 0 , will decrease n
    if i > j, and we change i to 0 and j to 1, will increase n

    hence, to get next number with same number of 1's
    1. find rightmost trailing 0 (let's say at p), flip bit p from 0 to 1
    2. c0 = count 0's and c1 = count 1's in rightmost bits after p
    2. clear all bits from p to 0
    3. set c1-1 bits from p to 0

    hence, to get prev number with same number of 1's
    1. find rightmost trailing 1 (let's say at p), flip bit p from 1 to 0
    2. c0 = count 0's and c1 = count 1's in rightmost bits after p
    2. clear all bits from p to 0
    3. set c1+1 bits from p to 0
     */

    public static void getNextSmallestNextGreatestNumber(int number) {

        int nextGreatest = getNextGreatest(number);
        int nextSmallest = getNextSmallest(number);

        System.out.println(
                String.format("NextGreatest = %d , NextSmallest = %d for number %d .", nextGreatest, nextSmallest, number));
    }

    private static int getNextGreatest(int number) {

        int temp = number;
        int c0 = 0;
        int c1 = 0;

        // count 0's after rightmost non-trailing 0
        while((temp & 1) == 0 && temp != 0) {
            c0++;
            temp = temp >> 1;
        }

        // count 1's after rightmost 0
        while((temp & 1) == 1) {
            c1++;
            temp = temp >> 1;
        }

        int bitP = c0 + c1;
        // if n is highest 32 bit number, then there is no next greatest number
        if(bitP == 31 || bitP == 0 ){
            return -1;
        }

        number = number | (1 << bitP); // flip bitp from 0 to 1
        number = number & ((~0) << bitP); // clear bits from p to 0
        number = number | ((1 << (c1-1))-1); // set c1-1 1's from p to 0
        return number;
    }

    private static int getNextSmallest(int number) {

        int temp = number;
        int c0 = 0;
        int c1 = 0;

        // count 1's next to rightmost non-trailing 1
        while((temp & 1) == 1 && temp != 0){
            c1++;
            temp = temp >> 1;
        }

        // count 0's next to rightmost non-trailing 1
        while((temp & 1) == 0 && temp != 0) {
            c0++;
            temp = temp >> 1;
        }

        int bitP = c0 + c1; // position of rightmost non-trailing 1
        number = number & ((~0) << bitP); // clear all bits from p to 0
        number = number | ((1 << (c1+1))-1); // set c1+1 1's from p to 0

        return number;
    }

    /*
    An array A contains all the integers from 0 through n, except for one number which is
missing. In this problem, we cannot access an entire integer in A with a single operation.
The elements of A are represented in binary, and the only operation we can use
to access them is "fetch the jth bit of A[i]," which takes constant time. Write code to
find the missing integer. Can you do it in 0(n) time?
     */
    public static void findMissingNumber(List<Integer[]> number) {

        // if n is even, then number of 0s = number of 1s at jth bit in all 0-n numbers
        // if n is odd, then number of 0s > number of 1s at jth bit in all 0-n numbers

        int bitSize = number.get(0).length;
        int[] missingNumber = findMissingNumber(number, 0, bitSize, new int[bitSize]);

        printMissingNumber(missingNumber);
    }

    private static int[] findMissingNumber(List<Integer[]> numbers, int j, int bitSize, int[] missingNumber) {

        if(j == bitSize) {
            return missingNumber;
        }

        int n = numbers.size();
        List<Integer[]> numbersWith0JBit = new ArrayList<Integer[]>(n/2);
        List<Integer[]> numbersWith1JBit = new ArrayList<Integer[]>(n/2);

        // "fetch the jth bit of A[i],"
        for(int i=0; i<n; i++){
            if(numbers.get(i)[j] == 0){
                numbersWith0JBit.add(numbers.get(i));
            } else {
                numbersWith1JBit.add(numbers.get(i));
            }
        }

        // if n is even then we need to check
            /*if(numbersWith0JBit.length == numbersWith1JBit.length) {
                // since n is even, numbersWith0JBit.length > numbersWith1JBit.length by 1, hence 1 needs to be removed
            } else if (numbersWith0JBit.length > numbersWith1JBit.length) {
                // since n is even, numbersWith0JBit.length > numbersWith1JBit.length, by 1, hence 0 needs to be removed
            }*/
        // else if n is odd then we need to check
            /*if(numbersWith0JBit.length < numbersWith1JBit.length) {
                // since n is odd, numbersWith0JBit.length == numbersWith1JBit.length, hence 1 needs to be removed
            } else if(numbersWith0JBit.length > numbersWith1JBit.length) {
                // since n is odd, numbersWith0JBit.length == numbersWith1JBit.length, hence 0 needs to be removed
            }*/
        // Hence, combining these conditions
        if(numbersWith0JBit.size() <= numbersWith1JBit.size()) {
            // hence numbers with 1 needs to be removed, j bit of missingNumber is 0
            missingNumber[j] = 0;
            missingNumber = findMissingNumber(numbersWith0JBit, j+1, bitSize, missingNumber);
        } else {        //if(numbersWith0JBit.size() > numbersWith1JBit.size())
            // hence numbers with 1 needs to be removed, j bit of missingNumber is 1
            missingNumber[j] = 1;
            missingNumber = findMissingNumber(numbersWith0JBit, j+1, bitSize, missingNumber);
        }
        return missingNumber;
    }

    private static void printMissingNumber(int[] missingNumber){

        System.out.print("\nMissing number ");
        for(int i=0; i<missingNumber.length; i++) {
            System.out.print(missingNumber[i]+",");
        }
    }

    /* A monochrome screen is stored as a single array of bytes, allowing eight consecutive
pixels to be stored in one byte. The screen has width w, where w is divisible
by 8 (that is, no byte will be split across rows). The height of the screen, of course,
can be derived from the length of the array and the width. Implement a function
drawHorizontalLine(byte[] screen, int width, intxl, intx2, inty) which draws a horizontal
line from (x 1, y) to (x2, y)*/
    void drawLine(byte[] screen, int width, int xl, int x2, int y) {

        
    }
}
