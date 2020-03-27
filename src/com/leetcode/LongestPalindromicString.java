package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class LongestPalindromicString {

	public static void main(String[] args) {
		System.out.println(longestPalindromicSubstr("forgeeksskeegfor"));
		System.out.println(longestPalindromicSubstr("banana"));
		System.out.println(longestPalindromicSubstr("babad"));
		System.out.println(longestPalindromicSubstr("google"));
	}

	public static String longestPalindromicSubstr(String s) {
		if (s == null || s.length() == 0)
			return s;
		String longest = "";
		for (int i = 0; i < s.length(); i++) {
			String temp = expand(s, i, i);
			if (temp.length() > longest.length())
				longest = temp;
			temp = expand(s, i, i + 1);
			if (temp.length() > longest.length())
				longest = temp;
		}
		return longest;
	}

	private static String expand(String s, int start, int end) {
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return s.substring(start + 1, end);
	}

}
