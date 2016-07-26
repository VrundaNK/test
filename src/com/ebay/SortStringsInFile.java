package com.ebay;

//import java.io.BufferedReader;
import java.io.File;
//import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by vnagpurkar on 7/20/16.
 */
public class SortStringsInFile {

    //Ebay interview question 2
    // Given a file that contains many strings, how would you sort all strings in the file?
    // What is the time and space complexity?
    // How would you improve on the algorithm?
    //Reading strings from file
    //Use External Merge Sort to sort the strings


    // What about finding a string in the file?
    // Ans. Strings are already sorted, hence we should use binary search to find a word in file.
    public static void binarySearchString(String[] words, String word, int left, int right) {

        if(left > right) {
            System.out.println(String.format("%s word is not present in file.",word));
            return;
        }

        int mid = (left + right)/2;

        if(word.compareTo(words[mid]) == 0) { // word matches with words[mid]
            System.out.println(String.format("%s word is present in file.",word));
        }
        else if(word.compareTo(words[mid]) < 0) { // word < words[mid], hence we should search in left array
            binarySearchString(words, word, left, mid-1);
        } else {
            binarySearchString(words, word, mid+1, right);
        }
    }
    // What about finding a string in the file?
    // Ans. If Strings are not sorted, that means we need to address finding a string in the file containing many strings
    // separately, then we need to use Scanner class and findWithinHorizon(pattern, horizon) method
    public static void findAStringInFile(String filename, String word) {

        Scanner sc = null;
        try {

            //Scanner sc = new Scanner(new BufferedReader(new FileReader(new File(filename))));
            File file = new File(filename);
            sc = new Scanner(file);
            // when using scanner, we do not need to set delimiter, it considers delimiter
            //Pattern delimiter = Pattern.compile(" ");
            //sc.useDelimiter(delimiter);
            Pattern pattern = Pattern.compile(word);
            while(sc.findWithinHorizon(pattern, 0) != null) {
                System.out.println(String.format("%s word is present in file.",word));
                return;
            }
            System.out.println(String.format("%s word is not present in file.",word));

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

}
