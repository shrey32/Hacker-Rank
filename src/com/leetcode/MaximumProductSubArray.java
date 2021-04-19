package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class MaximumProductSubArray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -4, 1}));//6
	}

	public static int maxProduct(int[] nums) {
		int maxp = nums[0];
		int maxn = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int curr = nums[i];
			if (curr < 0) {
				int temp1 = maxp;
				int temp2 = maxn;
				maxn = Math.min(curr, curr * temp1);
				maxp = Math.max(curr, curr * temp2);
			} else {
				maxp = Math.max(curr, curr * maxp);
				maxn = Math.min(curr, curr * maxn);
			}
			max = Math.max(maxp, max);
		}
		// System.out.println(Arrays.toString(nums));
		return max;
	}

}
