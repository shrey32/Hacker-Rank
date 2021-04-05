package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class IsUnique {

	public static void main(String[] args) {
		System.out.println(isUnique("ABCDEFGHIJKL"));
		System.out.println(isUnique("ABCGGGIKK"));
	}

	public static boolean isUnique(String s) {
		if (s == null)
			return false;
		char[] chars = s.toCharArray();
		Arrays.sort(chars);

		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == chars[i + 1])
				return false;
		}
		return true;
	}

}
