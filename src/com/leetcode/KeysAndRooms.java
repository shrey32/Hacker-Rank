package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Shrey
 *
 */
public class KeysAndRooms {

	public static void main(String[] args) {
		System.out.println(
				canVisitAllRooms(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())));// true
		System.out.println(canVisitAllRooms(
				Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList(0))));
		System.out.println(canVisitAllRooms(Arrays.asList(Arrays.asList(4), Arrays.asList(3), Arrays.asList(),
				Arrays.asList(2, 5, 7), Arrays.asList(1), Arrays.asList(), Arrays.asList(8, 9), Arrays.asList(),
				Arrays.asList(), Arrays.asList(6))));
	}

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		visited.add(0);
		while (!q.isEmpty()) {
			int len = q.size();
			while (len-- > 0) {
				int first = q.poll();
				for (Integer next : rooms.get(first)) {
					if (!visited.contains(next)) {
						visited.add(next);
						q.offer(next);
					}
				}
			}
		}
		return rooms.size() == visited.size();
	}
}
