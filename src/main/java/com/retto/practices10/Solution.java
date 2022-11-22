package com.retto.practices10;

public class Solution {
	
	private static int witnesses(int[] heights) {
		
		int witnessCount = 0;
		int lastTallestPerson = Integer.MIN_VALUE;
		
		for(int i=heights.length-1; i > -1; i--) {
			if(heights[i] > lastTallestPerson) {
				witnessCount++;
				lastTallestPerson = heights[i];
			}
		}
		
		return witnessCount;
	} 
	
	public static void main(String[] args) {
		System.out.println(witnesses(new int[] {3, 6, 3, 4, 1}));
	}
}
