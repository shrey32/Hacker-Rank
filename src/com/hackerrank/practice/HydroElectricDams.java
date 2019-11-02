package com.hackerrank.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.spoj.com/problems/HYDRO/" ></a>
 * 
 * @author Shrey
 *
 */
public class HydroElectricDams {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] in = br.readLine().split(" ");
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = Integer.parseInt(in[i]);

			System.out.println(totalWater(a, n));
		}
		br.close();
	}

	static int totalWater(int[] a, int n) {

		int left[] = new int[n];

		// Right [i] contains height of tallest bar to
		// the right of ith bar including itself
		int right[] = new int[n];

		int water = 0;

		left[0] = a[0];
		for (int i = 1; i < n; i++)
			left[i] = Math.max(left[i - 1], a[i]);

		right[n - 1] = a[n - 1];

		for (int i = n - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], a[i]);

		for (int i = 0; i < n; i++)
			water += Math.min(left[i], right[i]) - a[i];

		return water;
	}

}
