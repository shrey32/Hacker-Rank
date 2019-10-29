package com.hackerrank.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.spoj.com/problems/HS12HDPW/">HS12HDPW - Hidden
 * Password</a>
 * 
 * @author Shrey
 *
 */
public class HiddenPassword {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			br.readLine();
			String toupleLine = br.readLine().trim();
			String str = br.readLine().trim();
			System.out.println(hiddenPassword(toupleLine, str));
			br.readLine();
		}
		br.close();
	}

	static final String hiddenPassword(String toupleLine, String str) {
		String[] touples = toupleLine.split(" ");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < touples.length; i++) {
			String touple = touples[i];
			int blue = 0, green = 0;
			for (int j = 0; j < 6; j++) {
				int ascii = touple.charAt(j);
				int bit = (ascii >> j) & 1;
				blue = blue | (bit << j);
				bit = (ascii >> ((j + 3) % 6)) & 1;
				green = green | (bit << j);
			}
			result.append(str.charAt(blue));
			result.append(str.charAt(green));
		}
		return result.toString();
	}

}
