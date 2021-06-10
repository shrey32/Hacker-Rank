package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class MyCalendarI {

	private Node head;

	public MyCalendarI() {
		Node tail = new Node(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE });
		head = new Node(new int[] { -1, -1 });
		head.next = tail;
	}

	public boolean book(int start, int end) {
		int[] e = new int[] { start, end };
		Node curr = head, last = head;
		while (curr.e[0] < start) {
			last = curr;
			curr = curr.next;
		}
		if (last.e[1] > start || curr.e[0] < end)
			return false;
		last.next = new Node(e);
		last.next.next = curr;
		return true;
	}

	private class Node {
		int[] e;
		Node next;

		public Node(int[] e) {
			this.e = e;
		}
	}

	public static void main(String[] args) {
		MyCalendarI cal = new MyCalendarI();
		System.out.println(cal.book(10, 20));//true
		System.out.println(cal.book(15, 25));//false
		System.out.println(cal.book(20, 30));//true
	}

}
