package com.leetcode.monthchallenge.april;

/**
 * <b>Jump Game</b>
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * </p>
 * 
 * <p>
 * Each element in the array represents your maximum jump length at that
 * position.
 * </p>
 * 
 * <p>
 * Determine if you are able to reach the last index.
 * </p>
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> [2,3,1,1,4]
 * </p>
 * <p>
 * <b>Output:</b> true
 * </p>
 * <p>
 * <b>Explanation:</b> Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * </p>
 * 
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input:</b> [3,2,1,0,4]
 * </p>
 * <p>
 * <b>Output:</b> false
 * </p>
 * <p>
 * <b>Explanation:</b> You will always arrive at index 3 no matter what. Its
 * maximum jump length is 0, which makes it impossible to reach the last index.
 * </p>
 * 
 * @author Shrey
 *
 */
public class JumpGame {

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));// true
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));// false
	}

	public static boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return true;
		int maxIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (maxIndex < i)
				return false;
			if (i + nums[i] >= nums.length - 1)
				return true;
			maxIndex = Math.max(maxIndex, i + nums[i]);
		}
		return maxIndex >= nums.length - 1;
	}

}
