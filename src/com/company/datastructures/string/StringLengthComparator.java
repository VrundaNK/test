package com.company.datastructures.string;

import java.util.Comparator;

/**
 * Created by vnagpurkar on 7/5/16.
 */
public class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {

        // Method1
        if (s1.length() > s2.length()) return 1;
        if (s1.length() < s2.length()) return -1;

        return 0;

        // method2 (this is in Java 7, not in java 6
        /* return Integer.compare(s1.length(), s2.length());*/
    }
}
