package com.crackingthecodinginterview;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromUnsortedLinkedList {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(input1()));
		System.out.println(removeDuplicates(input2()));
		System.out.println(removeDuplicatesUnsorted(input3()));
	}

	public static ListNode removeDuplicates(ListNode head) {
		ListNode temp = head;
		Set<Integer> entries = new HashSet<>();
		ListNode prev = null;
		while (temp != null) {
			if (entries.contains(temp.val)) {
				if (temp.next != null) {
					temp.val = temp.next.val;
					temp.next = temp.next.next;
				} else if (prev != null) {
					prev.next = null;
				}
			} else {
				entries.add(temp.val);
			}
			prev = temp;
			temp = temp.next;
		}
		return head;
	}

	public static ListNode removeDuplicatesUnsorted(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			ListNode temp1 = temp;
			while (temp1 != null && temp1.next != null) {
				if (temp.val == temp1.next.val) {
					if (temp1.next.next != null) {
						temp1.next.val = temp1.next.next.val;
						temp1.next = temp1.next.next;
						continue;
					} else {
						temp1.next = null;
					}
				}
				temp1 = temp1.next;
			}
			temp = temp.next;
		}
		return head;
	}

	private static ListNode input1() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(4);
		return head;
	}

	private static ListNode input3() {
		ListNode head = new ListNode(10);
		head.next = new ListNode(12);
		head.next.next = new ListNode(11);
		head.next.next.next = new ListNode(11);
		head.next.next.next.next = new ListNode(12);
		head.next.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next.next = new ListNode(13);
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
