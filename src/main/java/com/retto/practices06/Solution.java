package com.retto.practices06;

public class Solution {

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

	private static boolean check(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				if (i + 2 < nums.length && nums[i + 2] >= nums[i])
					nums[i + 1] = nums[i];
				else {
					if (i + 2 == nums.length) {
						nums[i + 1] = max(nums[i], nums[i + 1]);
					} else {
						nums[i] = nums[i + 1];
					}
				}

				break;
			}
		}

		for (int i = 0; i < nums.length - 1; i++) {
			if (!(nums[i] <= nums[i + 1])) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(check(new int[] { 13, 4, 7 }));

		System.out.println(check(new int[] { 5, 1, 3, 2, 5 }));
	}
}
