package com.crackingthecodinginterview;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>
 * You are given two arrays, one shorter (with all distinct elements) and one
 * longer. Find the shortest subarray in the longer array that contains all the
 * elements in the shorter array. The items can appear in any order.
 * </p>
 * <p>
 * EXAMPLE lnput:{1, 5, 9} I {7, 5, 9, 0, 2, 1, 3, 5, 7, 9. 1, 1, 5, 8, 8, 9, 7}
 * Output: [ 7, 10] (the underlined portion above)
 * </p>
 * 
 * @author Shrey
 *
 */
public class ShortestSuperSequence {

	public static void main(String[] args) {
		int[] s = new int[] { 7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7 };
		int[] t = new int[] { 1, 5, 9 };
		int[] res = minWindowSubSequence(s, t);
		System.out.println("[" + res[0] + ", " + res[1] + "]");
	}

	public static int[] minWindowSubSequence(int[] s, int[] t) {
		if (s.length <= 0 || s.length < t.length)
			return new int[] { -1, -1 };

		Map<Integer, Integer> freqT = new HashMap<>();
		Map<Integer, Integer> calculated = new HashMap<>();

		for (int i : t) {
			freqT.put(i, freqT.getOrDefault(i, 0) + 1);
		}

		int i = 0, matchCount = 0, min = Integer.MAX_VALUE, fromi = -1, fromj = -1;

		for (int j = 0; j < s.length; j++) {
			int curr = s[j];
			calculated.put(curr, calculated.getOrDefault(curr, 0) + 1);
			if (freqT.containsKey(curr) && calculated.get(curr) <= freqT.get(curr))
				matchCount++;

			while (matchCount == t.length && i < s.length) {
				int temp = j - i + 1;
				if (min > temp) {
					min = temp;
					fromi = i;
					fromj = j;
				}
				int freq = calculated.get(s[i]);
				freq--;
				calculated.put(s[i], freq);
				if (freqT.containsKey(s[i])) {
					if (freq < freqT.get(s[i]))
						matchCount--;
				}
				i++;
			}
		}

		return new int[] { fromi, fromj };
	}

}
