package com.crackingthecodinginterview;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * @author Shrey
 *
 */
public class LargestTripleProducts {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findMaxProduct(new int[] { 1, 2, 3, 4, 5 })));
		System.out.println(Arrays.toString(findMaxProduct(new int[] { 2, 4, 7, 1, 5, 3 })));
	}

	public static int[] findMaxProduct(int[] arr) {
		// Write your code here
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int l = arr.length;
		int[] res = new int[l];
		res[0] = -1;
		res[1] = -1;
		int prod = arr[0] * arr[1];
		q.offer(arr[0]);
		q.offer(arr[1]);
		for (int i = 2; i < l; i++) {
			if (q.size() < 3) {
				q.offer(arr[i]);
				prod = prod * arr[i];
				if (q.size() == 3) {
					res[i] = prod;
				}
			} else if (q.size() >= 3 && arr[i] <= q.peek()) {
				res[i] = prod;
			} else if (q.size() >= 3 && arr[i] > q.peek()) {
				int temp = q.poll();
				prod = prod / temp;
				prod = prod * arr[i];
				q.offer(arr[i]);
				res[i] = prod;
			}
		}
		return res;
	}

}
