package com.leetcode;

import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class RemoveAllAdjacentDuplicatesInStringII {

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abcd", 2));// abcd
		System.out.println(removeDuplicates("deeedbbcccbdaa", 3));// aa
	}

	public static String removeDuplicates(String s, int k) {
		Stack<Item> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (stack.isEmpty() || curr != stack.peek().c) {
				stack.push(new Item(curr, 1));
			} else if (!stack.isEmpty() && curr == stack.peek().c) {
				stack.peek().count++;
			}

			if (!stack.isEmpty() && stack.peek().count == k)
				stack.pop();
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			Item item = stack.pop();
			for (int i = 0; i < item.count; i++)
				sb.append(Character.toString(item.c));
		}
		return sb.reverse().toString();
	}

	private static class Item {
		char c;
		int count;

		public Item(char c, int count) {
			this.c = c;
			this.count = count;
		}
	}

}
