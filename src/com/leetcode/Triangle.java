package com.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class Triangle {

	public static void main(String[] args) {
		System.out.println(minimumTotal(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7),
				Arrays.asList(4, 1, 8, 3))));
	}

	public static int minimumTotal(List<List<Integer>> t) {
		if (t == null || t.size() == 0)
			return 0;
		int s = t.size();
		for (int i = s - 2; i >= 0; i--) {
			for (int j = 0; j < t.get(i).size(); j++) {
				int sum = Math.min(t.get(i).get(j) + t.get(i + 1).get(j), t.get(i).get(j) + t.get(i + 1).get(j + 1));
				t.get(i).set(j, sum);
			}
		}
		// System.out.println(Arrays.toString(dp));
		System.out.println(t);

		return t.get(0).get(0);
	}

}
