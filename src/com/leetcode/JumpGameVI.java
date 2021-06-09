package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author Shrey
 *
 */
public class JumpGameVI {

	public static void main(String[] args) {
		System.out.println(maxResult(new int[] { 1, -1, -2, 4, -7, 3 }, 2));//
	}

	public static int maxResult(int[] nums, int k) {
		if (nums.length == 0)
			return 0;
		Queue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		q.offer(new int[] { nums[0], 0 });
		int max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			while (!q.isEmpty() && q.peek()[1] < i - k)
				q.poll();
			int[] curr = q.peek();
			max = curr[0] + nums[i];
			q.offer(new int[] { max, i });
		}

		return max;
	}

}
