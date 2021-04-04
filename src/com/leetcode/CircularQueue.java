package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class CircularQueue {

	int[] arrayQueue = null;
	int front = 0;
	int rear = 0;
	boolean noEl;

	public CircularQueue(int k) {
		arrayQueue = new int[k];
		this.noEl = true;

	}

	public boolean enQueue(int value) {
		if (!this.isFull()) {
			this.noEl = false;
			arrayQueue[rear] = value;
			rear++;
			rear = rear % arrayQueue.length;
			return true;
		} else {
			return false;
		}
	}

	public boolean deQueue() {
		if (!this.isEmpty()) {
			front++;
			front = front % arrayQueue.length;
			if (front == rear) {
				this.noEl = true;
			}
			return true;

		} else {
			return false;
		}
	}

	public int front() {
		if (!this.isEmpty()) {
			return arrayQueue[front];
		} else {
			return -1;
		}

	}

	public int rear() {
		if (!this.isEmpty()) {
			if (rear == 0) {
				return arrayQueue[arrayQueue.length - 1];
			} else {
				return arrayQueue[rear - 1];
			}
		} else {
			return -1;
		}
	}

	public boolean isEmpty() {
		return this.noEl;
	}

	public boolean isFull() {
		return (rear == front) && !this.noEl;
	}

	public static void main(String[] args) {
		CircularQueue q = new CircularQueue(8);
		System.out.println(q.enQueue(3));
		System.out.println(q.enQueue(9));
		System.out.println(q.enQueue(5));
		System.out.println(q.enQueue(0));
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.isEmpty());
		System.out.println(q.isEmpty());
		System.out.println(q.rear());
		System.out.println(q.rear());
		System.out.println(q.deQueue());
	}

}
