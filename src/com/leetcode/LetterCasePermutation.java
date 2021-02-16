package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class LetterCasePermutation {

	public static void main(String[] args) {
		System.out.println(letterCasePermutation("a1b2"));
		System.out.println(letterCasePermutation("3z4"));
		System.out.println(letterCasePermutation("12345"));
		System.out.println(letterCasePermutation("0"));
	}

	public static List<String> letterCasePermutation(String s) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() == 0)
			return result;
		permutation(s.toCharArray(), result, 0);
		return result;
	}

	public static void permutation(char[] str, List<String> result, int index) {
		if (str.length == index) {
			result.add(new String(str));
			return;
		}

		if (Character.isDigit(str[index])) {
			permutation(str, result, index + 1);

		} else {
			str[index] = Character.toLowerCase(str[index]);
			permutation(str, result, index + 1);

			str[index] = Character.toUpperCase(str[index]);
			permutation(str, result, index + 1);
		}
	}

}
