package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		System.out.println(numTrees(5));
	}

	public static int numTrees(int n) {
		return (int) catalan(n);
	}

	static long binomialCoeff(int n, int k) {
		long res = 1;
		// Since C(n, k) = C(n, n-k)
		if (k > n - k) {
			k = n - k;
		}
		for (int i = 0; i < k; ++i) {
			res *= (n - i);
			res /= (i + 1);
		}
		return res;
	}

	static long catalan(int n) {
		// Calculate value of 2nCn
		long c = binomialCoeff(2 * n, n);

		// return 2nCn/(n+1)
		return c / (n + 1);
	}

}
