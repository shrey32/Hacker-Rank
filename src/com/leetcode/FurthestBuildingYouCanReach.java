package com.leetcode;

import java.util.PriorityQueue;

/**
 * 
 * @author Shrey
 *
 */
public class FurthestBuildingYouCanReach {

	public static void main(String[] args) {
		System.out.println(furthestBuilding(new int[] { 4, 2, 7, 6, 9, 14, 12 }, 5, 1));
	}

	public static int furthestBuilding(int[] heights, int bricks, int ladders) {

		int size = heights.length - 1;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < size; i++) {
			if (heights[i + 1] <= heights[i])
				continue; // move forward without using brick or ladder
			int diff = heights[i + 1] - heights[i];
			q.add(diff);
			if (q.size() > ladders) { // anytime running out of ladders we use bricks
				bricks -= q.peek();
				q.poll();
				if (bricks < 0)
					return i;
			}
		}
		return size;
	}

}
