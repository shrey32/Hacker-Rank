package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
public class OnesAndZeroes {

	public static void main(String[] args) {
		System.out.println(findMaxForm(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3));
	}

	public static int findMaxForm(String[] strs, int m, int n) {
		Map<String, int[]> map = new HashMap<>();
		for (String s : strs)
			map.put(s, count(s));

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i < strs.length; i++) {
			String curr = strs[i];
			int zero = map.get(curr)[0];
			int one = map.get(curr)[1];
			for (int j = m; j >= zero; j--) {
				for (int k = n; k >= one; k--) {
					dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
				}
			}
		}
		return dp[m][n];
	}

	public static int[] count(String str) {
		int countZero = 0;
		int countOne = 0;
		for (char c : str.toCharArray()) {
			if (c == '1')
				countOne++;
			else
				countZero++;
		}
		return new int[] { countZero, countOne };
	}
}
