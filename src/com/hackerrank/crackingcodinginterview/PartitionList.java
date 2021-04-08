package com.hackerrank.crackingcodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class PartitionList {

	public static void main(String[] args) {
		System.out.println(partition(input1(), 3));
		System.out.println(partition(input2(), 2));
	}

	public static ListNode partition(ListNode head, int x) {
		ListNode left = null;
		ListNode right = null;
		ListNode tempLeft = null;
		ListNode tempRight = null;
		while (head != null) {
			if (head.val < x) {
				if (left == null) {
					left = head;
					tempLeft = left;
				} else {
					tempLeft.next = head;
					tempLeft = tempLeft.next;
				}
			} else {
				if (right == null) {
					right = head;
					tempRight = left;
				} else {
					tempRight.next = head;
					tempRight = tempRight.next;
				}
			}
			head = head.next;
		}
		if (tempLeft != null)
			tempLeft.next = null;
		if (tempRight != null)
			tempRight.next = null;

		if (left != null) {
			tempLeft.next = right;
			return left;
		}

		return right;
	}

	private static ListNode input1() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		return head;
	}

	private static ListNode input2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		return head;
	}

	private static class ListNode {
		private int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
		}

		@Override
		public String toString() {
			ListNode temp = this;
			StringBuilder sb = new StringBuilder();
			while (temp != null) {
				sb.append(temp.val + " ");
				temp = temp.next;
			}
			return sb.toString();
		}

	}

}
