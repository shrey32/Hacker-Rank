package com.hackerrank.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.spoj.com/problems/CPTTRN1/">CPTTRN1 - Character Patterns
 * (Act 1)</a>
 * 
 * @author Shrey
 *
 */
public class CharacterPattern {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String[] vals = br.readLine().trim().split(" ");
			int r = Integer.parseInt(vals[0]);
			int c = Integer.parseInt(vals[1]);
			print(r, c);
		}
		br.close();
	}

	final static void print(int r, int c) {
		boolean star = true;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (star)
					System.out.print("*");
				else
					System.out.print(".");
				star = !star;
			}
			System.out.println();
		}
	}

}
