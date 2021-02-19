package com.leetcode;

import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class MinimumRemoveToMakeValidParentheses {

	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)\""));// lee(t(c)o)de
		System.out.println(minRemoveToMakeValid("a)b(c)d"));// ab(c)d
		System.out.println(minRemoveToMakeValid("))(("));
		System.out.println(minRemoveToMakeValid("(a(b(c)d)"));// a(b(c)d)
	}

	public static String minRemoveToMakeValid(String s) {
		Stack<String> stack = new Stack<>();
		Stack<Integer> indexes = new Stack<>();
		for (int i = s.length() - 1; i >= 0; i--) {
			String curr = s.charAt(i) + "";
			if (")".equals(curr)) {
				stack.push(curr);
				indexes.push(i);
			} else if (!stack.isEmpty() && "(".equals(curr) && ")".equals(stack.peek())) {
				stack.pop();
				indexes.pop();
			} else if ("(".equals(curr)) {
				stack.push(curr);
				indexes.push(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!indexes.isEmpty() && indexes.peek() == i) {
				indexes.pop();
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

}
