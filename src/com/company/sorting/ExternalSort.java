package com.company.sorting;

import java.io.*;
import java.util.Arrays;

/**
 * Created by vnagpurkar on 7/21/16.
 */
/*
Assumptions : 1. File size on disk = 2000000
              2. File contains 1 String 1 line
 */
public class ExternalSort {

    static int totalSize = 2000000; // size of the file in disk
    static int bufferSize = 100000; // max items the memory buffer can hold

    public static void externalSort(String fileName) {

        String[] buffer = new String[bufferSize < totalSize ? bufferSize : totalSize];
        StringBuilder tempFile = new StringBuilder("tempFile");

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            int slices = (int) Math.ceil((double) bufferSize / bufferSize);

            // Read complete file in chunks of M words
            for (int i = 0; i < slices; i++) {

                // Read M words (one word per line)
                for (int j = 0; j < buffer.length; j++) {

                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            buffer[j] = line;
                        } else {
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                // sort buffer words
                Arrays.sort(buffer);

                // write sorted words to tempFile
                tempFile.append(i).append("txt");
                writeToFile(buffer, tempFile.toString());
                buffer = buffer.clone();
            }

            // read all tempfiles and compare nth Strings in all files

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void writeToFile(String[] words, String fileName) {

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (String w : words) {
                bufferedWriter.write(w);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void mergeSortedFiles(int slices, StringBuilder tempFileName) {

        BufferedReader[] bufferedReaders = new BufferedReader[slices];
        String[] words = new String[slices];
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        File file;
        try {
            for (int i = 0; i < slices; i++) {

                tempFileName.append(i).append("txt");
                FileReader fileReader = null;
                BufferedReader bufferedReader = null;

                fileReader = new FileReader(tempFileName.toString());
                bufferedReader = new BufferedReader(fileReader);

                // reads 1st word from all slices
                words[i] = bufferedReaders[i].readLine();

                bufferedReaders[i] = bufferedReader;
            }

            fileWriter = new FileWriter("Output.txt");
            bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < totalSize; i++) {

                String minWord = words[0];
                int minWordSliceNumber = 0;

                for (int j = 0; j < slices; j++) {

                    if (words[j] != null) {
                        if (minWord == null || minWord.compareTo(words[j]) > 0) {
                            minWord = words[j];
                            minWordSliceNumber = j;
                        }
                    }
                }
                // write smaller word to file
                bufferedWriter.write(minWord);
                // read next word from Buffer reader of the smallerWordSliceNumber
                words[minWordSliceNumber] = bufferedReaders[minWordSliceNumber].readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
                bufferedWriter.close();
                for(int i=0; i<slices; i++) {
                    bufferedReaders[i].close();
                    file = new File(tempFileName.toString());
                    file.delete();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
