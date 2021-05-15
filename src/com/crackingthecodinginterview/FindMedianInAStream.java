package com.crackingthecodinginterview;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianInAStream {

	private void addNum(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, final int num) {
		if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}

		// either both the heaps will have equal number of elements or max-heap will
		// have one
		// more element than the min-heap
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		} else if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	private int findMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		if (maxHeap.size() == minHeap.size()) {
			// we have even number of elements, take the average of middle two elements
			return (maxHeap.peek() + minHeap.peek()) / 2;
		}
		// because max-heap will have one more element than the min-heap
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		FindMedianInAStream fmis = new FindMedianInAStream();
		System.out.println(Arrays.toString(fmis.findMedian(new int[] { 5, 15, 1, 3 })));
		System.out.println(Arrays.toString(fmis.findMedian(new int[] { 2, 4, 7, 1, 5, 3 })));
	}

	public int[] findMedian(int[] arr) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		// Write your code here
		int len = arr.length;
		int[] res = new int[len];
		for (int i = 0; i < len; i++) {
			addNum(maxHeap, minHeap, arr[i]);
			res[i] = findMedian(maxHeap, minHeap);
		}
		return res;
	}

}
