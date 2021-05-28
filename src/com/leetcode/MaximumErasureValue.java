package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Shrey
 *
 */
public class MaximumErasureValue {

	public static void main(String[] args) {
		System.out.println(maximumUniqueSubarray(new int[] { 4, 2, 4, 5, 6 }));// 17
		System.out.println(maximumUniqueSubarray(new int[] { 5, 2, 1, 2, 5, 2, 1, 2, 5 }));// 8
	}

	/**
	 * 
	 * @param nums
	 * @return
	 */
	public static int maximumUniqueSubarray(int[] nums) {
		Set<Integer> seen = new HashSet<>();
		int max = 0;
		int l = 0, r = 0;
		int len = nums.length;
		int sum = 0;
		while (r < len) {
			while (seen.contains(nums[r])) {
				int temp = nums[l++];
				sum -= temp;
				seen.remove(temp);
			}
			int temp = nums[r++];
			seen.add(temp);
			sum += temp;
			max = Math.max(sum, max);
		}
		System.out.println();
		return max;
	}

}
