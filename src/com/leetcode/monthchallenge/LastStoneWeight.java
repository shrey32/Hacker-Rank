package com.leetcode.monthchallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author Shrey
 *
 */
public class LastStoneWeight {

	public static void main(String[] args) {
		System.out.println(lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
		System.out.println(lastStoneWeight(new int[] { 6, 6, 4, 9, 4, 6, 3 }));
	}

	public static int lastStoneWeight(int[] stones) {

		if (stones == null || stones.length == 0)
			return 0;

		Comparator<Integer> comp = (a, b) -> b - a;
		PriorityQueue<Integer> queue = new PriorityQueue<>(comp);

		for (int stone : stones)
			queue.offer(stone);

		while (queue.size() > 1) {
			int max1 = queue.poll();
			int max2 = queue.poll();
			if (max1 != max2) {
				queue.offer(max1 - max2);
			}
		}

		return queue.isEmpty() ? 0 : queue.poll();
	}
}
