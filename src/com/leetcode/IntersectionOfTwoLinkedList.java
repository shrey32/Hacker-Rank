package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class IntersectionOfTwoLinkedList {

	public static void main(String[] args) {

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = length(headA);
		int lenB = length(headB);
		if (lenA > lenB) {
			int diff = lenA - lenB;
			while (diff > 0) {
				headA = headA.next;
				diff--;
			}
		} else {

			int diff = lenB - lenA;
			while (diff > 0) {
				headB = headB.next;
				diff--;
			}
		}
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}

		return null;
	}

	private int length(ListNode head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			len++;
		}
		return len;
	}

	private static class ListNode {
		private int val;
		
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
