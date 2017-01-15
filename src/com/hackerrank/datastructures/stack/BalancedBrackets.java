package com.hackerrank.datastructures.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class BalancedBrackets {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		String s = "";
		for (int i = 0; i < t; i++) {
			s = br.readLine().trim();
			System.out.println(isBalanced(s)?"YES":"NO");
		}
		br.close();
	}

	public static boolean isBalanced(String s) {
		int len = s.length();
		if (len == 0 || s == null)
			return true;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
				stack.push(s.charAt(i));
			else if (s.charAt(i) == ')' && !stack.empty()
					&& stack.peek() == '(')
				stack.pop();
			else if (s.charAt(i) == ']' && !stack.empty()
					&& stack.peek() == '[')
				stack.pop();

			else if (s.charAt(i) == '}' && !stack.empty()
					&& stack.peek() == '{')
				stack.pop();
			else
				return false;

		}
		return stack.empty();
	}

}
