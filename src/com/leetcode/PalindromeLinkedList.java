package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {
		System.out.println(isPalindrome(input1()));
		System.out.println(isPalindrome(input2()));
		System.out.println(isPalindrome(input3()));
	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		ListNode reversed = reverse(head);
		ListNode temp = head;
		while (temp != null && reversed != null) {
			if (temp.val != reversed.val)
				return false;
			temp = temp.next;
			reversed = reversed.next;
		}
		return true;
	}

	private static ListNode reverse(ListNode head) {
		if (head == null)
			return null;

		ListNode reversed = null;
		ListNode temp = head;

		while (temp != null) {
			if (reversed == null) {
				reversed = new ListNode(temp.val);
			} else {
				ListNode rev = new ListNode(temp.val);
				rev.next = reversed;
				reversed = rev;
			}
			temp = temp.next;
		}

		return reversed;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	private static ListNode input1() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		return head;
	}

	private static ListNode input2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(1);
		return head;
	}

	private static ListNode input3() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		return head;
	}

}
