package com.leetcode;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		System.out.println(oddEvenList(test1()));
		System.out.println(oddEvenList(test2()));
	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null)
			return null;
		ListNode tempOdd = null, tempEven = null, odd = null, even = null;
		ListNode temp = head;
		boolean isOdd = true;
		while (temp != null) {
			if (tempOdd == null) {
				odd = getNode(null, temp.val);
				tempOdd = odd;
			} else if (even == null) {
				even = getNode(null, temp.val);
				tempEven = even;
			} else if (isOdd) {
				tempOdd = getNode(tempOdd, temp.val);
			} else {
				tempEven = getNode(tempEven, temp.val);
			}
			temp = temp.next;
			isOdd = !isOdd;
		}
		tempOdd.next = even;
		return odd;

	}

	private static ListNode getNode(ListNode node, int val) {
		if (node == null)
			return new ListNode(val);
		node.next = new ListNode(val);
		return node.next;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			ListNode temp = this;
			while (temp != null) {
				sb.append(temp.val + " ");
				temp = temp.next;
			}
			return sb.toString();
		}

	}

	private static ListNode test1() {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		return node;
	}

	private static ListNode test2() {
		ListNode node = new ListNode(2);
		node.next = new ListNode(1);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(5);
		node.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next.next = new ListNode(7);
		return node;
	}

}
