package com.hackerrank.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * <a href=
 * "https://www.hackerrank.com/challenges/simple-text-editor/problem">Simple
 * Text Editor</a>
 * 
 * @author Shrey
 *
 */
public class SimpleTextEditor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder s = new StringBuilder();
		Stack<String> st = new Stack<String>();
		st.push(s.toString());
		for (int i = 0; i < n; i++) {
			int t = in.nextInt();
			if (t == 1) {
				s.append(in.next());
				st.push(s.toString());
			} else if (t == 2) {
				s = new StringBuilder(s.substring(0, s.length() - in.nextInt()));
				st.push(s.toString());
			} else if (t == 3) {
				System.out.println(s.charAt(in.nextInt() - 1));
			} else {
				st.pop();
				s = new StringBuilder(st.peek());
			}
		}
		in.close();
	}
}
