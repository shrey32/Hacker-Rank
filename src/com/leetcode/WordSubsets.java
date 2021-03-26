package com.leetcode;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Shrey
 *
 */
public class WordSubsets {

	public static void main(String[] args) {
		System.out.println(wordSubsets(new String[] { "amazon", "apple", "facebook", "google", "leetcode" },
				new String[] { "e", "o" }));
		System.out.println(wordSubsets(new String[] { "amazon", "apple", "facebook", "google", "leetcode" },
				new String[] { "l", "e" }));
		System.out.println(wordSubsets(new String[] { "amazon", "apple", "facebook", "google", "leetcode" },
				new String[] { "e", "oo" }));
		System.out.println(wordSubsets(new String[] { "amazon", "apple", "facebook", "google", "leetcode" },
				new String[] { "lo", "eo" }));
		System.out.println(wordSubsets(new String[] { "amazon", "apple", "facebook", "google", "leetcode" },
				new String[] { "ec", "oc", "ceo" }));
		System.out.println(wordSubsets(new String[] { "cccbb", "aacbc", "bbccc", "baaba", "acaba" },
				new String[] { "cb", "b", "cb" }));
	}

	public static List<String> wordSubsets(String[] A, String[] B) {
		List<String> ans = new ArrayList<>();
		int[] maxFreqAcrossB = new int[26];
		for (String bStr : B) {
			int[] freqCountBStr = freq(bStr);
			for (int i = 0; i < 26; i++) {
				maxFreqAcrossB[i] = Math.max(maxFreqAcrossB[i], freqCountBStr[i]);
			}
		}

		for (String aStr : A) {
			int[] freqCountAStr = freq(aStr);
			boolean foundAllChar = true;
			for (int i = 0; i < 26; i++) {
				if (freqCountAStr[i] < maxFreqAcrossB[i]) {
					foundAllChar = false;
					break;
				}
			}

			if (foundAllChar) {
				ans.add(aStr);
			}
		}

		return ans;
	}

	public static int[] freq(String s) {
		int[] freq = new int[26];
		for (char c : s.toCharArray())
			freq[c - 'a']++;
		return freq;
	}

}
