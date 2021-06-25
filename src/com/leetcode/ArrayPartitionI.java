package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class ArrayPartitionI {

	public static void main(String[] args) {
		System.out.println(arrayPairSum(new int[] { 6, 2, 5, 6, 1, 2 }));
	}

	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2)
			sum += nums[i];
		return sum;
	}

}
