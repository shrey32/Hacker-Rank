package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class NonDecreasingArray {

	public static void main(String[] args) {
		System.out.println(checkPossibility(new int[] { 4, 2, 3 }));
		System.out.println(checkPossibility(new int[] { 4, 2, 1 }));
		System.out.println(checkPossibility(new int[] { 3, 4, 2, 3 }));
	}

	/**
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean checkPossibility(int[] nums) {
		int count = 0;
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			if (nums[i + 1] < nums[i]) {
				if (i - 1 >= 0 && i + 2 < len && nums[i] > nums[i + 2] && nums[i - 1] > nums[i + 1])
					return false;
				count++;
			}
			if (count > 1)
				return false;
		}

		return true;
	}

}
