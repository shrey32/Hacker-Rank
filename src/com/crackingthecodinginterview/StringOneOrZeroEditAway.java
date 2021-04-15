package com.crackingthecodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class StringOneOrZeroEditAway {

	public static void main(String[] args) {
		System.out.println("O(m*n) approach using DP");
		System.out.println(minEditDistance("pale", "ple"));
		System.out.println(minEditDistance("pale", "bake"));
		System.out.println(minEditDistance("pale", "pale"));
		System.out.println("O(n) approach");
		System.out.println(isEditDistanceOneOrZero("pale", "ple"));
		System.out.println(isEditDistanceOneOrZero("pale", "bake"));
		System.out.println(isEditDistanceOneOrZero("pale", "pale"));
	}

	public static boolean isEditDistanceOneOrZero(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		int m = s1.length();
		int n = s2.length();
		// diff should be less than or equal to 1
		if (Math.abs(m - n) > 1)
			return false;
		int i = 0, j = 0;
		int count = 0;
		while (i < m && j < n) {
			if (s1.charAt(i) != s2.charAt(j)) {
				if (count == 1)
					return false;
				if (m > n)
					i++;
				else if (m < n)
					j++;
				else {
					i++;
					j++;
				}
				count++;
			} else {
				i++;
				j++;
			}
		}
		return count <= 1;
	}

	public static boolean minEditDistance(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();
		int dp[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0)
					dp[i][j] = j;
				else if (j == 0)
					dp[i][j] = i;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
			}
		}
		return (dp[m][n] <= 1);
	}

}
