package com.retto.practices1;

import java.util.Arrays;

/**
 * Hi, here's your problem today. This problem was recently asked by Google:
 * 
 * Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list
 * in O(n) time.
 * 
 * Example 1: Input: [3, 3, 2, 1, 3, 2, 1] Output: [1, 1, 2, 2, 3, 3, 3]
 * 
 * def sortNums(nums): # Fill this in.
 * 
 * print sortNums([3, 3, 2, 1, 3, 2, 1]) # [1, 1, 2, 2, 3, 3, 3]
 * 
 * Challenge: Try sorting the list using constant space.
 *
 */
public class Problem1 {

	/**
	 * Solution: There are only 3 unique numbers. So, count them and construct
	 * response array
	 * 
	 * time complexity is O(n)
	 * space complexity is constant space
	 * 
	 * Critics: if identity is important this approach has some drawbacks
	 * So, there is also better approaches for solution:
	 * https://en.wikipedia.org/wiki/Dutch_national_flag_problem
	 * 
	 * 
	 * @param numbers
	 * @return
	 */
	public static int[] sortNums(int[] numbers) {

		final int[] uniques = { 1, 2, 3 };
		int[] counts = { 0, 0, 0 };

		// iterate n-times
		for (int i = 0; i < numbers.length; i++) {
			counts[numbers[i] - 1]++;
		}

		int index = 0;
		// iterate n-times
		for (int i = 0; i < numbers.length;) {
			if(counts[index] > 0) {
				numbers[i++] = uniques[index];
				counts[index]--;
			} else {
				index++;
			}
		}

		return numbers;
	}
	
	/**
	 * Reference: https://en.wikipedia.org/wiki/Dutch_national_flag_problem
	 * 
	 * The following pseudocode for three-way partitioning which assumes zero-based array indexing was proposed by Dijkstra himself.[2] It uses three indices i, j and k, maintaining the invariant that i ≤ j ≤ k.

Entries from 0 up to (but not including) i are values less than mid,
entries from i up to (but not including) j are values equal to mid,
entries from j up to (and including) k are values not yet sorted, and
entries from k + 1 to the end of the array are values greater than mid.

	 * @param numbers
	 * @return
	 */
	public static int[] three_way_partition(int[] numbers) {
		
		// 1, 2, 3. So, mid number is 2.
		final int mid = 2;
				
		int i=0;
		int j=0;
		int k = numbers.length-1;
		
		while(j <= k) {
			if(numbers[j] < mid) {
				swap(numbers, i, j);
				i++;
				j++;
			} else if(numbers[j] > mid) {
				swap(numbers, j, k);
				k--;
			} else {
				j++;
			}
		}
		
		return numbers;
	} 
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {

		int[] input = { 3, 3, 2, 1, 3, 2, 1 };

		System.out.println("My Algorithm: " + Arrays.toString(sortNums(input)));
		System.out.println("Dutch national flag problem: " + Arrays.toString(three_way_partition(input)));
	}

}
