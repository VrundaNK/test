package com.company.datastructures;

/**
 * Created by vnagpurkar on 6/2/16.
 */
public class Arrays {

    // Merge an array of size n into another array of size m+n
    public static int[] mergeTwoSortedArrays(int[] mn, int[] n) {

        int lengthmn = mn.length;
        int lengthn = n.length;

        // 1. move elements towards the end of array
        int end = mn.length - 1;
        for (int i = lengthmn - 1; i >= 0; ) {

            if (mn[i] == 0) {
                i--;
            } else {
                mn[end] = mn[i];
                end--;
                i--;
            }
        }

        // 2.
        int i = end + 1;
        int j = 0;

        for (int start = 0; start < lengthmn; start++) {

            if (i < lengthmn && mn[i] <= n[j]) {
                mn[start] = mn[i];
                i++;
            } else if (j < lengthn) {
                mn[start] = n[j];
                j++;
            }

        }
        return mn;
    }

    // Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
    // Juggling algorithm
    public static int[] arrayRotate(int[] input, int d) {

        int n = input.length;
        int gcd = getGCD(d, n);

        int temp = 0;
        int j = 0;

        for (int i = 0; i < gcd; i++) {

            while (true) {
                temp = input[0];
                j = 0;
                while (j < n - 1) {
                    input[j] = input[j + 1];
                    j++;
                }
                input[j] = temp;
            }
        }

        return input;
    }

    private static int getGCD(int number1, int number2) {

        if (number2 == 0)
            return number1;

        return getGCD(number2, number1 % number2);

    }

    // Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
    // Reversal algorithm
    public static int[] arrayRotateReversalAlgorithm(int[] input, int d) {


        // reverse (input, 0, d-1) Let's assume A= [0, ..., d-1], reverse Ar
        input = reverseInputArray(input, 0, d - 1);
        // reverse (input d+1, n)  Let's assume B = [d, ..., n-1], reverse Br
        input = reverseInputArray(input, d, input.length - 1);
        // reverse (input, 1, n) reverse ArBr
        input = reverseInputArray(input, 0, input.length - 1);
        return input;
    }

    private static int[] reverseInputArray(int[] input, int start, int end) {

        int temp;
        while (start < end) {
            temp = input[start];
            input[start] = input[end];
            input[end] = temp;

            start++;
            end--;
        }
        return input;
    }

    //Maximum sum such that no two elements are adjacent
    public static int maximumSum(int[] input) {

        int including = input[0];
        int excluding = 0;
        int excluding_new = 0;

        for (int i = 1; i < input.length; i++) {

            excluding_new = including > excluding ? including : excluding;
            including = excluding + input[i];
            excluding = excluding_new;
        }
        return (including > excluding ? including : excluding);
    }

    // Leaders in an array
    public static void leadersInArray(int[] input) {

        if (input.length < 1) return;

        System.out.println();
        System.out.print("Leaders in array are ");

        int maximumUptilNow = 0;
        for (int i = input.length - 1; i >= 0; i--) {

            if (maximumUptilNow < input[i]) {
                System.out.print(input[i] + ",");
                maximumUptilNow = input[i];
            }
        }
        System.out.println();
    }

    // Check for Majority Element in a sorted array
    public static boolean isMajority(int[] input, int x) {

        int n = input.length;
        // 1. find position of element x recursively using binary search since array is sorted
        int position = returnPositon(input,0,n,x);
        // 2. check if the element is present more than n/2 times
        if(position == -1) return false; // x is not present in array

        if(((position+(n/2)) <= (n-1)) && (input[position + (n/2)] == x)) {
            return true;
        }
        return false;
    }

