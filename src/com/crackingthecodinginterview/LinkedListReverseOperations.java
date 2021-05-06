package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class LinkedListReverseOperations {

	public static void main(String[] args) {
		print(reverse2(input1()));
		print(reverse2(input2()));
	}

	public static Node reverse2(Node head) {
		Node temp = head;
		List<Node> list = new ArrayList<>();
		List<List<Integer>> indices = new ArrayList<>();
		int start = 0;
		int end = 0;
		boolean open = false;
		while (temp != null) {
			list.add(temp);
			if (temp.data % 2 == 0) {
				if (!open) {
					start = list.size() - 1;
					open = true;
				} else if (open) {
					end = list.size() - 1;
					if (temp.next==null || (temp.next != null && temp.next.data % 2 != 0)) {
						indices.add(Arrays.asList(start, end));
						open = false;
					}
				}
			} else {
				open = false;
			}
			temp = temp.next;
		}

		// reverse
		for (List<Integer> index : indices) {
			rotate(index.get(0), index.get(1), list);
		}

		for (int i = 1; i < list.size(); i++) {
			list.get(i - 1).next = list.get(i);
		}
		list.get(list.size() - 1).next = null;
		return list.get(0);
	}

	public static void rotate(int start, int end, List<Node> list) {
		int mid = (start + end) / 2;
		for (int i = start, j = end; i <= mid; i++, j--) {
			Node temp1 = list.get(i);
			Node temp2 = list.get(j);
			list.remove(i);
			list.add(i, temp2);
			list.remove(j);
			list.add(j, temp1);
		}
	}

	public static Node reverse(Node head) {
		Node temp = head;
		Node prev = null;
		Stack<Node> st = new Stack<>();
		while (temp != null) {
			if (temp.data % 2 == 0) {
				// prev = prev == null ? temp : prev;
				while (temp != null && temp.data % 2 == 0) {
					st.push(temp);
					temp = temp.next;
				}
			} else {
				if (!st.isEmpty()) {
					Node tempNext = st.peek().next;
					if (prev == null)
						prev = st.pop();
					while (!st.isEmpty()) {
						prev.next = st.pop();
						prev = prev.next;
					}
					prev.next = tempNext;
					prev = tempNext;
					temp = tempNext.next;
				} else {
					prev = temp;
					temp = temp.next;
				}
			}
		}
		while (!st.isEmpty()) {
			prev.next = st.pop();
			prev = prev.next;
		}
		prev.next = null;
		return head;
	}

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data + "";
		}

	}

	private static void print(Node head) {
		StringBuilder sb = new StringBuilder();
		Node temp = head;
		while (temp != null) {
			sb.append(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("[" + sb + "]");
	}

	private static Node input1() {
		Node head = new Node(1);
		head.next = new Node(8);
		head.next.next = new Node(2);
		head.next.next.next = new Node(9);
		head.next.next.next.next = new Node(16);
		head.next.next.next.next.next = new Node(12);
		return head;
	}

	private static Node input2() {
		Node head = new Node(24);
		head.next = new Node(18);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next = new Node(9);
		head.next.next.next.next.next.next.next = new Node(12);
		head.next.next.next.next.next.next.next.next = new Node(6);
		return head;
	}

}
