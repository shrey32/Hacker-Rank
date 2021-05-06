package com.crackingthecodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class ContiguousSequence {

	public static void main(String[] args) {
		System.out.println(contiguousSqeuence(new int[] { 2, -8, 3, -2, 4, -10 }));
	}

	public static int contiguousSqeuence(int[] a) {
		if (a == null || a.length == 0)
			return 0;
		int maxNum = a[0];
		int max = maxNum;

		for (int i = 1; i < a.length; i++) {
			max = Math.max(a[i], a[i] + max);
			if (max > maxNum)
				maxNum = max;
		}
		return maxNum;
	}

}
