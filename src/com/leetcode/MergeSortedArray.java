package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3)));
	}

	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (i >= 0 || j >= 0) {
			if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}
		return nums1;
	}

}
