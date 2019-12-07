package com.spoj.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * <a href="https://www.spoj.com/problems/RPNEVAL/">RPNEVAL - Evaluate simple
 * RPN expression</a>
 * 
 * @author Shrey
 *
 */
public class EvaluateTheRPNExpression {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] exp = br.readLine().trim().split(" ");
		System.out.println(evaluate(exp));
		br.close();
	}

	final static String evaluate(String[] exp) {
		String ops = "*/-+";
		if (!validation(exp, ops))
			return "ERROR";

		Stack<Double> operands = new Stack<>();
		for (int i = 0; i < exp.length; i++) {

			String op = exp[i];

			if (isOperator(op)) {
				double a = operands.pop();
				double b = operands.pop();
				operands.push(math(a, b, op));
			} else {
				Double d = new Double(Integer.parseInt(op));
				operands.push(d);
			}

		}
		return String.valueOf(operands.pop().floatValue());
	}

	private static Double math(double a, double b, String op) {

		double d = 0.0;
		if ("+".equals(op)) {
			d = a + b;
		} else if ("-".equals(op)) {
			d = b - a;
		} else if ("*".equals(op)) {
			d = a * b;
		} else if ("/".equals(op)) {
			d = b / a;
		}
		return d;
	}

	public static boolean isOperator(String s) {
		if (s.length() != 1) {
			return false;
		}
		char c = s.charAt(0);
		return c == '+' || c == '-' || c == '/' || c == '*';
	}

	/**
	 * 
	 * @param exp
	 * @param ops
	 * @return
	 */
	final static boolean validation(String[] exp, String ops) {
		int operatorCount = 0, operandCount = 0;
		for (int i = 0; i < exp.length; i++) {
			String curr = exp[i];
			if (ops.indexOf(curr) >= 0)
				operatorCount++;
			else
				operandCount++;
		}
		return ((operandCount - operatorCount) == 1) ? true : false;
	}

}
