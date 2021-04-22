package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * 
 * @author Shrey
 *
 */
public class BrickWall {

	public static void main(String[] args) {
		System.out.println(leastBricks(Arrays.asList(Arrays.asList(1, 2, 2, 1), Arrays.asList(3, 1, 2),
				Arrays.asList(1, 3, 2), Arrays.asList(2, 4), Arrays.asList(3, 1, 2), Arrays.asList(1, 3, 1, 1))));
	}

	/**
	 * <p>
	 * idea is to maintain edge frequency in a hashmap and keep tracking the max
	 * edge frequency now subtract max edge freqency from total rows in wall to get
	 * the brick count
	 * </p>
	 * 
	 * @param wall
	 * @return
	 */
	private static int leastBricks(List<List<Integer>> wall) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int n = wall.size();
		for (int i = 0; i < n; i++) {
			int edge = 0;
			for (int j = 0; j < wall.get(i).size() - 1; j++) {// don't take the last edge
				edge += wall.get(i).get(j);
				map.put(edge, map.getOrDefault(edge, 0) + 1);
				max = Math.max(max, map.get(edge));
			}
		}
		return n - max;
	}

}
