package com.leetcode;

import java.util.PriorityQueue;

/**
 * 
 * @author Shrey
 *
 */
public class MinimumNumberOfRefuelingStops {

	public static void main(String[] args) {
		System.out.println(minRefuelStops(100, 10, new int[][] { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } }));// 2
	}

	public static int minRefuelStops(int target, int startFuel, int[][] stations) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		int station = 0;
		int curr = startFuel;
		for (int[] st : stations) {
			int nextStation = st[0];
			int fuel = st[1];
			while (curr < nextStation) {
				if (maxHeap.isEmpty())
					return -1;
				curr += maxHeap.poll();
				station++;
			}
			maxHeap.offer(fuel);
		}
		while (curr < target) {
			if (maxHeap.isEmpty())
				return -1;
			curr += maxHeap.poll();
			station++;
		}
		return station;
	}

}
