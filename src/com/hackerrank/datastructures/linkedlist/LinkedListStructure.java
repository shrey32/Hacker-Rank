package com.hackerrank.datastructures.linkedlist;

public class LinkedListStructure {

	/**
	 * root node of linked list
	 */
	private Node root;

	/**
	 * appends node at the tail of the list
	 * 
	 * @param data
	 */
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

	/**
	 * prepend node at the head of the list
	 * 
	 * @param data
	 */
	public void insertAtHead(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}
		Node newHead = new Node(data);
		newHead.next = root;
		root = newHead;
	}

	/**
	 * checks if list is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * insert node at an specific position
	 * 
	 * @param data
	 * @param position
	 */
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

	/**
	 * delete node from position
	 * 
	 * @param position
	 */
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

	/**
	 * returns reversed list
	 * 
	 * @return
	 */
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

	/**
	 * compare two linked list
	 * 
	 * @param list
	 * @return
	 */
	public int compare(LinkedListStructure list) {
		return compare(root, list.root);
	}

	/**
	 * compare root nodes of two linked lists
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	private int compare(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return 1;
		else if (root1 == null || root2 == null)
			return 0;
		if (root1.data == root2.data) {
			return compare(root1.next, root2.next);
		} else {
			return 0;
		}
	}

	/**
	 * returns value from the tail
	 * 
	 * @param position
	 * @return
	 */
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

	public Node removeDuplicates(Node root) {
		if (root == null)
			return null;
		Node nextItem = root.next;
		while (nextItem != null && root.data == nextItem.data) {
			nextItem = nextItem.next;
		}
		root.next = removeDuplicates(nextItem);
		return root;
	}

	public boolean hasCycle(Node head) {
		if (head == null)
			return false;
		Node slow = head;
		Node fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null)
				return false;
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

	Node Reverse(Node head) {
		Node newHead = null;
		Node tmp = head;
		while (tmp != null) {
			if (newHead == null) {
				newHead = new Node();
				newHead.data = tmp.data;
			} else {
				Node reverse = new Node();
				reverse.data = tmp.data;
				reverse.next = newHead;
				newHead = reverse;
			}
			tmp = tmp.next;
		}
		return newHead;
	}

	/**
	 * represents node of linked list
	 * 
	 * @author shrey.sharma
	 *
	 */
	private static class Node {
		public int data;
		public Node next;

		public Node() {
		}

		public Node(int data) {
			this.data = data;
		}
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

	/**
	 * test cases
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListStructure l = new LinkedListStructure();
		l.insert(1);
		l.insert(1);
		l.insert(3);
		l.insert(3);
		l.insert(5);
		l.insert(6);
		System.out.println(l);
		// l.delete(2);
		System.out.println(l.reverse());
		// System.out.println(l.getValueFromTail(0));
		// System.out.println(l.compare(l));
		l.removeDuplicates(l.root);
	}

}
