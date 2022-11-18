package com.retto.practices7;

public class Solution1 {

	private static int findKthLargest(int[] nums, int k) {

		KthLargestList list = new KthLargestList(k);

		for (int i = 0; i < nums.length; i++) {
			list.addNode(nums[i]);
		}

		System.out.println(list);

		return list.getElement(k);
	}

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));

	}

}

class KthLargestList {

	Node head;
	Node end;
	final int k;
	int size;

	public KthLargestList(int size) {
		this.size = 0;
		this.k = size;
		head = end = null;
	}

	public int getElement(int k) {
		return end.value;
	}

	public void addNode(int number) {
		if (head == null) {
			head = new Node(number);
			end = head;
			size++;
		} else {
			Node newNode = new Node(number);
			size++;
			Node current = head;
			while (current.value > number) {
				if (current.next == null || current.next.value < number)
					break;
				current = current.next;
			}

			if (current == head) {
				if (head.value > newNode.value) {
					newNode.next = head.next;
					if (head.next != null)
						head.next.prev = newNode;
					head.next = newNode;
					newNode.prev = head;
				} else {
					head.prev = newNode;
					newNode.next = head;
					head = newNode;
				}
			} else {
				if (current.next == null)
					end = newNode;
				newNode.next = current.next;
				if (current.next != null)
					current.next.prev = newNode;
				current.next = newNode;
				newNode.prev = current;
			}

			if (size > k) {
				if (end.prev != null)
					end = end.prev;
				size--;
			}
		}
	}

	@Override
	public String toString() {
		return "KthLargestList [head=" + head + ", end=" + end + ", k=" + k + ", size=" + size + "]";
	}
}

class Node {
	int value;
	Node next;
	Node prev;

	Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "{value:" + value + ", next:" + next + "}";
	}
}