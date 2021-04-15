package com.hackerrank.crackingcodinginterview;

import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class QueueUsingTwoStacks {

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public QueueUsingTwoStacks() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void enqueue(int item) {
		stack1.push(item);
	}

	public int dequeue() {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		if (!stack2.isEmpty()) {
			int val = stack2.pop();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			return val;
		}
		throw new RuntimeException("EmptyQueueException");
	}

	public int peek() {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		if (!stack2.isEmpty()) {
			int val = stack2.peek();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			return val;
		}
		throw new RuntimeException("EmptyQueueException");
	}

	public static void main(String[] args) {
		QueueUsingTwoStacks q = new QueueUsingTwoStacks();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println("peek=>" + q.peek());//1
		System.out.println("dequeue=>" + q.dequeue());//1 [2,3,4]
		System.out.println("dequeue=>" + q.dequeue());//2 [3,4]
		System.out.println(q.stack1);
	}

}
