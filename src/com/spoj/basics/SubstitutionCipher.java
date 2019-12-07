package com.spoj.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.spoj.com/problems/SMPCPH1/">SMPCPH1 - Substitution
 * cipher</a>
 * 
 * @author Shrey
 *
 */
public class SubstitutionCipher {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String chars = br.readLine();
		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			String s = br.readLine();
			System.out.println(substitution(chars, n, s));
		}
		br.close();
	}

	static final String substitution(String chars, int charLen, String s) {

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {

			char curr = s.charAt(i);
			int ind = chars.indexOf(curr);
			if (ind >= 0) {
				if (ind < charLen - 1) {
					curr = chars.charAt(ind + 1);
				} else {
					curr = chars.charAt(0);
				}
			}
			result.append(curr);
		}
		return result.toString();
	}

}
