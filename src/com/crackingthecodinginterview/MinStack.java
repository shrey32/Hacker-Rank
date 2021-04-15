package com.crackingthecodinginterview;

import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class MinStack {

	private Stack<int[]> stack;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<>();
	}

	public void push(int item) {
		if (stack.isEmpty() || stack.peek()[1] > item) {
			stack.push(new int[] { item, item });
		} else {
			stack.push(new int[] { item, stack.peek()[1] });
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;
		stack.pop();
	}

	public int top() {
		return stack.peek()[0];
	}

	public int getMin() {
		return stack.peek()[1];
	}
}
