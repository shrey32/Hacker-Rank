package com.hackerrank.crackingcodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class StringOneOrZeroEditAway {

	public static void main(String[] args) {
		System.out.println(minEditDistance("pale", "ple"));
		System.out.println(minEditDistance("pale", "bake"));
		System.out.println(minEditDistance("pale", "pale"));
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
