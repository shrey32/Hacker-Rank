package com.crackingthecodinginterview;

/**
 * <p>
 * Given a circular linked list, implement an algorithm that returns the node at
 * the beginning of the loop. DEFINITION Circular linked list: A (corrupt)
 * linked list in which a node's next pointer points to an earlier node, so as
 * to make a loop in the linked list.
 * </p>
 * <p>
 * EXAMPLE Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * </p>
 * <p>
 * Output: C
 * </p>
 * 
 * 
 * @author Shrey
 *
 */
public class LoopDetection {

	public static void main(String[] args) {
		System.out.println(hasCycle(input1()));// true
		System.out.println(hasCycle(input2()));// false
	}

	private static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != null && fast != null && fast.next != null) {
			if (slow == fast)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

	private static ListNode input1() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode forCycle = head.next.next;
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = forCycle;
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
