package com.hackerrank.datastructures.heap;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/qheap1/problem">QHEAP1</a>
 * 
 * @author Shrey
 *
 */
public class QHeap {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Heap heap = new Heap(100000);
		while (n-- > 0) {
			int identifier = scan.nextInt();
			int v = -1;
			if (identifier != 3)
				v = scan.nextInt();
			if (identifier == 1) {
				heap.add(v);
			} else if (identifier == 2) {
				heap.delete(v);
			} else {
				System.out.println(heap.min());
			}
		}
		scan.close();
	}

	private static class Heap {

		private int[] heap;
		private int size = 0;

		public Heap(int n) {
			this.heap = new int[n];
			Arrays.fill(heap, -1);
		}

		public int min() {
			return this.heap[0];
		}

		public void add(int v) {
			this.heap[size++] = v;
			heapifyUp();
		}

		public void delete(int v) {
			for (int i = 0; i < size; i++) {
				if (heap[i] == v) {
					this.heap[i] = this.heap[size - 1];
					heap[size - 1] = Integer.MAX_VALUE;
					size--;
					sinking(i, size);
					break;
				}
			}
		}

		private void sinking(int index, int max) {
			while (2 * index < max) {
				int smallestChild = getSmallestIndex(index, max);
				if (this.heap[smallestChild] < this.heap[index]) {
					int temp = this.heap[smallestChild];
					this.heap[smallestChild] = this.heap[index];
					this.heap[index] = temp;
					index = smallestChild;
				} else {
					break;
				}
			}
		}

		private int getSmallestIndex(int index, int max) {
			// happens 2*index is the last element of the array
			if (2 * index == max - 1 || this.heap[2 * index] < this.heap[2 * index + 1]) {
				return 2 * index;
			} else {
				return 2 * index + 1;
			}
		}

		private void heapifyUp() {
			int index = this.size - 1;
			int item = this.heap[index];
			int parentIndex = this.parent(index);
			while (item < this.heap[parentIndex]) {
				int temp = this.heap[parentIndex];
				this.heap[parentIndex] = item;
				this.heap[index] = temp;
				index = parentIndex;
				parentIndex = this.parent(index);
			}
		}

		private int parent(int index) {
			if (index < 0 || index >= heap.length)
				throw new RuntimeException("invalid index");
			return (index - 1) / 2;
		}
	}

}
