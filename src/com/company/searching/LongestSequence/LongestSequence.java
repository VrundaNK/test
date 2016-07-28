package com.company.searching.LongestSequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vnagpurkar on 7/26/16.
 */
public class LongestSequence {

    /*
    A circus is designing a tower routine consisting of people standing atop one another's
shoulders. For practical and aesthetic reasons, each person must be both shorter
and lighter than the person below him or her. Given the heights and weights of
each person in the circus, write a method to compute the largest possible number
of people in such a tower
     */

    public static void tower(List<HeightWeight> people) {

        Collections.sort(people, new HeightComparator());

        List<List<HeightWeight>> solutions = new ArrayList<List<HeightWeight>>();
        solutions = longestIncresingSubsequence(people, solutions, 0);

        List<HeightWeight> longestSequence = new ArrayList<HeightWeight>();
        for(int i=0; i< solutions.size(); i++) {
            longestSequence = sequenceWithMaximumLength(longestSequence, solutions.get(i));
        }
    }

    private static List<List<HeightWeight>> longestIncresingSubsequence(List<HeightWeight> people, List<List<HeightWeight>> solutions, int currentIndex) {

        if(currentIndex >= people.size() || currentIndex < 0){
            return solutions;
        }

        for(int i=0; i<currentIndex; i++) {

            HeightWeight currentPerson = people.get(i);
            List<HeightWeight> bestSequence = null;
            if(currentPerson.isBefore(people.get(currentIndex))){
                bestSequence = solutions.get(currentIndex);
            }
            List<HeightWeight> newSolution = new ArrayList<HeightWeight>();
            if(bestSequence != null) {
                newSolution.addAll(bestSequence);
            }
            newSolution.add(currentPerson);

            solutions.add(currentIndex, newSolution);
            solutions = longestIncresingSubsequence(people, solutions, currentIndex+1);
        }
        return solutions;
    }

    private static List<HeightWeight> sequenceWithMaximumLength(List<HeightWeight> seq1, List<HeightWeight> seq2) {

        if(seq1 == null || seq1.isEmpty()) {
            return seq2;
        }
        if(seq2 == null || seq2.isEmpty()) {
            return seq1;
        }

        if(seq1.size() >= seq2.size()) {
            return seq1;
        }

        return seq2;
    }
}
