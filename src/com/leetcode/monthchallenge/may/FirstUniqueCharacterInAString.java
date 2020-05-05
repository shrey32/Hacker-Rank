package com.leetcode.monthchallenge.may;

/**
 * <b>First Unique Character in a String</b>
 * <p>
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * </p>
 * 
 * <b>Examples:</b>
 * 
 * <p>
 * <b>s = "leetcode"</b>,return 0.
 * </p>
 * 
 * <p>
 * <b>s = "loveleetcode"</b>,return 2.
 * </p>
 * <p>
 * <b>Note:</b> You may assume the string contain only lowercase letters.
 * </p>
 * 
 * @author Shrey
 *
 */
public class FirstUniqueCharacterInAString {

	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));// 0
		System.out.println(firstUniqChar("loveleetcode"));// 2
	}

	public static int firstUniqChar(String s) {
		int[] arr = new int[26];
		for (char ch : s.toCharArray())
			arr[ch - 'a']++;
		for (int i = 0; i < s.length(); i++) {
			if (arr[s.charAt(i) - 'a'] == 1)
				return i;
		}
		return -1;
	}

}
