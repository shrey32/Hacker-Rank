package com.geekforgeeks.google;

import java.util.Scanner;
import java.util.Stack;

/**
 * <a href=
 * "https://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0">Longest
 * Valid Parenthesis</a>
 * 
 * @author Shrey
 *
 */
public class ValidLongestParenthesis {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			String input = scan.next();
			System.out.println(longestValidParenthesis(input));
		}
		scan.close();
	}

	private static final long longestValidParenthesis(String input) {
		Stack<Integer> stack = new Stack<>();
		int count = 0, max = 0;
		for (int i = 0; i < input.length(); i++) {
			char curr = input.charAt(i);
			if ('(' == curr) {
				stack.push(count);
				count = 0;
			} else if (!stack.isEmpty() && ')' == curr) {
				count += stack.pop() + 2;
				max = Math.max(max, count);
			} else if (stack.isEmpty() && ')' == curr) {
				count = 0;
			}

		}
		return max;
	}

}
