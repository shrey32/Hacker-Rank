package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		System.out.println(findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
	}

	public static List<Integer> findSubstring(String s, String[] words) {
		HashMap<String, Integer> freq = new HashMap<>();
		int oneLength = words[0].length();
		for (String word : words) {
			freq.put(word, freq.getOrDefault(word, 0) + 1);
		}

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i <= s.length() - (words.length * oneLength); i++) {
			int gotCount = 0;
			HashMap<String, Integer> map = new HashMap<>(freq);

			for (int j = i; j + oneLength <= s.length(); j += oneLength) {
				String key = s.substring(j, j + oneLength);
				if (map.containsKey(key) && map.get(key) != 0) {
					gotCount++;
					map.put(key, map.get(key) - 1);

					if (gotCount == words.length) {
						list.add(i);
						break;
					}
				} else
					break;
			}
		}
		return list;
	}
}
