package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class MissingNumber {

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] { 3, 0, 1 }));// 2
		System.out.println(missingNumber(new int[] { 0, 1 }));// 2
		System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));// 8
		System.out.println(missingNumber(new int[] { 0 }));// 1
	}

	/**
	 * 
	 * @param nums
	 * @return
	 */
	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int total = n * (n + 1) / 2;
		int sum = 0;
		for (int i : nums)
			sum += i;
		return total - sum;
	}

}
