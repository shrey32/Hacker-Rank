package com.leetcode.monthchallenge.april;

import java.util.Stack;

/**
 * <b> Min Stack</b>
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * </p>
 * <p>
 * <li>push(x) -- Push element x onto stack.</li>
 * <li>pop() -- Removes the element on top of the stack.</li>
 * <li>top() -- Get the top element.</li>
 * <li>getMin() -- Retrieve the minimum element in the stack.</li>
 * </p>
 * 
 * <b>Example:</b>
 * 
 * <p>
 * MinStack minStack = new MinStack();<br>
 * minStack.push(-2);<br>
 * minStack.push(0);<br>
 * minStack.push(-3);<br>
 * minStack.getMin(); --> Returns -3.<br>
 * minStack.pop();<br>
 * minStack.top(); --> Returns 0.<br>
 * minStack.getMin(); --> Returns -2.<br>
 * </p>
 * 
 * @author Shrey
 *
 */
public class MinStack {

	private Stack<Integer> stack;
	private int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		System.out.println(obj.getMin());// -3
		obj.pop();// removes -3
		System.out.println(obj.top());// 0
		System.out.println(obj.getMin());// -2
	}

	public MinStack() {
		stack = new Stack<>();
	}

	public void push(int item) {
		min = Math.min(item, min);
		stack.push(item);
	}

	public void pop() {
		stack.pop();
		min = Integer.MAX_VALUE;
		findMin();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}

	private void findMin() {
		if (stack.isEmpty())
			return;
		int item = stack.pop();
		min = Math.min(item, min);
		findMin();
		stack.push(item);
	}
}
