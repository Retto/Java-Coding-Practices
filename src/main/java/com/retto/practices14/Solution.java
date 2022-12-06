package com.retto.practices14;

import java.util.*;

// https://www.hackerrank.com/challenges/java-dequeue/problem?isFullScreen=true
public class Solution {

	private static void addToCountMap(HashMap<Integer, Integer> map, int num) {
		if (map.containsKey(num)) {
			map.put(num, map.get(num).intValue() + 1);
		} else {
			map.put(num, 1);
		}
	}

	private static void removeFromCountMap(HashMap<Integer, Integer> map, int removed) {
		// remove actually if count equals to 0 otherwise decrease count
		if (map.containsKey(removed)) {
			int count = map.get(removed).intValue();
			count--;
			if (count == 0) {
				map.remove(removed);
			} else {
				map.put(removed, count);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int n = in.nextInt();
		int m = in.nextInt();

		HashMap<Integer, Integer> countMap = new HashMap<>();
		int maxUniqueNumber = 0;

		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			if (deque.size() < m) {
				deque.addLast(num);
				addToCountMap(countMap, num);
			} else {
				if (maxUniqueNumber < countMap.size()) {
					maxUniqueNumber = countMap.size();
				}
				Integer removed = deque.removeFirst();
				removeFromCountMap(countMap, removed);
				deque.addLast(num);
				addToCountMap(countMap, num);
			}
		}

		System.out.println(maxUniqueNumber == 0 ? countMap.size() : maxUniqueNumber);
		in.close();
	}
}
