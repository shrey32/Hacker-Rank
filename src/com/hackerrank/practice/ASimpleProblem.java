package com.hackerrank.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/SIMPLPRBLM/">SIMPLPRBLM - A Simple
 * Problem</a>
 * 
 * @author Shrey
 *
 */
public class ASimpleProblem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int tn = 1;
		for (; tn <= t;) {
			int n = scan.nextInt();
			int sum = scan.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = scan.nextInt();
			System.out.println("Case " + tn + ": " + pairsCount(a, sum));
			tn++;
		}
		scan.close();
	}

	private static final int pairsCount(int[] a, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : a)
			map.put(i, map.getOrDefault(i, 0) + 1);

		int count = 0;
		for (int i : a) {

			if (map.containsKey(sum - i))
				count += map.get(sum - i);

			if (sum - i == i)
				count--;
		}
		return count / 2;
	}

}
