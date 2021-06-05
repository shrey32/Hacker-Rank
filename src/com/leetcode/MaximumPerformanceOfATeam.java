package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * @author Shrey
 *
 */
public class MaximumPerformanceOfATeam {

	public static void main(String[] args) {
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 2));// 60
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 3));// 68
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 4));// 72
	}

	public static int maxPerformance(int n, int[] s, int[] e, int k) {
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++)
			arr[i] = new int[] { e[i], s[i] };
		Arrays.sort(arr, (a, b) -> b[0] - a[0]); // sort by eff in decreasing order
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]); // min heap to maintain low speed
		long max = 0L, sum = 0L;
		for (int i = 0; i < n; i++) {
			q.offer(arr[i]);
			sum += arr[i][1];
			if (q.size() > k)
				sum -= q.poll()[1];
			max = Math.max(max, sum * arr[i][0]);
		}
		int mod = (int) 1e9 + 7;
		return (int) (max % mod);
	}

}
