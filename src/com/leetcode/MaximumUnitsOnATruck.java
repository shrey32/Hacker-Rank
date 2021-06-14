package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class MaximumUnitsOnATruck {

	public static void main(String[] args) {
		System.out.println(maximumUnits(new int[][] { { 1, 3 }, { 2, 2 }, { 3, 1 } }, 4));// 8
		System.out.println(maximumUnits(new int[][] { { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } }, 10));// 91
	}

	public static int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
		int max = 0;
		int loadedSoFar = 0;
		for (int[] bx : boxTypes) {
			int diff = (bx[0] + loadedSoFar <= truckSize) ? bx[0] : (truckSize - loadedSoFar);
			loadedSoFar += diff;
			max += (diff * bx[1]);
		}
		return max;
	}

}
