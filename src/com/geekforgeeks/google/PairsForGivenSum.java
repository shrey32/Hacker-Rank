package com.geekforgeeks.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href=
 * "https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x/0">Find
 * all pairs with a given sum</a>
 * 
 * @author Shrey
 *
 */
public class PairsForGivenSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int s = scan.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = scan.nextInt();
			Arrays.parallelSort(a);
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < m; i++)
				set.add(scan.nextInt());
			List<String> result = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int diff = s - a[i];
				if (set.contains(diff))
					result.add(a[i] + " " + diff);
			}
			System.out.println(result.stream().collect(Collectors.joining(", ")));
		}
		scan.close();
	}

}
