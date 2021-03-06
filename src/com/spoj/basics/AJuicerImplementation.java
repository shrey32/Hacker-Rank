package com.spoj.basics;

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
		int count = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int curr = oranges[i];
			sum += curr;
			if (sum > d) {
				count++;
				sum = 0;
			}
		}
		return count;
	}

}
