package com.spoj.basics;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/CPOD1/">CPOD1 - Closest pairs in 1D
 * V1</a>
 * 
 * @author Shrey
 *
 */
public class ClosestPairs {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int[] ar = new int[n];
			for (int i = 0; i < n; i++)
				ar[i] = scan.nextInt();
			System.out.println(closestPairs(ar, n));
		}
		scan.close();
	}

	private static final int closestPairs(int[] arr, int n) {
		Arrays.sort(arr);

		// Initialize difference as infinite
		int diff = Integer.MAX_VALUE;

		for (int i = 0; i < n - 1; i++)
			if (arr[i + 1] - arr[i] < diff)
				diff = arr[i + 1] - arr[i];

		return diff;
	}

}
