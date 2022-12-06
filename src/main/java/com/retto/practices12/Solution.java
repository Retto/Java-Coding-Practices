package com.retto.practices12;

import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'cosine_similarity' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a_keys
     *  2. DOUBLE_ARRAY a_values
     *  3. INTEGER_ARRAY b_keys
     *  4. DOUBLE_ARRAY b_values
     */     
     public static double dotProduct(List<Integer> a_keys, List<Double> a_values, List<Integer> b_keys, List<Double> b_values)
     {
        int aIndex = 0;
        int bIndex = 0;
        double sum = 0;
        
        int min = Math.min(a_keys.size(), b_keys.size());
        
        while(aIndex < min && bIndex < min) {
        	int currentAIndex = a_keys.get(aIndex);
        	int currentBIndex = b_keys.get(bIndex);
        	
        	if(currentAIndex == currentBIndex) {        		
        		sum += (a_values.get(aIndex) * b_values.get(bIndex));
        		aIndex++;
        		bIndex++;
        	} else {
        		if(currentAIndex < currentBIndex) {
        			aIndex++;
        		} else {
        			bIndex++;
        		}
        	}
        }
        
         return sum;
     }
     
     public static double calculateMagnitude(List<Double> values) {
         double sum = 0;
         for (Double value : values) {
             sum += (value*value);
         }
         
         return Math.sqrt(sum);
     }

    public static double cosine_similarity(List<Integer> a_keys, List<Double> a_values, List<Integer> b_keys, List<Double> b_values)   
    {
        
        double magnitudeA = calculateMagnitude(a_values);
        double magnitudeB = calculateMagnitude(b_values);
        
        double dotProduct = dotProduct(a_keys, a_values, b_keys, b_values);
        
        return dotProduct / (magnitudeA*magnitudeB);
    }

}

public class Solution {
    public static void main(String[] args) {
        
    	// Array given as sparse vectors.  
    	
        // double result = Result.cosine_similarity(Arrays.asList(2, 4, 5, 8), Arrays.asList(7.0, 5.0, 12.0, 1.0), Arrays.asList(2, 4, 5, 8), Arrays.asList(7.0, 5.0, 12.0, 1.0));
    	// double result = Result.cosine_similarity(Arrays.asList(689944194), Arrays.asList(346.932302390659), Arrays.asList(689944194), Arrays.asList(780.418827561857));
        // double result = Result.cosine_similarity(Arrays.asList(2, 4, 5), Arrays.asList(7.0, 5.0, 12.0), Arrays.asList(2, 4, 5, 8), Arrays.asList(7.0, 5.0, 12.0, 1.0));
    	double result = Result.cosine_similarity(Arrays.asList(1,2,5), Arrays.asList(10.0,9.0,8.0), Arrays.asList(3,5,6,7), Arrays.asList(1.0, 2.0, 3.0, 4.0));
    	        
    	System.out.println(result);
    }
}