package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class InterLeavingString {

	public static void main(String[] args) {
		System.out.println(isInterleave("", "abc", "abc"));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(isInterleave("", "", ""));
	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		return s1.length() + s2.length() == s3.length()
				? dfs(s1, s2, s3, 0, 0, 0, new boolean[s1.length() + 1][s2.length() + 1])
				: false;
	}

	public static boolean dfs(String s1, String s2, String s3, int i, int j, int k, boolean[][] dp) {

		if (k == s3.length())
			return true;
		if (dp[i][j])
			return false;

		boolean matches = i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(s1, s2, s3, i + 1, j, k + 1, dp)
				|| j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(s1, s2, s3, i, j + 1, k + 1, dp);
		if (!matches)
			dp[i][j] = true;
		return matches;
	}

}
