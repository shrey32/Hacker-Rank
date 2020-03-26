package com.leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptItself {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productOfArrayExceptItself(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(productOfArrayExceptItself(new int[] { 5, 6, 4, 8 })));// [192,160,240,120]
	}

	private static int[] productOfArrayExceptItself(int[] nums) {
		int n = nums.length;
		int[] prod = new int[n];
		int temp = 1;
		// left except i product
		for (int i = 0; i < n; i++) {
			prod[i] = temp;
			temp *= nums[i];
		}
		temp = 1;
		// right except i product
		for (int i = n - 1; i >= 0; i--) {
			prod[i] *= temp;
			temp *= nums[i];
		}

		return prod;
	}

}
