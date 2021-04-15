package com.hackerrank.crackingcodinginterview;

import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class SortStack {

	private Stack<Integer> stack;

	public SortStack() {
		stack = new Stack<>();
	}

	public void push(int item) {
		if (stack.isEmpty() || item < stack.peek()) {
			stack.push(item);
			return;
		}
		Stack<Integer> side = new Stack<>();
		while (!stack.isEmpty() && item > stack.peek()) {
			side.push(stack.pop());
		}
		stack.push(item);
		while (!side.isEmpty()) {
			stack.push(side.pop());
		}
	}

	public int pop() {
		return this.stack.pop();
	}

	public static void main(String[] args) {
		SortStack st = new SortStack();
		st.push(1);
		st.push(5);
		System.out.println(st.stack);
		st.push(6);
		System.out.println(st.stack);
		st.push(0);
		System.out.println(st.stack);
		st.push(4);
		System.out.println(st.stack);
	}

}
