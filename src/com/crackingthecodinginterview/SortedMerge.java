package com.crackingthecodinginterview;

import java.util.Arrays;

/**
 * Merge Sorted Array
 * 
 * @author Shrey
 *
 */
public class SortedMerge {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = new int[] { 2, 5, 6 };
		merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
		nums1 = new int[] { 1 };
		nums2 = new int[] {};
		merge(nums1, 1, nums2, 0);
		System.out.println(Arrays.toString(nums1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int i = m - 1, j = n - 1, k = nums1.length - 1;

		while (i >= 0 && j >= 0) {
			if (k >= 0 && nums1[i] < nums2[j]) {
				nums1[k--] = nums2[j--];
			} else {
				nums1[k--] = nums1[i--];
			}
		}
	}

}