    private static int returnPositon(int[] input, int start, int end, int x) {

        int mid;
        while(start <= end) {

            mid = start + ((end-start)/2) ;
            if(x == input[mid] && (mid == 0 || x > input[mid])) {
                return mid;
            } else if(x > input[mid]) {
                start = mid +1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static boolean isMajorityElement(int[] input, int x) {

        for(int i=0; i<input.length/2; i++) {
            if(input[i] == x) {
                if(input[i+(input.length/2)] == x) {
                    return true;
                }
            }
        }
        return false;
    }

    // Segregate 0s and 1s in an array
    public static void segregate2Elements(int[] input) {

        int left  = 0;
        int right = input.length - 1;
        int temp;

        while(left <= right) {

            if(input[left] == 0) {
                left++;
            } else if(input[right] == 1) {
                right--;
            } else if(input[left] > input[right]) {
                temp = input[left];
                input[left] = input[right];
                input[right] = temp;

                left++;
                right--;
            }
        }

        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ",");
        }
        System.out.println();
    }

    // Segregate 0s ,1s and 2s in an array
    public static void segregate3Elements(int[] input) {

        int left = 0;
        int right = input.length - 1;
        int temp;

        int mid = 0;

        while(mid <= right) {

           if(input[mid] == 0) {
               temp = input[left];
               input[left] = input[mid];
               input[mid] = temp;
               left++;
               mid++;
           } else if(input[mid] == 1) {
               mid++;
           } else if(input[mid] == 2) {
               temp = input[right];
               input[right] = input[mid];
               input[mid] = temp;
               right--;
           }

        }

        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ",");
        }
        System.out.println();
    }

    // Maximum difference between two elements such that larger element appears after the smaller number
    public static void maxDifference(int[] input) {

        int maxDiff = Integer.MIN_VALUE;
        int maxElement = input[input.length-1];

        for(int i=input.length-2; i>=0; i--) {
            if (input[i] < maxElement) {
                if((maxElement-input[i]) > maxDiff ) {
                    maxDiff = maxElement-input[i];
                }
            } else {
                if((input[i]-maxElement) > maxDiff ) {
                    maxDiff = maxElement-input[i];
                }
                maxElement = input[i];
            }
        }
        System.out.println("Maximum difference between two elements such that larger element appears after the smaller number "+ maxDiff);
    }

    // Find the smallest positive number missing from an unsorted array of +ve and -ve integers
    public static void smallestPositiveMissingNumber(int[] input) {

        int n = input.length;
        for(int i=0; i<n; i++) {

            if(input[i] > 0 && input[i] < n) {
                input[Math.abs(input[i])] = input[i];
            }
        }
        for(int i=1; i<n;i++) {
            if(input[i] != i) {
                System.out.println("Smallest positive integer missing from unsorted array is "+ i);
                break;
            }
        }
        /*// 1. segregate +ve and -ve numbers
        int left = 0;
        int right = input.length - 1;
        int temp;

        while(left <= right) {

            if(input[left] < 0) {
                left++;
            } else if(input[right] > 0) {
                right--;
            } else if(input[left] > input[right]) {
                temp = input[left];
                input[left] = input[right];
                input[right] = temp;
                left++;
                right--;
            }
        }

        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ",");
        }
        System.out.println();

        // 2. mark elements -ve
        for(int i=left; i<input.length; i++) {
            if(input[Math.abs(input[left])] > 0) {
                input[Math.abs(input[left])] = - Math.abs(input[left]);
            }
        }
        for(int i= left; i<input.length; i++) {

        }*/
    }

    // Find the two repeating elements in a given array of n+2 elements, all elements of the array are in range 1 to n
    public static void find2RepeatingMissingElelemtns(int[] input) {

        // Let's assume missing elements are x and y
        int n = input.length - 2; //( since input contains n+2 elements)
        // 1. Calculate sum and product of all the numbers in given input
        int sum = 0;
        int prod = 1;
        for(int i=0; i<input.length; i++) {
            sum = sum + input[i];
            prod = prod * input[i];
        }

        // 2. sum of n elements = n(n+1)/2,
        int xplusy = sum - (n*(n+1)/2);

        //3. product of n elements = n!
        int xy = prod / factorial(n);

        int xminusy = (int) Math.sqrt((xplusy * xplusy) -(4*xy));

        int x = (xplusy + xminusy) /2;
        int y = (xplusy - xminusy) /2;

        System.out.println("Two repeating numbers "+ x +" , "+ y);

    }

    private static int factorial (int i){

        int factorial = 1;
        while(i>1){
            factorial = factorial *(i--);
        }
        return factorial;
    }

    // Find the two non-repeating elements in an array of repeating elements, while traversing array only once and constant space.
    public static void findNonRepeatingMissingElelemtns(int[] input) {

        // Let's assume missing elements are x and y
        int n = (input.length - 2)/2; //( since input contains n+2 elements)
        // 1. Calculate sum and product of all the numbers in given input
        int sum = 0;
        int prod = 1;
        for(int i=0; i<input.length; i++) {
            sum = sum + input[i];
            prod = prod * input[i];
        }

        // 2. sum of n elements = n(n+1)/2, hence sum of 2n such that n elements repeat = (2*(n(n+1))/2)
        int xplusy = sum - (2*(n*(n+1)/2));

        //3. product of n elements = n!, hence sum of 2n such that n elements repeat = (n! * n!)
        int xy = prod / (factorial(n) * factorial(n));

        int xminusy = (int) Math.sqrt((xplusy * xplusy) -(4*xy));

        int x = (xplusy + xminusy) /2;
        int y = (xplusy - xminusy) /2;

        System.out.println("Two non-repeating numbers "+ x +" , "+ y);

    }

    // Find the two non-repeating elements in an array of repeating elements, while traversing array twice, using xor.
    public static void findNonRepeatingMissingElelemtnsXOR(int[] input) {

        // Let's assume missing elements are x and y
        int xorAll = 0;
        int x = 0;
        int y = 0;

        // 1. xor all elements in the input array
        for(int i=0; i<input.length; i++) {
            xorAll = xorAll ^ input[i];
        }

        // 2. find the bit which is set in XORAll
        int bit = xorAll & ~(xorAll-1);

        // 3. take xorSet of all elements from input where "bit" is set
        // and take xorReset of all elements from input where "bit" is reset
        for(int i=0; i<input.length; i++) {

            if((input[i] & bit) != 0) {
                x = x ^ input[i];
            } else {
                y = y ^ input[i];
            }
        }
        System.out.println("Two non-repeating numbers "+ x +" , "+ y);

    }

    // Find duplicates in O(n) time and O(1) extra space , given an array of n elements which contains elements from 0 to n-1
    // and all positive numbers;
    public static void findDuplicateElements(int[] input) {

        int zeroCount = 0;
        for(int i=0; i<input.length; i++) {

            if(input[Math.abs(input[i])] > 0) {
                input[Math.abs(input[i])] = - input[Math.abs(input[i])];
            } else if(input[Math.abs(input[i])] == 0) {
                if(zeroCount == 1) {
                    System.out.println("Duplicate element " + input[i]);
                } else {
                    zeroCount++;
                }
            } else {
                System.out.println("Duplicate element " + input[i]);
            }
        }
    }

    // largest sum contiguous subarray
    // Kadane's algorithm
    public static void largestSumContiguousSubArry(int[] input) {

        int max_so_far = 0;
        int max_ending_here = 0;
        int start = 0;
        int end = 0;

        for(int i=0; i<input.length; i++) {
            max_ending_here = max_ending_here + input[i];
            if(max_ending_here < 0) {
                max_ending_here = 0;
                start = i+1 < input.length ? i+1 : i;
            }
            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                end = i;
            }
        }
        System.out.println("Maximum sum so far " + max_so_far);
        System.out.println("Start of the subarray " + start);
        System.out.println("End of the subarray " + end);
    }

    // How do you sort an array that consists of only zeros and ones in only one pass
    public static void printSortedArrayOfZeroAndOne(int[] input) {

        if(input == null || input.length == 0) return;

        int left = 0;
        int right = input.length - 1;
        int temp;

        while(left <= right) {
            if(input[left] > input[right]) {
                temp = input[left];
                input[left] = input[right];
                input[right] = temp;
            }

            if(input[left] == 0) {
                left ++;
            }

            if(input[right] == 1) {
                right --;
            }
        }

        for(int i=0; i<input.length; i++) {
            System.out.println(input[i] +",");
        }
    }

    // k largest(or smallest) elements in an array | added Min Heap method


}
