package com.crackingthecodinginterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Shrey
 *
 */
public class LongestWord {

	public static void main(String[] args) {
		System.out.println(longestWord(new String[] { "cat", "banana", "dog", "nana", "monkey", "walk", "walker",
				"dogwalker", "monkeybanana" }));
	}

	/**
	 * 
	 * @param words
	 * @return
	 */
	public static String longestWord(String[] words) {
		Set<String> set = new HashSet<>();
		for (String word : words)
			set.add(word);
		Arrays.sort(words, Comparator.reverseOrder());
		for (String word : words) {
			if (exist(word, set))
				return word;
		}
		return null;
	}

	public static boolean exist(String word, Set<String> set) {

		for (int i = 0; i < word.length(); i++) {
			String left = word.substring(0, i);
			String right = word.substring(i);
			if (set.contains(left) && set.contains(right))
				return true;
		}
		return false;
	}

}
