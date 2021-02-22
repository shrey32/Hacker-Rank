package com.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class LongestWordInDictionaryThroughDeleting {

	public static void main(String[] args) {
		System.out.println(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));// apple
		System.out.println(findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));// a
		System.out.println(findLongestWord("aewfafwafjlwajflwajflwafj",
				Arrays.asList("apple", "ewaf", "awefawfwaf", "awef", "awefe", "ewafeffewafewf")));// "awefawfwaf"
	}

	private static String findLongestWord(String s, List<String> dict) {
		String result = "";

		for (String str : dict) {

			int currIndex = s.indexOf(str.charAt(0));
			if (currIndex < 0)
				continue;
			boolean proceed = true;
			for (int i = 1; i < str.length(); i++) {
				int nextIndex = s.indexOf(str.charAt(i), currIndex + 1);
				if (nextIndex < 0) {
					proceed = false;
					break;
				}
				currIndex = nextIndex;
			}
			if (proceed) {
				if (str.length() > result.length()) {
					result = str;
				} else if (str.length() == result.length() && result.compareTo(str) > 0) {
					result = str;
				}
			}
		}

		return result;
	}

}
