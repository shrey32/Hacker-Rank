package com.leetcode.monthchallenge;

/**
 * <b>Longest Common Subsequence</b>
 * <p>
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * </p>
 * 
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative order
 * of the remaining characters. (eg, "ace" is a subsequence of "abcde" while
 * "aec" is not). A common subsequence of two strings is a subsequence that is
 * common to both strings.
 * </p>
 * 
 * 
 * 
 * <p>
 * If there is no common subsequence, return 0.
 * </p>
 * 
 * 
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input: text1 = "abcde", text2 = "ace"
 * </p>
 * <p>
 * <b>Output: 3
 * </p>
 * <p>
 * <b>Explanation: The longest common subsequence is "ace" and its length is 3.
 * </p>
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input: text1 = "abc", text2 = "abc"
 * </p>
 * <p>
 * <b>Output: 3
 * </p>
 * <p>
 * <b>Explanation: The longest common subsequence is "abc" and its length is 3.
 * </p>
 * <b>Example 3:</b>
 * 
 * <p>
 * <b>Input:</b> text1 = "abc", text2 = "def"
 * </p>
 * <p>
 * <b>Output:</b> 0
 * </p>
 * <p>
 * <b>Explanation:</b> There is no such common subsequence, so the result is 0.
 * </p>
 * 
 * 
 * <b>Constraints:</b>
 * 
 * <li>1 <= text1.length <= 1000</li>
 * <li>1 <= text2.length <= 1000</li>
 * <li>The input strings consist of lowercase English characters only.</li>
 * 
 * @author Shrey
 *
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcde", "ace"));// 3
		System.out.println(longestCommonSubsequence("abc", "abc"));// 3
		System.out.println(longestCommonSubsequence("abc", "def"));// 0
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int row = text1.length();
		int col = text2.length();
		int[][] dp = new int[row + 1][col + 1];
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[row][col];
	}

}
