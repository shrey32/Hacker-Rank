package com.hackerrank.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/RETO5/">RETO5 - EXPRIMIDOR Grado
 * 11</a>
 * 
 * @author Shrey
 *
 */
public class AJuicerImplementation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int b = scan.nextInt();
		int d = scan.nextInt();
		int[] oranges = new int[n];
		for (int i = 0; i < n; i++)
			oranges[i] = scan.nextInt();
		System.out.println(squeezerDegree(oranges, b, d, n));
		scan.close();
	}

	private static final int squeezerDegree(int[] oranges, int b, int d, int n) {
		if (n == 1 && oranges[0] < b)
			return 0;
		Arrays.sort(oranges);
		int count = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int curr = oranges[i];
			sum += curr;
			int j = i;
			while (j + 1 < n) {
				if (sum + oranges[j + 1] < d) {
					sum += oranges[j + 1];
					j++;
				} else {
					i = j != i ? --j : j;
					break;
				}
			}
			if (sum > d) {
				count++;
				sum = 0;
			}
		}
		return count;
	}

}
