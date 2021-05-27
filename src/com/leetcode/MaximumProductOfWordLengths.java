package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
public class MaximumProductOfWordLengths {

	public static void main(String[] args) {
		System.out.println(maxProduct(new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" }));// 16
		System.out.println(maxProduct(new String[] { "a", "ab", "abc", "d", "cd", "bcd", "abcd" }));// 4
		System.out.println(maxProduct(new String[] { "a", "aa", "aaa", "aaaa" }));// 0
	}

	public static int maxProduct(String[] words) {
		Map<String, int[]> freqMap = new HashMap<>();
		for (String word : words)
			freqMap.put(word, freq(word));
		int max = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if (unique(freqMap.get(words[i]), freqMap.get(words[j])))
					max = Math.max(max, words[i].length() * words[j].length());
			}
		}
		return max;
	}

	public static int[] freq(String word) {
		int[] freq = new int[26];
		for (char c : word.toCharArray())
			freq[c - 'a']++;
		return freq;
	}

	public static boolean unique(int[] freq1, int[] freq2) {
		for (int i = 0; i < 26; i++)
			if (freq1[i] > 0 && freq2[i] > 0)
				return false;
		return true;
	}

}
