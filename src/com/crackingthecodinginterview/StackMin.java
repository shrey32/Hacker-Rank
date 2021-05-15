package com.crackingthecodinginterview;

import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class StackMin {

	private Stack<int[]> stack = new Stack<>();

	public static void main(String[] args) {
		StackMin min = new StackMin();
		min.push(5);// 5 , min is 5
		System.out.println(min + ",min=>" + min.min());
		min.push(6);// 6,5, min is 5
		System.out.println(min + ",min=>" + min.min());
		min.push(3);// 3,6,5 min is 3
		System.out.println(min + ",min=>" + min.min());
		min.push(7);
		System.out.println(min + ",min=>" + min.min());
		System.out.println("pop=>" + min.pop()+",stack=>"+min + ",min=>" + min.min());
		System.out.println(min + ",min=>" + min.min());
		System.out.println("pop=>" + min.pop()+",stack=>"+min + ",min=>" + min.min());
		System.out.println(min + ",min=>" + min.min());
	}

	public int pop() {
		int[] temp = stack.pop();
		return temp[0];
	}

	public int min() {
		return stack.peek()[1];
	}

	public int peek() {
		return stack.peek()[0];
	}

	public void push(int val) {
		if (stack.isEmpty()) {
			stack.push(new int[] { val, val });
		} else {
			int min = val;
			if (min > stack.peek()[1]) {
				min = stack.peek()[1];
			}
			stack.push(new int[] { val, min });
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int[] ar : stack) {
			sb.append(ar[0]).append(",");
		}
		sb.append("]");
		return sb.toString();
	}

}
