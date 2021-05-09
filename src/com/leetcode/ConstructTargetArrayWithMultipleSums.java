package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author Shrey
 *
 */
public class ConstructTargetArrayWithMultipleSums {

	public static void main(String[] args) {
		System.out.println(isPossible(new int[] { 9, 3, 5 }));
	}

	public static boolean isPossible(int[] target) {
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		int sum = 0;
		for (int num : target) {
			sum += num;
			pq.add(num);
		}

		while (pq.peek() != 1) {
			int num = pq.poll();
			sum -= num;
			if (num <= sum || sum < 1)
				return false;
			num %= sum;
			sum += num;
			pq.add(num);
		}
		return true;
	}

}
