package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class VerifyingAnAlienDictionary {

	public static void main(String[] args) {
		System.out.println(isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));// true
		System.out.println(isAlienSorted(new String[] { "word", "world", "row" }, "worldabcefghijkmnpqstuvxyz"));// false
		System.out.println(isAlienSorted(new String[] { "apple", "app" }, "abcdefghijklmnopqrstuvwxyz"));// false
	}

	public static boolean isAlienSorted(String[] words, String order) {
		int[] freq = grammer(order);
		String prev = words[0];
		for (int i = 1; i < words.length; i++) {
			if (compare(prev, words[i], freq) > 0)
				return false;
			prev = words[i];
		}
		return true;
	}

	private static int[] grammer(String order) {
		int[] freq = new int[26];
		for (int i = 0; i < order.length(); i++)
			freq[order.charAt(i) - 'a'] = i;
		return freq;
	}

	private static int compare(String a, String b, int[] freq) {
		int len1 = a.length();
		int len2 = b.length();
		int lim = Math.min(len1, len2);
		for (int k = 0; k < lim; k++) {
			int c1 = freq[a.charAt(k) - 'a'];
			int c2 = freq[b.charAt(k) - 'a'];
			if (c1 != c2) {
				return c1 - c2;
			}
		}
		return len1 - len2;
	}

}
