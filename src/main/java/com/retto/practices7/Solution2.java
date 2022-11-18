package com.retto.practices7;

public class Solution2 {

	private static int[] nums;

	private static int partition(int left, int right, int pivot) {
		int pivotValue = nums[pivot];
		swap(pivot, right);
		int current = left;
		for (int i = left; i <= right; i++) {
			if (nums[i] < pivotValue) {
				swap(current, i);
				current++;
			}
		}
		swap(current, right);

		return current;
	}

	private static int select(int left, int right, int K) {
		if (left == right)
			return nums[left];

		int pivot = (left + right) / 2;

		pivot = partition(left, right, pivot);
		if (K == pivot) {
			return nums[K];
		} else if (K < pivot) {
			// search on left partition 
			return select(left, pivot - 1, K);
		} else {
			// search on right partition 
			return select(pivot + 1, right, K);
		}
	}

	public static int findKthLargest(int[] _nums, int K) {
		nums = _nums;
		int size = nums.length;
		return select(0, size - 1, size - K);
	}

	private static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
		System.out.println(findKthLargest(new int[] { -1, 0, 2 }, 2));
		System.out.println(findKthLargest(new int[] { 2, 1 }, 1));
	}

}