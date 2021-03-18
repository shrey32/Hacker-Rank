package com.leetcode;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Shrey
 *
 */
public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		List<ListNode> list = new ArrayList<>();
		ListNode temp = head;
		while (temp != null) {
			list.add(temp);
			temp = temp.next;
		}

		int k = list.size() - 1 - n;

		if (list.size() == 1) {
			return null;
		} else if (list.size() == n) {
			head = head.next;
			list.get(0).next = null;
		} else if (n == 1) {
			list.get(k).next = null;
		} else {
			list.get(k).next = list.get(k + 2);
		}
		return head;
	}

	private static class ListNode {
		private int val;
		ListNode next;
	}
}
