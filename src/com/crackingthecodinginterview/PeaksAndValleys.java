package com.crackingthecodinginterview;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class PeaksAndValleys {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(peaksAndValleys(new int[] { 5, 8, 6, 2, 3, 4, 6 })));
		System.out.println(Arrays.toString(peaksAndValleys(new int[] { 5, 3, 1, 2, 3 })));
	}

	/**
	 * 5, 8, 6, 2, 3, 4, 6 2, 3, 4, 5, 6, 6, 8 divide in half 0-3 left 4-6 right
	 * (both inclusive)
	 * 
	 * 
	 * @param a
	 * @return
	 */
	public static int[] peaksAndValleys(int[] a) {
		Arrays.sort(a);
		// divide in half
		int[] res = new int[a.length];
		int hi = a.length - 1;
		int lo = 0;
		int i = 0;
		while (lo < hi) {
			res[i] = a[hi];
			hi--;
			i++;
			res[i] = a[lo];
			lo++;
			i++;
		}
		
		if(hi==lo) {
			res[i] = a[hi];
		}

		return res;
	}

}
