package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class SwappingNodesInALinkedList {

	public static void main(String[] args) {

	}

	public ListNode swapNodes(ListNode head, int k) {
		if (head == null)
			return null;
		List<ListNode> nodes = new ArrayList<>();
		ListNode temp = head;
		while (temp != null) {
			nodes.add(temp);
			temp = temp.next;
		}
		ListNode node1 = nodes.get(k - 1);
		ListNode node2 = nodes.get(nodes.size() - k);
		int tempVal = node1.val;
		node1.val = node2.val;
		node2.val = tempVal;

		return head;
	}

	private static class ListNode {
		int val;
		ListNode next;
	}

}
