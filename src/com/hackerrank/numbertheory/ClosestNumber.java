package com.hackerrank.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Shrey
 *
 */
public class ClosestNumber {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			String line = br.readLine();
			int a = Integer.parseInt(line.split(" ")[0]);
			int b = Integer.parseInt(line.split(" ")[1]);
			int x = Integer.parseInt(line.split(" ")[2]);
			closestNumber(a, b, x);
			T--;
		}
		br.close();
	}

	private static void closestNumber(int a, int b, int x) {
		long num = (long) Math.pow(a, b);
		long n = num % x;
		if (n > x / 2) {
			System.out.println(num - n + x);
		} else if (n <= x / 2) {
			System.out.println(num - n);
		}
	}
}