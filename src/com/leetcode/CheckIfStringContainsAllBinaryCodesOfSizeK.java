package com.leetcode;

import java.util.Set;
import java.util.HashSet;

/**
 * 
 * @author Shrey
 *
 */
public class CheckIfStringContainsAllBinaryCodesOfSizeK {

	public static void main(String[] args) {
		System.out.println(hasAllCodes("00110110", 2));// true
		System.out.println(hasAllCodes("00110", 2));// true
		System.out.println(hasAllCodes("0110", 1));// true
		System.out.println(hasAllCodes("0110", 2));// false
		System.out.println(hasAllCodes("0000000001011100", 4));// true
	}

	public static boolean hasAllCodes(String s, int k) {
		if (s.length() < k) {
			return false;
		}
		Set<String> set = new HashSet<>();

		for (int i = 0; i <= s.length() - k; i++) {
			String sub = s.substring(i, i + k);
			set.add(sub);
		}
		return set.size() == (Math.pow(2, k));
	}

}
