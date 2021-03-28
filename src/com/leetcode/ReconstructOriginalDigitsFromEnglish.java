package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class ReconstructOriginalDigitsFromEnglish {

	public static void main(String[] args) {
		System.out.println(originalDigits("zerozero"));
	}

	public static String originalDigits(String s) {

		int[] freq = new int[26];
		for (char c : s.toCharArray())
			freq[c - 'a']++;
		int[] digits = new int[10];
		digits[0] = freq['z' - 'a'];
		digits[6] = freq['x' - 'a'];
		digits[4] = freq['u' - 'a'];
		digits[2] = freq['w' - 'a'];
		digits[8] = freq['g' - 'a'];
		digits[5] = freq['f' - 'a'] - digits[4];
		digits[7] = freq['s' - 'a'] - digits[6];
		digits[1] = freq['o' - 'a'] - digits[0] - digits[2] - digits[4];
		digits[3] = freq['t' - 'a'] - digits[8] - digits[2];
		digits[9] = freq['i' - 'a'] - digits[5] - digits[6] - digits[8];

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			int count = digits[i];
			while (count > 0) {
				sb.append("" + i);
				count--;
			}
		}
		return sb.toString();
	}

}
