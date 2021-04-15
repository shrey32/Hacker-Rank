package com.crackingthecodinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

 Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

 A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

 By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:

 It contains no unmatched brackets.
 The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, print YES on a new line; otherwise, print NO on a new line.

 Input Format

 The first line contains a single integer, , denoting the number of strings. 
 Each line  of the  subsequent lines consists of a single string, , denoting a sequence of brackets.

 Constraints

 , where  is the length of the sequence.
 Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]).
 Output Format

 For each string, print whether or not the string of brackets is balanced on a new line. If the brackets are balanced, print YES; otherwise, print NO.

 Sample Input

 3
 {[()]}
 {[(])}
 {{[[(())]]}}
 Sample Output

 YES
 NO
 YES
 Explanation

 The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
 The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) are not balanced. Thus, we print NO on a new line.
 The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
 */
/**
 * 
 * @author Shrey
 *
 */
public class StacksBalancedBrackets {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		String expression = "";
		for (int i = 0; i < t; i++) {
			expression = br.readLine().trim();
			boolean isBalanced = checkBalance(expression);
			System.out.println(isBalanced ? "YES" : "NO");
		}
		br.close();
	}

	private static boolean checkBalance(String expression) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : expression.toCharArray()) {
			if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (c == '(')
				stack.push(')');
			else {
				if (stack.isEmpty() || c != stack.peek())
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

}
