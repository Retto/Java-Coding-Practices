package com.retto.practices8;

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode head = new ListNode();
		ListNode current = head;

		int shiftToNext = 0;

		while (l1 != null || l2 != null) {
			int digit = 0;
			if (l1 != null)
				digit += l1.val;
			if (l2 != null)
				digit += l2.val;

			digit = digit + shiftToNext;
			current.next = new ListNode(digit % 10);

			if (digit > 9)
				shiftToNext = 1;
			else
				shiftToNext = 0;

			current = current.next;

			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}

		if (shiftToNext > 0) {
			current.next = new ListNode(1);
		}

		return head.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		Solution s = new Solution();
		ListNode node = s.addTwoNumbers(l1, l2);

		while (node != null) {
			System.out.print(node.val);
			node = node.next;
		}
	}
}

/**
 * Definition for singly-linked list.
 */

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}