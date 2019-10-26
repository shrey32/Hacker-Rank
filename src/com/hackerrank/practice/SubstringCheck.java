package com.hackerrank.practice;

public class SubstringCheck {

	public static void main(String[] args) {
		System.out.println(substrCheck("1010110010", "10110"));// 2
		System.out.println(substrCheck("1110111011", "10011"));// -1
		System.out.println(substrCheck("geeksforgeeks", "for"));// 5
		System.out.println(substrCheck("ABABDABACDABABCABAB", "ABABCABAB"));// -1
	}

	/**
	 * using kmp search algorithm
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int substrCheck(String txt, String pat) {
		int m = pat.length();
		int n = txt.length();
		int[][] dfa = new int[256][m];

		computeLPSArray(pat, m, dfa);

		int i, j;
		for (i = 0, j = 0; i < n && j < m; i++) {
			j = dfa[txt.charAt(i)][j];
		}
		if (j == m)
			return i - m;
		return -1;
	}

	private final static void computeLPSArray(String pat, int m, int dfa[][]) {

		dfa[pat.charAt(0)][0] = 1;
		for (int x = 0, j = 1; j < m; j++) {
			for (int c = 0; c < dfa.length; c++)
				dfa[c][j] = dfa[c][x];// Copy mismatch cases.
			dfa[pat.charAt(j)][j] = j + 1; // Set match case.
			x = dfa[pat.charAt(j)][x]; // Update restart state.
		}
	}

}
