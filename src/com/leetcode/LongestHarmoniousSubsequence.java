package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

	public static void main(String[] args) {
		System.out.println(findLHS(new int[] { 1, 3, 2, 2, 2, 5, 3, 7 }));// 5
	}

	public static int findLHS(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int key : nums)
			map.put(key, map.getOrDefault(key, 0) + 1);
		int max = 0;
		for (int key : nums)
			if (map.containsKey(key + 1))
				max = Math.max(max, map.get(key) + map.get(key + 1));
		return max;
	}

}
