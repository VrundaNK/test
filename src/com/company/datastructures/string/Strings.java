package com.company.datastructures.string;

import com.company.util.Frequency;
import com.company.util.FrequencyCompartor;

import java.util.*;
import java.util.Arrays;

/**
 * Created by vnagpurkar on 6/6/16.
 */
public class Strings {


    // Remove all duplicates from a given string
    public static String dedupInput(String input) {

        if (input == null || input.length() < 2) return input;

        boolean[] mask = new boolean[256];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            if (!mask[input.charAt(i)]) {
                sb.append(input.charAt(i));
                mask[input.charAt(i)] = true;
            }
        }

        return sb.toString();

    }

    //Print all the duplicates in the input string
    public static void printDuplicates(String input) {

        if(input == null || input.length() == 0) return;

        // if ASCII then use charArray, if charset is not defined then use Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
        int CHARSIZE = 256;
        int[] charCounts = new int[CHARSIZE];

        int length = input.length();

        int cnt;
        for(int i=0; i<length; i++) {

            cnt = charCounts[input.charAt(i)];
            charCounts[input.charAt(i)] = cnt + 1;
        }
        System.out.println("Print duplicates");
        for(int i=0; i<length; i++) {
            if(charCounts[input.charAt(i)] > 1) {
                System.out.print(input.charAt(i));
            }
        }
        System.out.println();
    }

    // Return maximum occurring character in the input string
    public static char getMaximumOccurringChar(String input) {

        Map<Character, Integer> counts = new HashMap<Character, Integer>();

        int count;
        int maxCount = 0;
        char result = ' ';

        for (int i = 0; i < input.length(); i++) {
            count = 0;
            if (counts.get(input.charAt(i)) != null) {
                count = counts.get(input.charAt(i));
            }
            counts.put(input.charAt(i), count + 1);

            if (count > maxCount) {
                maxCount = count;
                result = input.charAt(i);
            }
        }
        return result;
    }

    // Remove characters from the first string which are present in the second string
    public static String removeSecondStringFromFirstString(String input1, String input2) {

        if (input2 == null || input2.length() < 1 || input1 == null || input1.length() < 1) return input1;
        boolean[] mask = new boolean[256];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input2.length(); i++) {
            if (!mask[input2.charAt(i)]) {
                mask[input2.charAt(i)] = true;
            }
        }
        for (int i = 0; i < input1.length(); i++) {
            if (!mask[input1.charAt(i)]) {
                sb.append(input1.charAt(i));
            }
        }
        return sb.toString();
    }

    // Print reverse of a string using recursion
    public static String reverseString(String input) {

        if(input == null || input.length()<1) return input;
        return reverseRecursive(new StringBuilder(), input, input.length()-1);

    }

    private static String reverseRecursive(StringBuilder sb,  String input, int pos) {

        if(pos < 0) return sb.toString();
        sb.append(input.charAt(pos));
        return reverseRecursive(sb, input, --pos);
    }

    // A Program to check if strings are rotations of each other or not
    public static boolean areRotations(String input1, String input2) {

        input1 = input1.concat(input1);

        return input1.indexOf(input2) !=-1 ;

    }

    // Write a program to print all permutations of a given string
    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    //Divide a string in N equal parts
    public static void printStringDivisions(String input, int n) {

        int partLength = input.length() / n;

        for(int i=0; i<=input.length()-partLength; i=i+partLength) {
            System.out.println(input.substring(i, i+partLength));
        }
    }

    // Find the first non-repeating character from a stream of characters,
    // You need to tell the first non-repeating character in O(1) time at any moment
    public static void firstNonRepCharInOOf1(String input) {

        int[] counts = new int[256];
        Set<Character> nonReps = new LinkedHashSet<Character>();

        for(int i=0; i<input.length(); i++) {
            counts[input.charAt(i)] = counts[input.charAt(i)] + 1;

            if(counts[input.charAt(i)] > 1) {
                nonReps.remove(input.charAt(i));
            } else {
                nonReps.add(input.charAt(i));
            }
        }

        System.out.println("The first non-repeating character from a stream of characters in O(1) time at any moment : "
                +(nonReps.iterator().hasNext() ? nonReps.iterator().next() : ' '));
    }

    // Find the first non-repeating character from a stream of characters
    public static void firstNonRepChar(String input) {

        int[] counts = new int[256];
        for(int i=0; i<input.length(); i++) {
            counts[input.charAt(i)] = counts[input.charAt(i)] + 1;
        }

        for(int i=0; i<input.length(); i++) {
            if(counts[input.charAt(i)]==1) {
                System.out.println("The first non-repeating character from a stream of characters : " + input.charAt(i));
                return;
            }
        }
        System.out.println("No non-repeating character in the stream of characters");
    }

    // Print list items containing all characters of a given word
    public static void printListOfItems(String input, List<String> items) {

        Set<Character> charsInInput = new HashSet<Character>();
        boolean[] isMatched = new boolean[256];

        for(int i=0; i<input.length(); i++){
            charsInInput.add(input.charAt(i));
        }

        int count;
        for(String s: items) {

            count = 0;
            isMatched = new boolean[256];
            for(int i=0; i<s.length(); i++) {
                if(charsInInput.contains(s.charAt(i))) {
                    if(!isMatched[s.charAt(i)]) {
                        count++;
                        isMatched[s.charAt(i)] = true;
                    }
                }
            }
            if(count == input.length()) {
                System.out.println(s);
            }
        }
    }

    // Remove “b” and “ac” from a given string
    public static void removeBAndACFromString(String input) {

        char[] chars = input.toCharArray();
        int i = 0;
        int j = 0;
        while(i<chars.length) {

            if(chars[i] == 'b') {
                i++;
            } else if(i>0 && (chars[i-1] == 'a' && chars[i] =='c')) {
                i++;
            } else {
                chars[j] = chars[i];
                j++;
                i++;
            }
        }
    }

    // Print all ways to break a string in bracket form
    // input : abc, output (a)(b)(c), (a)(bc), (ab)(c), (abc)
    // input : abcd, output (a)(b)(c)(d), (a)(bc)d, (ab)(c)(d),(abc)(d), (a)(bcd), (abcd)
    public static void breakStringInBracketForm(String input) {


    }

    private static void findCombinations (String input, int index, String output) {

        if(index == input.length()) {
            System.out.println(output);
        }

        for(int i=index; i < input.length(); i++) {

            //findCombinations(input, i+1,  );
        }
    }

    // An in-place algorithm for String Transformation
    // Given a string, move all even positioned elements to end of string. While moving elements,
    // keep the relative order of all even positioned and odd positioned elements same.
    // For example, if input = “a1b2c3d4e5f6g7h8i9j1k2l3m4″, output = “abcdefghijklm1234567891234″ in-place and in O(n) time complexity.
    public static void inPlaceStringTransformation(String input) {

        // cycle leader algorithm
        char[] chars = input.toCharArray();

        for(int position =1; position<= chars.length; position++){

        }
    }

    // Print all permutations in sorted (lexicographic) order
    public static void sortStringsLexicographically(String input) {

        // 1. sort the string in increasing order of characters

        // 2. find permutations in increasing order
        // 2.1. Take the previously printed permutation and find the rightmost character in it, which is smaller than its next character. Let us call this character as ‘first character’.
        // 2.2 Now find the ceiling of the ‘first character’. Ceiling is the smallest character on right of ‘first character’, which is greater than ‘first character’. Let us call the ceil character as ‘second character’.
        // 2.3. Swap the two characters found in above 2 steps.
        // 2.4. Sort the substring (in non-decreasing order) after the original index of ‘first character’.

        char[] chars = input.toCharArray();
        Arrays.sort(chars);

        System.out.println();
        String[] permutations = sortedLexicographically(chars);
        for(String s: permutations) {
            System.out.print(s+",");
        }
        System.out.println();
    }

    private static int factorial(int number) {
        int fact = 1;

        while(number > 1) {
            fact = fact * number--;
        }
        return fact;
    }

    private static String[] sortedLexicographically(char[] chars) {

        int size = chars.length;
        String[] permutations = new String[factorial(size)];
        int count = 0;
        while(true) {
            permutations[count++] = String.valueOf(chars);

            int firstCharLoc = chars.length-2;
            while(firstCharLoc >= 0) {
                if(chars[firstCharLoc] < chars[firstCharLoc+1]) {
                    break;
                }
                firstCharLoc--;
            }

            if(firstCharLoc == -1) { // no higher permutation present
                break;
            }

            int secondCharLoc = firstCharLoc+1;
            int smallest = secondCharLoc;

            while(secondCharLoc < chars.length) {
                if(chars[secondCharLoc] < chars[smallest] && chars[secondCharLoc] > chars[firstCharLoc]) {
                    smallest = secondCharLoc;
                }
                else {
                    secondCharLoc++;
                }
            }

            char temp =  chars[firstCharLoc];
            chars[firstCharLoc] = chars[smallest];
            chars[smallest] = temp;

            Arrays.sort(chars, firstCharLoc+1, chars.length);

        }
        return permutations;
    }

    // Lexicographic rank of a string
    public static int getLexicographicRankOfString(String input, String str) {

        String[] permutations = sortedLexicographically(input.toCharArray());

        for(int count = 0; count< permutations.length; count++) {
            if(str.toUpperCase().equals(permutations[count].toUpperCase())) {
                return count+1;
            }
        }
        return -1;
    }

    // How to find Lexicographically previous permutation?
    public static void previousLexicographicPermutation(String input) {

        //1. Take the current permutation, find the largest index i, such that input[i-1] > input[i],
        // FirstCharLoc = i
        //2. Take the smallest character next to firstCharacter such that input[FirstCharLoc] > input[SecondCharLoc]
        //3. Swap (input[firstCharLoc], input[SecondCharLoc])
        String prev = previousLexicoGraphicPermutationRec(input.toCharArray());
        System.out.println("Previous permutation "+ prev);
    }

    private static String previousLexicoGraphicPermutationRec(char[] input) {

        int firstCharLoc = input.length-2;
        while(firstCharLoc >=0) {
            if(input[firstCharLoc] >= input[firstCharLoc+1]) {
                break;
            } else {
                firstCharLoc--;
            }
        }
        if(firstCharLoc != -1) {
            int secondCharLoc = firstCharLoc;
            while(secondCharLoc <= input.length-1) {
                if(secondCharLoc > firstCharLoc && input[secondCharLoc] < input[firstCharLoc]) {
                    break;
                } else {
                    secondCharLoc++;
                }
            }
            char temp = input[firstCharLoc];
            input[firstCharLoc] = input[secondCharLoc];
            input[secondCharLoc] = temp;
            return String.valueOf(reverseSort(input, firstCharLoc+1));
        }
        return null;
    }

    private static char[] reverseSort(char[] input, int start) {
        int end = input.length-1;
        while(start <= end) {
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
        return input;
    }



    // Minimum number of palindromic subsequences to be removed to empty a binary string
    // binary String contains only 0s and 1s
    // The problem is simple and can be solved easily using below two facts.
    // 1) If given string is palindrome, we need only one removal.
    // 2) Else we need two removals.
    // Note that every binary string has all 1’s as a subsequence and all 0’s as another subsequence.
    // We can remove any of the two subsequences to get a unary string. A unary string is always palindrome.
    public static int minimumPalindromicSequences(String input) {

        if(input == null || input.length() == 0) return 0;
        if(isPalindindrome(input)) return 1;

        return 2;
    }

    private static boolean isPalindindrome(String input) {

        int left  = 0;
        int right = input.length() - 1;

        while(left <= right) {
            if(input.charAt(left) == input.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    // Finding all subsets of a given set in Java
    // Power Set - Power set P(S) of a set S is the set of all subsets of S.
    // For example S = {a, b, c} then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}
    public static void getPowerSetInJava(Character[] input) {

        if(input == null || input.length == 0 ) return;

        int n = input.length;

        for(int i=0; i< (1<<n); i++) {

            List<Character> current = new ArrayList<Character>();
            System.out.print("{");
            for(int j=0; j<n; j++) {
                if((i & (1 << j)) > 0) {
                    current.add(input[j]);
                }
            }
            for(int k=0; k<current.size(); k++) {
                System.out.print(current.get(k)+",");
            }
            System.out.print("}");
        }
    }

    // How to generate all subarrays?
    public static void printSubArray(Character[] input) {
        int n= input.length;

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                System.out.print("{");
                for(int k=i; k<=j; k++) {
                    System.out.print(input[k] + ",");
                }
                System.out.print("} , ");
            }

        }
    }

    // Find all strings formed from characters mapped to digits of a number
    // All combinations of strings that can be used to dial a number, with following specifications
    // 2 using A or B or C,
    // 3 using D or E or F,
    //.......
    // 8 using T or U or V,
    // 9 using W or X or Y or Z,
    // 1 using only 1
    // 0 using 0
    public static void printDialiNumberCombinations(int number) {

        Map<Character, Set<Character>> data = populateData();
        String input = String.valueOf(number);
        System.out.println();
        printCombinations(input, 0, data, new StringBuilder());
        System.out.println();

    }

    private static void printCombinations(String input, int i, Map<Character, Set<Character>> data, StringBuilder prefix) {

        if(i == input.length()) {
            System.out.print(prefix.toString() +",");
            return;
        }
        Set<Character> current = data.get(input.charAt(i));
        for(Character c: current) {
            prefix.append(c);
            printCombinations(input, i+1, data, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    private static Map<Character, Set<Character>> populateData() {

        Map<Character, Set<Character>> data = new HashMap<Character, Set<Character>>();

        Set<Character> current = new HashSet<Character>();
        current.add('0');
        data.put('0', current);

        current = new HashSet<Character>();
        current.add('1');
        data.put('1', current);

        current = new HashSet<Character>();
        current.add('A');
        current.add('B');
        current.add('C');
        data.put('2', current);

        current = new HashSet<Character>();
        current.add('D');
        current.add('E');
        current.add('F');
        data.put('3', current);

        current = new HashSet<Character>();
        current.add('G');
        current.add('H');
        current.add('I');
        data.put('4', current);

        current = new HashSet<Character>();
        current.add('J');
        current.add('K');
        current.add('L');
        data.put('5', current);

        current = new HashSet<Character>();
        current.add('M');
        current.add('N');
        current.add('O');
        data.put('6', current);

        current = new HashSet<Character>();
        current.add('P');
        current.add('Q');
        current.add('R');
        current.add('S');
        data.put('7', current);

        current = new HashSet<Character>();
        current.add('T');
        current.add('U');
        current.add('V');
        data.put('8', current);

        current = new HashSet<Character>();
        current.add('W');
        current.add('X');
        current.add('Y');
        current.add('Z');
        data.put('9', current);

        return data;
    }

    // Lower case to upper case – An interesting fact
    // The ASCII table is constructed in such way that the binary representation of lowercase letters is almost identical of
    // binary representation of uppercase letters.
    // The only difference is the sixth bit, setted only for lowercase letters.
    // What that elegant function does is unset the bit of index 5 of in[i], consequently, making that character lowercase.
    public static String toUpperCase(String lowerCaseString) {

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< lowerCaseString.length(); i++) {

            int start = 'a';
            int c = lowerCaseString.charAt(i);
            int end = 'z';
            if(start <= c && c <= end) {
                //c = lowerCaseString.charAt(i) - 'a' + 'A';
                c = lowerCaseString.charAt(i) & ~(1 << 5);
            }
            sb.append((char)c);
        }
        return sb.toString();
    }

    public static String toLowerCase(String uppserCaseString) {

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< uppserCaseString.length(); i++) {

            int start = 'A';
            int c = uppserCaseString.charAt(i);
            int end = 'Z';
            if(start <= c && c <= end) {
                c = uppserCaseString.charAt(i) - 'A' + 'a';
            }
            sb.append((char)c);
        }
        return sb.toString();
    }

    // Rearrange a string so that all same characters become atleast d distance away
    public static void printRearrangedString(String input, int d) {

        // 1. calculate frequency of each character in input
        // 2. create max heap of characters in input string
        // 3. place the character with maximum frequency d distance apart,
        // 4. repeat step 3 for each character

        Map<Character, Frequency> frequencyMap = new HashMap<Character, Frequency>();

        char[] chars = new char[input.length()];
        for(int i=0; i<input.length(); i++) {
            Frequency frequency = frequencyMap.get(input.charAt(i));
            if(frequency == null) {
                frequency = new Frequency(input.charAt(i), 1);
            } else {
                int f = frequency.getFrequency() + 1;
                frequency.setFrequency(f);
            }
            frequencyMap.put(input.charAt(i), frequency);
        }
        // 2. max heapify characters in frequencies
        List<Frequency> temp = new ArrayList<Frequency> (frequencyMap.values());
        Collections.sort(temp, new FrequencyCompartor());
        // 3.
        boolean canBeDone= true;
        for(Frequency f: temp) {
            int freq = f.getFrequency();
            int count = 0;
            while( freq > 0 && count < chars.length ){

                if(chars[count] == '\u0000'){
                    chars[count] = f.getCharacter();
                    count = count + d;
                    freq--;
                } else {
                    count++;
                }
            }
            if(freq > 0) {
                System.out.println(String.format("%s Cannot be rearranged.", input));
                canBeDone = false;
            }
        }
        if(canBeDone) {
            System.out.println(String.format("Rearrange %s so that all same characters become atleast d distance away, %s",
                input, String.valueOf(chars)));
        }
    }

    private static int[] maxHeapify(int[] frequencies, int current) {

        int left = 2 * current + 1;
        int right = 2 * current + 2;
        int max = current;

        if(left < frequencies.length && frequencies[left] > frequencies[max]) {
            max = left;
        }
        if(right < frequencies.length && frequencies[right] > frequencies[max]) {
            max = right;
        }
        if(current != max) {
            int temp = frequencies[current];
            frequencies[current] = frequencies[max];
            frequencies[max] = temp;
            frequencies = maxHeapify(frequencies, max);
        }

        return frequencies;
    }

    // Write a program to print all permutations of a given string
    public static void printAllPermutationsOfString(String input) {

        printPermutations("", input);
    }

    private static void printPermutations(String prefix, String input) {
        int n = input.length();
        if(n == 0) {
            System.out.println(prefix);
            return;
        }
        for(int i=0; i<n; i++) {
            printPermutations(prefix + input.charAt(i), input.substring(0, i)+ input.substring(i+1, n));
        }
    }

    // Write a method to replace all spaces in a string with'%20'. You may assume that
    // the string has sufficient space at the end of the string to hold the additional
    // characters, and that you are given the "true" length of the string. (Note: if implementing
    // in Java, please use a character array so that you can perform this operation in place.)
    // EXAMPLE
    // Input: "Mr John Smith"
    //Output: "Mr%20Dohn%20Smith"
    public static void replaceSpacesInStringInPlace(char[] input) {

        if(input == null || input.length == 0) return;

        int trueLength = input.length;
        int spaceCount = 0;
        for(int i=0; i<trueLength; i++) {
            if(input[i] == ' ') {
                spaceCount++;
            }
        }

        int newLength = trueLength + spaceCount * 2;
        // in java if input array has true length, then we need to create output array separately
        // in java to perform inplace replacement, trueLength of input should be equal to newLength
        char[] output = new char[newLength];

        int right = newLength - 1;
        int left = trueLength - 1;
        char temp;
        while(left >=0 && right >=0) {

            if(input[left] == ' ') {
                output[right--] = '0';
                output[right--] = '2';
                output[right--] = '%';
                left--;
            } else {
                temp = input[left];
                input[left] = output[right];
                output[right] = temp;
                left--;
                right--;
            }
        }

        System.out.println(String.valueOf(output));
    }

    // Implement a method to perform basic string compression using the counts of repeated characters.
    // For example, the string aabcccccaaa would become a2blc5a3.
    // If the "compressed" string would not become smaller than the original string, your method should return the original string.
    public static String compressedString(String input) {

        StringBuffer sb = new StringBuffer();
        int length = input.length();
        int count = 1;
        for(int i=0; i<length; i++) {
            if(i<length-1 && input.charAt(i) == input.charAt(i+1)) {
                count++;
            } else {
                sb.append(input.charAt(i));
                sb.append(count);
                count = 1;
            }
        }
        return sb.toString();
    }

    //Assume you have a method isSubstring which checks if one word is a substring of another.
    // Given two strings, s1 and s2, write code to check Ifs2 is a rotation of s1 using only one call to isSubstring
    // (e.g., "waterbottLe" is a rotation of "erbottLewat")
    public static boolean isS2RotationOfS1(String str1, String str2) {

        StringBuffer sb = new StringBuffer(str1);
        sb.append(str1);

        return isSubstring(sb.toString(), str2);

    }

    private static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }

    // How to sort String on their length in Java?
    public static void printAndSortStringsBasedOnLength(String[] input) {

        Arrays.sort(input, new StringLengthComparator());

        for(String s: input) {
            System.out.println(s);
        }
    }

    // Write a program to remove a given characters from String
    public static void removeCharFromString(String input, char c) {

        if(input == null || input.length() == 0) return;

        StringBuilder sb = new StringBuilder();
        int length = input.length();
        for(int i=0; i< length; i++) {
            if(input.charAt(i) != c) {
                sb.append(input.charAt(i));
            }
        }
        System.out.println(String.format("String %s after removing character %c is %s", input, c, sb.toString()));
    }

    // How to return highest occurred character in a String
    public static void getHighestOccurredCharacter(String input) {

        if(input == null || input.length() == 0) return;
        // if string has only ASCII/unicode characters, char[] can be used instead of map
        Map<Character, Integer> charCounts = new HashMap<Character, Integer>();

        int length = input.length();

        int count;
        int max = Integer.MIN_VALUE;
        char c=' ';
        for(int i=0; i<length; i++) {

            count = 1;
            if(charCounts.containsKey(input.charAt(i))) {
                count = count + charCounts.get(input.charAt(i));
            }
            charCounts.put(input.charAt(i), count);
            if(count > max) {
                max = count;
                c = input.charAt(i);
            }
        }
        System.out.println(String.format("Highest occurred character in a string %s is %c", input, c));
    }

    // Write a program to check if a String contains another String e.g. indexOf()
    public static int contains(String input1, String input2) {

        if(input1 == null || input2 == null) return -1;

        int length1 = input1.length();
        int length2 = input2.length();

        if(length1 < length2) return -1;

        int i = 0;
        int j = 0;

        while(i < length1 && j < length2) {
            if(input1.charAt(i) == input2.charAt(j)) {
                j++;
            } else {
                j=0;
            }
            i++;
        }
        if(j== length2) {
            return 0;
        }
        return -1;
    }

    // Print all interleavings of given two strings
    public static void printInterleavingsOfStrings(String input1, String input2) {

    }
    // How to check if a String is valid shuffle of two String
    public static void checkIfStringIsValidShuffleOfTwoStrings(String input1, String input2, String input3) {


    }

    // How to reverse words in a sentence without using library method
    // input = I am a girl
    // output = girl a am I
    public static void reverseWords(String sentence) {

        if(sentence == null) return;

        int length = sentence.length();
        Stack<Character> temp = new Stack<Character>();
        StringBuilder sb = new StringBuilder();

        for(int i=length-1; i>=0; i--) {

            if(sentence.charAt(i) == ' ') {
                while(!temp.isEmpty() && temp.peek() !='.') {
                    sb.append(temp.pop());
                }
                sb.append(sentence.charAt(i));
            } else {
                temp.push(sentence.charAt(i));
            }
        }
        while(!temp.isEmpty()) {
            sb.append(temp.pop());
        }
        System.out.println(String.format("Reverse words in a sentence %s is", sentence));
        System.out.println(sb.toString());
    }

    // How to check if String is Palindrome
    public static boolean isPalindrome(String input) {
        if(input == null) {
            return false;
        }
        int length = input.length();
        int end = length -1;
        int start = 0;

        while(start<=end) {
            if(input.charAt(start) == input.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    // How to count occurrence of a given character in String
    public static int countOccurence(String input, char c) {

        if(input == null || input.length() == 0) return -1;
        int count = 0;
        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    // Write a method to sort an array of strings so that all the anagrams are next to each other
    public static List<Set<String>> getAnagramsTogether(String[] input) {

        List<Set<String>> output = new ArrayList<Set<String>>();

        Map<String, Set<String>> temp = new HashMap<String, Set<String>>();
        char[] chars;
        String key;
        for(String s: input) {

            chars = s.toCharArray();
            Arrays.sort(chars);
            key = String.valueOf(chars);

            Set<String> current;
            if(temp.containsKey(key)) {
                current = temp.get(key);
            } else {
                current = new HashSet<String>();
            }
            current.add(s);
            temp.put(key, current);
        }
        for(Map.Entry<String, Set<String>> entry: temp.entrySet()) {
            output.add(entry.getValue());
        }
        return output;
    }

    // Write a method to sort an array of strings so that all the anagrams are next to each other
    public static void printAnagramsTogetherUsingComparator(String[] input) {

        System.out.println(2);
        Arrays.sort(input, new AnagramComparator());
        for(String s: input) {
            System.out.print(s+",");
        }
        System.out.println();
    }

    public static void printAnagramsTogether(String[] input) {

        // 1. create temp map
        Map<String, Set<String>> temp = new HashMap<String, Set<String>>();
        char[] chars;
        String key;
        Set<String> current;
        for(String s: input) {
            chars = s.toCharArray();
            Arrays.sort(chars);
            key = String.valueOf(chars);

            if(temp.containsKey(key)) {
                current = temp.get(key);
            } else {
                current = new HashSet<String>();
            }
            current.add(s);
            temp.put(key, current);
        }

        // 2. copy sorted values from map to input array
        int cnt = 0;
        for(Map.Entry<String, Set<String>> entry: temp.entrySet()) {
            current = entry.getValue();
            for(String s: current) {
                input[cnt++] = s;
            }
        }

        // 3. print sorted array
        System.out.println(3);
        for(String s: input) {
            System.out.print(s+",");
        }
        System.out.println();
    }

    // You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
    // Write a method to merge B into A in sorted order
    // inserting elements at the back of the array
    public static void printSortedArraysAtBegining(int[] A, int[] B) {

        int lengthA = A.length;
        int lengthB = B.length;

        int indexA = lengthA;
        int indexB = 0;

        for(int i=lengthA-1; i>=0; i--) {

            if(A[i] != 0) {
                A[--indexA] = A[i];
            }
        }
        // now all elements from array A are shifted from indexA to lengthA-1

        // now populate A by comparing elements from A and B
        for(int i=0; i<lengthA && indexB<lengthB;i++) {

            if(A[indexA] <= B[indexB]) {
                A[i] = A[indexA];
                indexA++;
            } else {
                A[i] = B[indexB];
                indexB++;
            }
        }

        // print sorted array
        System.out.println();
        for(int i=0;i<lengthA;i++) {
            System.out.print(A[i]+",");
        }
        System.out.println();
    }
    // inserting elements at the back of the array
    public static void printSortedArraysAtEnd(int[] A, int[] B) {

        int lengthA = A.length;
        int lengthB = B.length;

        int indexB = lengthB-1;
        int indexA = 0;
        while(A[indexA] != 0) {
            indexA++;
        }
        indexA = indexA - 1;

        for(int i=lengthA-1; i>=0 && indexA>=0 && indexB>=0; i--) {

            if(A[indexA] > B[indexB]) {
                A[i] = A[indexA];
                indexA--;
            } else {
                A[i] = B[indexB];
                indexB--;
            }
        }

        // print sorted array
        System.out.println();
        for(int i=0;i<lengthA;i++) {
            System.out.print(A[i]+",");
        }
        System.out.println();
    }

    // Given an MX N matrix in which each row and each column is sorted in ascending order, write a method to find an element
    public static void printFindElement(int[][] input, int x) {

        int row = 0;
        int col = input[0].length-1;

        while(row < input.length && col >=0) {
            if(input[row][col] == x) {
                System.out.println(String.format("%d found element",x));
                return;
            } else if(x > input[row][col]) {
                row = row+1;
            } else {
                col = col -1;
            }
        }
        System.out.println(String.format("Could not found element %d", x));
    }

    // Generate all binary strings from given pattern

}
