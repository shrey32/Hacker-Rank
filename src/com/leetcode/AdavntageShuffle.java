package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * @author Shrey
 *
 */
public class AdavntageShuffle {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(advantageCount(new int[] { 2, 7, 11, 15 }, new int[] { 1, 10, 4, 11 })));// [2,11,7,15]
		System.out.println(Arrays.toString(advantageCount(new int[] { 12, 24, 8, 32 }, new int[] { 13, 25, 32, 11 })));// [24,32,8,12]
	}

	public static int[] advantageCount(int[] a, int[] b) {
		int n = a.length;
		int[] result = new int[n];

		PriorityQueue<Entry> maxHeap = new PriorityQueue<>((e1, e2) -> (e2.val - e1.val));
		for (int i = 0; i < n; i++)
			maxHeap.offer(new Entry(i, b[i]));

		Arrays.sort(a);
		int low = 0;
		int high = n - 1;
		while (!maxHeap.isEmpty()) {
			Entry entry = maxHeap.poll();
			if (a[high] > entry.val) {
				result[entry.idx] = a[high];
				high--;
			} else {
				result[entry.idx] = a[low];
				low++;
			}
		}

		return result;
	}

	private static class Entry {
		int idx, val;

		public Entry(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}

		@Override
		public String toString() {
			return "[" + idx + "," + val + "]";
		}

	}

}
