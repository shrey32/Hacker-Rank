package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class TheNextPermutation {

	public static void main(String[] args) {
		nextPermutation(new int[] { 1, 2, 3 });
	}

	public static void nextPermutation(int[] nums) {
		int idx = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				idx = i;
				break;
			}
		}

		if (idx == -1) {
			Arrays.sort(nums);
			return;
		}

		int val1 = nums[idx];
		int j = idx + 1;
		int jm = nums[idx + 1];

		for (int i = idx + 1; i < nums.length; i++) {
			if (nums[i] > val1 && nums[i] <= jm) {
				jm = nums[i];
				j = i;
			}
		}

		swap(nums, idx, j);
		reverse(nums, idx + 1, nums.length - 1);

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void reverse(int[] arr, int i, int j) {
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
	}

}
