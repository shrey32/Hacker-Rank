package com.leetcode;

import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()()())((()())())"));
	}

	public static int longestValidParentheses(String s) {
		int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
	}


}
