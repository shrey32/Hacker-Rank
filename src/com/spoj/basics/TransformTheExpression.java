package com.spoj.basics;

import java.util.Stack;

/**
 * Transform the algebraic expression with brackets into RPN form (Reverse
 * Polish Notation)
 * 
 * @author Shrey
 *
 */
public class TransformTheExpression {

	public static void main(String[] args) {
		System.out.println(transform("(a+(b*c))"));// true
		System.out.println(transform("((a+b)*(z+x))"));// true
		System.out.println(transform("((a+t)*((b+(a+c))^(c+d)))"));// true
	}

	/**
	 * takes O(n) time
	 * 
	 * @param exp
	 * @return
	 */
	static String transform(String exp) {

		Stack<Character> opsStack = new Stack<>();
		StringBuilder transformed = new StringBuilder();
		String operators = "*+-^/";
		for (int i = 0; i < exp.length(); i++) {

			char curr = exp.charAt(i);

			if (curr == '(')
				continue;
			// when math operators comes put it in stack
			if (operators.indexOf(curr) >= 0) {
				opsStack.push(curr);
				continue;
			}

			// for all non math operators
			if (curr == ')' && !opsStack.isEmpty())
				transformed.append(opsStack.pop());
			else
				transformed.append(curr);
		}

		return transformed.toString();
	}

}
