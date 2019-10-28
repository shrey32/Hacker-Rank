package com.hackerrank.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.spoj.com/problems/STRHH/">STRHH - Half of the half</a>
 * 
 * @author Shrey
 *
 */
public class HalfOfHalf {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String s = br.readLine().trim();
			halfOfHalf(s);
		}
		br.close();
	}

	static final void halfOfHalf(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length() / 2; i += 2) {
			sb.append(s.charAt(i));
		}

		System.out.println(sb.toString());
	}

}
