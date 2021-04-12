package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Shrey
 *
 */
public class BeautifulArrangementII {

	public static void main(String[] args) {
		System.out.println(constructArray(10, 3));
	}

	public static int[] constructArray(int n, int k) {
		Set<Integer> set = new HashSet<>();
		int[] a = new int[n];
		a[0] = 1;
		set.add(1);
		int i;
		for (i = 1; i < n && k > 0; i++) {
			int v1 = a[i - 1] - k;
			int v2 = a[i - 1] + k;
			if (v1 > 0 && v1 <= n && !set.contains(v1))
				a[i] = v1;
			else if (v2 > 0 && v2 <= n && !set.contains(v2))
				a[i] = v2;
			k--;
			set.add(a[i]);
		}

		if (k == 0 && i < n) {
			for (int j = 1; j <= n; j++) {
				if (!set.contains(j))
					a[i++] = j;
			}
		}
		return a;
	}

}
