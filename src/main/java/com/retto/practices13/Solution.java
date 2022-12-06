package com.retto.practices13;

import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-generics/problem
public class Solution {

    // Generic method
    private static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer> inputIntegers = new ArrayList<>();  
        List<String> inputStrings = new ArrayList<>();  
        String line = bufReader.readLine();
        
        while(!line.isEmpty()) {
            try {
                int item = Integer.parseInt(line);    
                inputIntegers.add(item);
            }catch(NumberFormatException nfe) {
                inputStrings.add(line);
            }
            
            line = bufReader.readLine();
        }
        
        printArray(inputIntegers.toArray());
        printArray(inputStrings.toArray());
        
        }catch(IOException exception) {
           exception.printStackTrace();
        }
    }
}
