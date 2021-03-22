package com.leetcode;

import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author Shrey
 *
 */
public class VowelSpellChecker {

	public static void main(String[] args) {
		String[] result = new VowelSpellChecker().spellchecker(new String[] { "KiTe", "kite", "hare", "Hare" },
				new String[] { "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto" });
		System.out.println(Arrays.toString(result));
		result = new VowelSpellChecker().spellchecker(new String[] { "YellOw" }, new String[] { "yeellow" });
		System.out.println(Arrays.toString(result));
		result = new VowelSpellChecker().spellchecker(new String[] { "ae", "aa" }, new String[] { "UU" });
		System.out.println(Arrays.toString(result));
	}

	public String[] spellchecker(String[] wordlist, String[] queries) {

		Set<String> wordSet = new HashSet<>();
		Map<String, String> map = new HashMap<>();
		for (String word : wordlist) {
			wordSet.add(word);
			String lowerCaseStr = word.toLowerCase();
			map.putIfAbsent(lowerCaseStr, word);

			String vowelStr = vowelStr(word);
			System.out.println(vowelStr + " " + word);
			map.putIfAbsent(vowelStr, word);
		}

		for (int i = 0; i < queries.length; i++) {

			if (wordSet.contains(queries[i])) {
				continue;
			}

			String lowercase = queries[i].toLowerCase();
			if (map.containsKey(lowercase)) {
				queries[i] = map.get(lowercase);
				continue;
			}

			String vowelStr = vowelStr(queries[i]);

			if (map.containsKey(vowelStr)) {
				queries[i] = map.get(vowelStr);
				continue;
			}

			queries[i] = "";

		}

		return queries;
	}

	private String vowelStr(String word) {
		char[] wordChar = word.toLowerCase().toCharArray();
		for (int i = 0; i < word.length(); i++) {
			if (wordChar[i] == 'a' || wordChar[i] == 'e' || wordChar[i] == 'i' || wordChar[i] == 'o'
					|| wordChar[i] == 'u') {
				wordChar[i] = '*';
			}

		}
		return new String(wordChar);
	}

}
