package com.leetcode;

import java.math.BigInteger;
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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		while (temp1 != null || temp2 != null) {
			if (temp1 != null) {
				sb1.append(l1.val);
				temp1 = temp1.next;
			}
			if (temp2 != null) {
				sb2.append(l2.val);
				temp2 = temp2.next;
			}
		}
		BigInteger b1 = new BigInteger(sb1.toString());
		BigInteger b2 = new BigInteger(sb2.toString());

		BigInteger b3 = b1.add(b2);

		
		ListNode head = null;
		BigInteger ten = new BigInteger("10");
		while (b3.compareTo(BigInteger.ZERO) == 1) {
			int num = b3.mod(ten).intValue();
			b3 = b3.divide(ten);
			if (head == null) {
				head = new ListNode(num);
			} else {
				ListNode newNode = new ListNode(num);
				ListNode temp = head;
				head = newNode;
				head.next = temp;
			}
		}
		return head;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

}
