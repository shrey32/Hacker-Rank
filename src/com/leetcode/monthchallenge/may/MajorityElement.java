package com.leetcode.monthchallenge.may;

/**
 * <b>Majority Element</b>
 * 
 * <p>
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * </p>
 * 
 * <p>
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * </p>
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> [3,2,3]
 * </p>
 * <p>
 * <b>Output:</b> 3
 * </p>
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input:</b> [2,2,1,1,1,2,2]
 * </p>
 * <p>
 * <b>Output:</b> 2
 * </p>
 * 
 * @author Shrey
 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 2, 3 }));
	}

	public static int majorityElement(int[] nums) {
		int element = -1;
		int count = 0;
		for (int num : nums) {
			if (count == 0) {
				element = num;
			}
			count += element == num ? 1 : -1;
		}
		return element;
	}

}
