package com.hackerrank.datastructures.linkedlist;

public class LinkedListStructure {

	private Node root;

	public static void main(String[] args) {
		LinkedListStructure l = new LinkedListStructure();
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(4, 2);
		System.out.println(l);
		// l.delete(2);
		System.out.println(l.reverse());
		System.out.println(l.getValueFromTail(0));
	}

	private static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}
		Node currentNode = root;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = new Node(data);
	}

	public void insertAtHead(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}
		Node newHead = new Node(data);
		newHead.next = root;
		root = newHead;
	}

	public void insert(int data, int position) {
		if (root == null) {
			root = new Node(data);
			return;
		}
		if (position == 0) {
			Node nth = new Node(data);
			nth.next = root;
			root = nth;
			return;
		}
		int index = 1;
		Node tempNode = root;
		while (tempNode.next != null) {
			if (index == position) {
				Node nth = new Node(data);
				nth.next = tempNode.next;
				tempNode.next = nth;
				return;
			}
			tempNode = tempNode.next;
			index++;
		}
	}

	public void delete(int position) {
		if (position == 0) {
			root = root.next;
			return;
		}
		int index = 1;
		Node tempNode = root;
		while (tempNode.next != null) {
			if (index == position) {
				tempNode.next = tempNode.next.next;
				break;
			}
			tempNode = tempNode.next;
			index++;
		}
	}

	public LinkedListStructure reverse() {
		LinkedListStructure list = new LinkedListStructure();
		Node newRoot = null;
		Node temp = root;
		while (temp != null) {
			if (newRoot == null) {
				newRoot = new Node(temp.data);
			} else {
				Node reverse = new Node(temp.data);
				reverse.next = newRoot;
				newRoot = reverse;
			}
			temp = temp.next;
		}
		list.root = newRoot;
		return list;
	}

	public int compare(LinkedListStructure list) {
		Node temp = root;
		Node otherTemp = list.root;
		if (temp == null || otherTemp == null)
			return 0;
		while (temp != null && otherTemp != null) {
			if (temp.data != otherTemp.data)
				return 0;
			temp = temp.next;
			otherTemp = otherTemp.next;
		}
		return 1;
	}

	public int getValueFromTail(int position) {
		int index = 0;
		Node current = root;
		Node result = root;
		while (current != null) {
			current = current.next;
			if (index++ > position) {
				result = result.next;
			}
		}
		return result.data;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node tempNode = root;
		while (tempNode != null) {
			sb.append(tempNode.data);
			tempNode = tempNode.next;
			if (tempNode != null)
				sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

}
