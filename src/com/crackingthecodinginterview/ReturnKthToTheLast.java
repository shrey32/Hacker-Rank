package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class ReturnKthToTheLast {

	public static void main(String[] args) {
		System.out.println(kthFromLast(input1(), 4));
		System.out.println(kthFromLast(input2(), 0));
	}

	private static ListNode kthFromLast(ListNode head, int k) {
		List<ListNode> list = new ArrayList<>();
		ListNode temp = head;
		while (temp != null) {
			list.add(temp);
			temp = temp.next;
		}

		int kth = list.size() - 1 - k;
		if (list.size() <= 1)
			return null;
		else if (list.size() == k)
			head = head.next;
		else
			list.get(kth).next = list.get(kth).next.next;

		return head;
	}

	private static ListNode input1() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
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
