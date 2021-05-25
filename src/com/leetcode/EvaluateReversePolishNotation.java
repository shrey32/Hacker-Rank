package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		System.out
				.println(evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));// 22
	}

	public static int evalRPN(String[] tokens) {
		Stack<String> st = new Stack<>();
		Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
		for (String s : tokens) {
			if (operators.contains(s)) {
				String b = st.pop();
				String a = st.pop();
				int res = eval(a, b, s);
				st.push(String.valueOf(res));
			} else {
				st.push(s);
			}
		}
		return Integer.parseInt(st.pop());
	}

	public static int eval(String a, String b, String op) {
		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);
		switch (op) {
		case "+":
			return aa + bb;
		case "-":
			return aa - bb;
		case "*":
			return aa * bb;
		case "/":
			return aa / bb;
		default:
			return 0;
		}
	}

}
