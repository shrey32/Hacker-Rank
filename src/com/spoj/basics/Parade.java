package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/FINAL1/">FINAL1 - Reto Nro 1
 * Desfile</a>
 * 
 * @author Shrey
 *
 */
public class Parade {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		int[] left = new int[c];
		int[] right = new int[c];
		long lSum = 0, rSum = 0;
		for (int i = 0; i < c; i++) {
			left[i] = scan.nextInt();
			right[i] = scan.nextInt();
			lSum += left[i];
			rSum += right[i];
		}
		System.out.println(beauty(left, right, c, Math.abs(lSum - rSum)));
		scan.close();
	}

	private static final long beauty(int[] left, int[] right, int c, long maxBeauty) {

		long column = -1;
		for (int i = 0; i < c; i++) {
			long l = right[i];
			long r = left[i];
			for (int j = 0; j < c; j++) {
				if (j == i)
					continue;
				l += left[j];
				r += right[j];
			}
			long diff = Math.abs(l - r);
			if (diff > maxBeauty) {
				column = i;
				maxBeauty = diff;
			}
		}

		return column + 1;
	}

}
