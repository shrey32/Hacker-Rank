package com.spoj.basics;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <a href="https://www.spoj.com/problems/BTCK/">BTCK - A problem of
 * Backtracking</a>
 * 
 * @author Shrey
 *
 */
public class AProblemOfBackTracking {

	private static final Set<String> permutations = new LinkedHashSet<>(16);

	static {
		permutation("", "0123456789", permutations);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int[] a = new int[10];
			for (int i = 0; i < 10; i++)
				a[i] = scan.nextInt();
			int k = scan.nextInt();

			System.out.println(solve(a, k));
		}
		scan.close();
	}

	private final static String solve(int[] a, int k) {

		int n = a.length;
		StringBuilder result = new StringBuilder();
		for (String s : permutations) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				String curr = String.valueOf(s.charAt(i));
				int aa = Integer.parseInt(curr);
				int nn = a[i];
				sum += (aa * nn);
				if (sum > k) {
					result.delete(0, result.length());
					break;
				}
				result.append(curr + " ");
			}
			if (sum <= k) {
				return result.toString();
			}
		}

		return "-1";
	}

	static void permutation(String prefix, String remaining, Set<String> set) {
		if (remaining.length() == 0) {
			set.add(prefix);
			return;
		}
		for (int i = 0; i < remaining.length(); i++) {
			permutation(prefix + remaining.charAt(i),
					remaining.substring(0, i) + remaining.substring(i + 1, remaining.length()), set);
		}
	}

}
