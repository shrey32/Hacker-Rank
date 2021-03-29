package com.leetcode;

import java.util.PriorityQueue;

/**
 * 
 * @author Shrey
 *
 */
public class FindKthSmallestPairDistance {

	public static void main(String[] args) {
		System.out.println(smallestDistancePair(new int[] { 1, 3, 1 }, 1));
	}

	public static int smallestDistancePair(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				queue.add(Math.abs(nums[i] - nums[j]));
			}
		}
		System.out.println(queue);
		for (int i = 0; i < k - 1; i++)
			queue.poll();
		return queue.poll();
	}

}
