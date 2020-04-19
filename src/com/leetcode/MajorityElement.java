package com.leetcode;

/**
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
