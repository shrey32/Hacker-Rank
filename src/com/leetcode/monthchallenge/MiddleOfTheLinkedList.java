package com.leetcode.monthchallenge;

/**
 * <b>Middle of the Linked List</b>
 * <p>
 * Given a non-empty, singly linked list with head node head, return a middle
 * node of linked list.
 * 
 * If there are two middle nodes, return the second middle node.
 * </p>
 * 
 * 
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> [1,2,3,4,5]
 * </p>
 * <p>
 * <b>Output:</b> Node 3 from this list (Serialization: [3,4,5]) The returned
 * node has value 3. (The judge's serialization of this node is [3,4,5]).
 * <b>Note</b> that we returned a ListNode object ans, such that: ans.val = 3,
 * ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * </p>
 * <b>Example 2:</b>
 * </p>
 * 
 * <p>
 * <b>Input:</b> [1,2,3,4,5,6]
 * </p>
 * <p>
 * <b>Output:</b> Node 4 from this list (Serialization: [4,5,6]) Since the list
 * has two middle nodes with values 3 and 4, we return the second one.
 * </p>
 * 
 * 
 * <b>Note:</b>
 * 
 * <li>The number of nodes in the given list will be between 1 and 100.</li>
 * 
 * @author Shrey
 *
 */
public class MiddleOfTheLinkedList {

	public static void main(String[] args) {
		System.out.println(middleNode(input1()));
		System.out.println(middleNode(input2()));
	}

	public static ListNode middleNode(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
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
				sb.append(temp.val).append(" ");
				temp = temp.next;
			}
			return sb.toString();
		}
	}

	private static ListNode input1() {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		return node;
	}

	private static ListNode input2() {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);
		return node;
	}

}
