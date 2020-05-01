package com.leetcode.monthchallenge.april;

import java.util.Stack;

/**
 * <b>Backspace String Compare</b>
 * <p>
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * </p>
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> S = "ab#c", T = "ad#c"
 * </p>
 * <p>
 * <b>Output:</b> true
 * </p>
 * <p>
 * <b>Explanation:</b> Both S and T become "ac".
 * </p>
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input:</b> S = "ab##", T = "c#d#"
 * </p>
 * <p>
 * <b>Output:</b> true
 * </p>
 * <p>
 * <b>Explanation:</b> Both S and T become "".
 * </p>
 * <b>Example 3:</b>
 * 
 * <p>
 * <b>Input:</b> S = "a##c", T = "#a#c"
 * </p>
 * <p>
 * <b>Output:</b> true
 * </p>
 * <p>
 * <b>Explanation:</b> Both S and T become "c".
 * </p>
 * <b>Example 4:</b>
 * 
 * <p>
 * <b>Input:</b> S = "a#c", T = "b"
 * </p>
 * <p>
 * <b>Output:</b> false
 * </p>
 * <p>
 * <b>Explanation:</b> S becomes "c" while T becomes "b".
 * </p>
 * <b>Note:</b>
 * 
 * <li>1 <= S.length <= 200</li>
 * <li>1 <= T.length <= 200</li>
 * <li>S and T only contain lowercase letters and '#' characters.</li> <b>Follow
 * up:</b>
 * 
 * <p>
 * Can you solve it in O(N) time and O(1) space?
 * </p>
 * 
 * @author Shrey
 *
 */
public class BackspaceStringCompare {

	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c", "ad#c"));// true
		System.out.println(backspaceCompare("ab##", "c#d#"));//
		System.out.println(backspaceCompare("a##c", "#a#c"));//
		System.out.println(backspaceCompare("a#c", "b"));// false
		System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));// false
	}

	public static boolean backspaceCompare(String s, String t) {
		if (s == null || t == null)
			return false;
		
		if (s.equals(t))
			return true;
		
		Stack<Character> stack1 = getStack(s);

		Stack<Character> stack2 = getStack(t);

		if (stack1.size() != stack2.size())
			return false;

		while (!stack1.isEmpty())
			if (stack1.pop() != stack2.pop())
				return false;

		return true;
	}

	private static Stack<Character> getStack(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if ('#' == curr && !stack.isEmpty())
				stack.pop();
			else if ('#' != curr)
				stack.push(curr);
		}
		return stack;
	}

}
