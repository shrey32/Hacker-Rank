package com.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class MinimumAbsoluteDifference {

	public List<List<Integer>> minimumAbsDifference(int[] a) {
		List<List<Integer>> res = new ArrayList<>();
		if (a == null || a.length <= 1)
			return res;

		Arrays.sort(a);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < a.length; i++) {
			int diff = Math.abs(a[i] - a[i - 1]);
			if (diff < min) {
				res.clear();
				min = diff;
				res.add(Arrays.asList(a[i - 1], a[i]));
			} else if (diff == min) {
				res.add(Arrays.asList(a[i - 1], a[i]));
			}
		}

		return res;
	}

}
