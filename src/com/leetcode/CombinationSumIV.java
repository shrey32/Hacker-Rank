package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
public class CombinationSumIV {

	public static void main(String[] args) {
		CombinationSumIV c = new CombinationSumIV();
		System.out.println(c.combinationSum4(new int[] { 1, 2, 3 }, 4));
	}

	public int combinationSum4(int[] cand, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		helper(cand, target, map);
		return map.get(target);
	}

	public int helper(int[] cand, int target, Map<Integer, Integer> map) {

		if (map.containsKey(target))
			return map.get(target);

		if (target == 0)
			return 1;

		int count = 0;

		for (int i = 0; i < cand.length; i++) {
			if (cand[i] <= target)
				count += helper(cand, target - cand[i], map);
		}

		map.put(target, count);
		return count;
	}

}
