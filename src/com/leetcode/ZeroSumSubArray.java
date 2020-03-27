package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(zeroSumSubArray(new int[] { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 })));
		System.out.println(Arrays.toString(zeroSumSubArray(new int[] { 1, 2, -5, 1, 2, -1 })));
	}

	public static int[] zeroSumSubArray(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			int curr = a[i];
			if (!map.containsKey(sum)) {
				map.put(sum, i);
				sum += curr;
			} else {
				return Arrays.copyOfRange(a, map.get(sum), i);
			}
		}
		return null;
	}

}
