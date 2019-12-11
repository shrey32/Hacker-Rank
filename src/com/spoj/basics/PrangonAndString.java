package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/MOZPAS/">MOZPAS - Prangon and
 * String</a>
 * 
 * @author Shrey
 *
 */
public class PrangonAndString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		System.out.println(build(n, m));
		scan.close();
	}

	private static final String build(int n, int m) {
		StringBuilder sb = new StringBuilder();
		char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int charInd = 0;
		int currCharCount = 0;
		while (sb.length() < n) {
			while (currCharCount < m) {
				sb.append(chars[charInd]);
				currCharCount++;
			}
			currCharCount = 0;
			charInd++;
		}
		return sb.toString();
	}

}
