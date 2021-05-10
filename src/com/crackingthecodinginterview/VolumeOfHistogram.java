package com.crackingthecodinginterview;

import java.util.PriorityQueue;

/**
 * 
 * <p>
 * : Imagine a histogram (bar graph). Design an algorithm to compute the volume
 * of water it could hold if someone poured water across the top. You can assume
 * that each histogram bar has width 1. EXAMPLE (Black bars are the histogram.
 * Gray is water.) lnput:{0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0}
 * </p>
 * 
 * @author Shrey
 *
 */
public class VolumeOfHistogram {

	public static void main(String[] args) {
		System.out.println(totalVolume(new int[] { 0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0 }));
	}

	public static int totalVolume(int[] ar) {

		int l = ar.length;
		int[] leftMax = new int[l];
		int[] rightMax = new int[l];

		for (int i = 1; i < l; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], ar[i - 1]);
		}

		for (int i = l - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], ar[i + 1]);
		}

		int total = 0;
		for (int i = 0; i < l; i++) {
			total += Math.max(0, Math.min(leftMax[i], rightMax[i]) - ar[i]);
		}
		return total;
	}

	public static int maxVolumeOfHistogram(int[] a) {
		int max = 0;
		int lo = 0;
		int hi = a.length - 1;
		while (lo < hi) {

			int vol = Math.min(a[lo], a[hi]) * (hi - lo);
			max = Math.max(max, vol);
			if (a[lo] == a[hi]) {
				lo++;
				hi--;
			} else if (a[lo] > a[hi]) {
				hi--;
			} else {
				lo++;
			}
		}
		return max;
	}

}
