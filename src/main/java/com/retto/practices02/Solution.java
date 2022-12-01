package com.retto.practices02;

import java.util.HashSet;
import java.util.Set;

/**
 * Hi, here's your problem today. This problem was recently asked by Facebook:

You are given a list of numbers, and a target number k. Return whether or not there are two numbers in the list that add up to k.

Solution: Use Set data structure to solve problem
 *
 */
public class Solution {
	
	private static boolean two_sum(int[] numbers, int k) {
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i < numbers.length; i++) {
			int target = k - numbers[i];
			if(set.contains(target))
				return true;
			else
				set.add(numbers[i]);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(two_sum(new int[] {4, 7, 1, -3, 2}, 5));
	}
} 