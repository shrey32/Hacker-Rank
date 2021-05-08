package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.List;

class BiNode {
	public BiNode left, right;
	public int data;

	public BiNode(int data) {
		this.data = data;
	}
}

/**
 * 
 * @author Shrey
 *
 */
public class BSTToDoublyLinkedList {

	public static void main(String[] args) {
		BiNode head = bstToDoublyLinkedList(input1());
		BiNode temp = head;
		BiNode prev = null;
		while (temp != null) {
			System.out.print(temp.data + " ");
			prev = temp;
			temp = temp.right;
		}
		System.out.println();
		temp = prev;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.left;
		}

	}

	public static BiNode bstToDoublyLinkedList(BiNode root) {
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		BiNode head = null;
		BiNode temp = null;
		BiNode prev = null;
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				head = new BiNode(list.get(0));
				temp = head;
				prev = null;
			} else {
				temp.right = new BiNode(list.get(i));
				temp.left = prev;
				prev = temp;
				temp = temp.right;
			}
		}
		if (temp != null)
			temp.left = prev;
		return head;
	}

	public static void inorder(BiNode root, List<Integer> list) {
		if (root == null)
			return;
		inorder(root.left, list);
		list.add(root.data);
		inorder(root.right, list);
	}

	public static BiNode input1() {
		BiNode root = new BiNode(8);
		root.left = new BiNode(5);
		root.right = new BiNode(10);
		root.left.left = new BiNode(4);
		root.left.right = new BiNode(6);
		root.right.left = new BiNode(9);
		root.right.right = new BiNode(11);
		return root;
	}

}
