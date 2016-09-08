package com.company.datastructures.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by vnagpurkar on 7/6/16.
 */
public class AnagramComparator implements Comparator<String> {

    private String sortChars(String str) {

        char[] chars = str.toCharArray();
        //Arrays.sort(chars); // this can be implemented as sortCharArray
        chars = sortCharArray(chars);
        return String.valueOf(chars);
    }

    private char[] sortCharArray(char[] input) {

        int[] temp = new int[26];
        int index;
        for(int i=0; i<input.length; i++) {
            index = input[i]-'a';
            temp[index] = temp[index]+1;
        }

        index = 0;
        for(int i=0; i<26; i++) {
            int count = temp[i];
            while(count > 0) {
                input[index++] = (char) (i+'a');
                count--;
            }
        }
        return input;
    }

    @Override
    public int compare(String s1, String s2) {

        return sortChars(s1).compareTo(sortChars(s2));
    }
}
