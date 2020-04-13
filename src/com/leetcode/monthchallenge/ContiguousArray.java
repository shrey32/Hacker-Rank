package com.leetcode.monthchallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>Contiguous Array</b>
 * <p>
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 * </p>
 * 
 * <b>Example 1:</b>
 * <p>
 * <b>Input:</b> [0,1]
 * </p>
 * <p>
 * <b>Output:</b> 2
 * </p>
 * <p>
 * <b>Explanation:</b> [0, 1] is the longest contiguous subarray with equal
 * number of 0 and 1.
 * </p>
 * <b>Example 2:</b>
 * <p>
 * <b>Input:</b> [0,1,0]
 * </p>
 * <p>
 * <b>Output:</b> 2
 * </p>
 * <p>
 * <b>Explanation:</b> [0, 1] (or [1, 0]) is a longest contiguous subarray with
 * equal number of 0 and 1.
 * </p>
 * <p>
 * <b>Note:</b> The length of the given binary array will not exceed 50,000.
 * </p>
 * 
 * @author Shrey
 *
 */
public class ContiguousArray {

	public static void main(String[] args) {
		System.out.println(findMaxLength(new int[] { 0, 1 }));// 2
		System.out.println(findMaxLength(new int[] { 0, 1, 0 }));// 2
		System.out.println(findMaxLength(new int[] { 0, 1, 1 }));// 2
		System.out.println(findMaxLength(new int[] { 1, 0, 1, 1, 1, 0, 0 }));// 6
		System.out.println(findMaxLength(new int[] { 1, 1, 1, 1 }));// 0
		System.out.println(findMaxLength(new int[] { 0, 0, 1, 1, 0 }));// 4
		System.out.println(findMaxLength(new int[] { 0, 0, 0, 1, 1, 1, 0 }));// 6
		System.out.println(findMaxLength(new int[] { 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }));// 12
	}

	public static int findMaxLength(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int[] dp = new int[nums.length];

		for (int i = 0; i < dp.length; i++)
			dp[i] = nums[i] == 0 ? -1 : 1;

		if (Arrays.stream(dp).sum() == 0)
			return dp.length;

		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, max = 0;
		for (int i = 0; i < dp.length; i++) {
			sum += dp[i];

			if (sum == 0)
				max = i + 1;

			if (map.containsKey(sum)) {
				if (max < i - map.get(sum))
					max = i - map.get(sum);
			} else
				map.put(sum, i);
		}

		return max;
	}

}
