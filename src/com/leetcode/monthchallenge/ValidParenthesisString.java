package com.leetcode.monthchallenge;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <b>Valid Parenthesis String</b>
 * <p>
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the
 * validity of a string by these rules:
 * </p>
 * <li>Any left parenthesis '(' must have a corresponding right parenthesis
 * ')'.</li>
 * <li>Any right parenthesis ')' must have a corresponding left parenthesis
 * '('.</li>
 * <li>Left parenthesis '(' must go before the corresponding right parenthesis
 * ')'.</li>
 * <li>'*' could be treated as a single right parenthesis ')' or a single left
 * parenthesis '(' or an empty string.</li>
 * <li>An empty string is also valid.</li> <b>Example 1:</b>
 * <p>
 * <b>Input:</b> "()"
 * </p>
 * <p>
 * <b>Output:</b> True
 * </p>
 * <b>Example 2:</b>
 * <p>
 * <b>Input:</b> "(*)"
 * </p>
 * <p>
 * <b>Output:</b> True
 * </p>
 * <b>Example 3:</b>
 * <p>
 * <b>Input:</b> "(*))"
 * </p>
 * <p>
 * <b>Output:</b> True
 * </p>
 * <b>Note:</b>
 * <li>The string size will be in the range [1, 100].</li>
 * 
 * @author Shrey
 *
 */
public class ValidParenthesisString {

	public static void main(String[] args) {
		System.out.println(checkValidString("()"));
		System.out.println(checkValidString("(*)"));
		System.out.println(checkValidString("(*()"));
		System.out.println(checkValidString("(*)))"));
		System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
	}

	public static boolean checkValidString(String s) {
		if (s == null || s.length() == 0)
			return true;
		Deque<Character> stack = new LinkedList<>();
		Deque<Integer> starCountStack = new LinkedList<>();
		int starCount = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				starCountStack.push(starCount);
				stack.push(c);
				starCount = 0;
			} else if (c == '*') {
				starCount++;
			} else {
				if (stack.isEmpty()) {
					if (starCount > 0)
						starCount--;
					else
						return false;
				} else {
					stack.pop();
					starCount += ((!starCountStack.isEmpty()) ? starCountStack.pop() : 0);
				}
			}
		}
		while (!stack.isEmpty()) {
			starCount--;
			if (starCount < 0)
				return false;
			stack.pop();
			starCount += starCountStack.pop();
		}
		return true;
	}

}
