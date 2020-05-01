package com.leetcode.monthchallenge.april;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Subarray Sum Equals K</b>
 * <p>
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * </p>
 * 
 * <b>Example 1:</b>
 * <p>
 * <b>Input:</b> nums = [1,1,1], k = 2
 * </p>
 * <p>
 * <b>Output:</b> 2
 * </p>
 * <p>
 * <b>Note:</b>
 * </p>
 * <li>The length of the array is in range [1, 20,000].</li>
 * <li>The range of numbers in the array is [-1000, 1000] and the range of the
 * integer k is [-1e7, 1e7].</li>
 * 
 * @author Shrey
 *
 */
public class SubArraySumEqualsK {

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
		System.out.println(subarraySum(new int[] { 1, 2, 3, 7, 5 }, 12));
		System.out.println(subarraySum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 15));
	}

	public static int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;

		int sum = 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0,1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

}
