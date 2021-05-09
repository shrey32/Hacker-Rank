package com.leetcode;

import java.util.HashMap;

/**
 * 
 * @author Shrey
 *
 */
public class MinWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("ab", "b"));
		System.out.println(minWindow("ab", "a"));
	}

	public static String minWindow(String s, String t) {
		if (s.length() <= 0 || s.length() < t.length())
			return "";
		HashMap<Character, Integer> calculatedFreq = new HashMap<>();
		HashMap<Character, Integer> freqT = new HashMap<>();

		for (int i = 0; i < t.length(); i++)
			freqT.put(t.charAt(i), freqT.getOrDefault(t.charAt(i), 0) + 1);

		int i = 0, j = 0, matchcount = 0, min = Integer.MAX_VALUE, fromi = -1, fromj = -1;

		for (j = 0; j < s.length(); j++) {
			char ch = s.charAt(j);
			calculatedFreq.put(ch, calculatedFreq.getOrDefault(ch, 0) + 1);
			if (freqT.containsKey(ch) && calculatedFreq.get(ch) <= freqT.get(ch)) {
				matchcount++;
			}

			while (matchcount == t.length() && i < s.length()) {
				int temp = j - i + 1;
				if (min > temp) {
					fromi = i;
					fromj = j;
				}
				min = Math.min(min, temp);
				char sch = s.charAt(i);
				int freq = calculatedFreq.get(sch);
				freq--;
				calculatedFreq.put(sch, freq);
				if (freqT.containsKey(sch)) {
					if (freq < freqT.get(sch))
						matchcount--;
				}
				i++;
			}
		}

		if (fromi == -1 || fromj == -1)
			return "";

		String ans = "";
		ans = s.substring(fromi, fromj + 1);

		return ans;
	}

}
