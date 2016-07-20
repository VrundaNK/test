package com.company.codingbat.warmup2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vnagpurkar on 7/11/16.
 */
public class warmup2 {

    // stringTimes
    public static String stringTimes(String str, int n) {

        if(str == null || str.length() == 0) return str;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    // frontTimes
    public static String frontTimes(String str, int n) {

        if(str == null || str.length() == 0) return str;

        int end = str.length() < 3 ? str.length() : 3;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(str.substring(0,end));
        }
        return sb.toString();
    }

    // countXX, overlapping is allowed
    public static int countXX(String str) {

        int count  = 0;
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i) == 'x') {
                if(str.charAt(i+1) == 'x') {
                    count++;
                }
            }
        }
        return count;
    }

    // doubleX
    public static boolean doubleX(String str) {

        // 1. brute force
        /*for(int i=0; i< str.length()-1; i++) {
           if(str.charAt(i) == 'x' && str.charAt(i+1) == 'x') {
               return true;
           }
        }
        return false;*/

        // using indexOf
        /*int index = str.indexOf('x');
        if(index == -1) return false; // x is not present
        if(index<str.length()-1) {
            if(str.charAt(index+1) == 'x') return true;
        }
        return false;*/

        // using contains
        // return str.toLowerCase().contains('xx');

        // using regular expression
        Pattern pattern = Pattern.compile("\\bxx\\b");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    // stringBits
    public static String stringBits(String str) {

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i=i+2) {

            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // last2
    public static int lastTwo(String str) {

        if(str == null || str.length() <=2) return -1;
        String substring = str.substring(str.length()-2);

        int count = 0;
        for(int i=0; i<str.length()-2; i++) {
            if(str.substring(i, i+2).equals(substring)) {
                count++;
            }
        }
        return count;
    }

    // array123
    public static boolean array123(int[] input) {

        return false;
        
    }


}
