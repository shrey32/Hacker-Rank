package com.geekforgeeks.google;

import java.util.Scanner;

/**
 * <a href=
 * "https://practice.geeksforgeeks.org/problems/total-decoding-messages/0">Total
 * Decoding Messages</a>
 * 
 * @author Shrey
 *
 */


public class TotalDecodingMessages {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			String s = scan.next();
			System.out.println(totalDecodingMessages(n, s));
		}
		scan.close();
	}

	private final static int totalMessages(String num) {
		if (num == null || "".equals(num) || num.indexOf("0") >= 0)
			return 0;
		int count = 1;
		char[] chars = num.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '0')
				continue;
			boolean isFound = false;
			for (int j = i + 1; j < chars.length; j++) {
				int tempInd = i;
				int other = Integer.parseInt(chars[tempInd] + "" + chars[j]);
				if (other > 0 && other <= 26) {
					tempInd = j + 1;
					j = tempInd;
					isFound = true;
				}
			}
			if (isFound) {
				count++;
				isFound = false;
			}
		}
		return count;
	}

	private static final int totalDecodingMessages(int n, String s) {
		if (s == null || "".equals(s) || s.indexOf("0") >= 0)
			return 0;
		int count = 1;

		for (int i = 0; i < n; i++) {
			char c1 = s.charAt(i);
			if (c1 == '0')
				continue;
			if (i + 1 < n) {
				char c2 = s.charAt(i + 1);
				if (Integer.parseInt(c1 + "" + c2) <= 26) {
					count++;
				}
			}
		}

		if (n % 2 == 0) {
			boolean allOk = true;
			for (int i = 0; i < n; i++) {
				char c1 = s.charAt(i++);
				if (i < n) {
					char c2 = s.charAt(i);
					if (Integer.parseInt(c1 + "" + c2) > 26) {
						allOk = false;
					}
				}
			}
			if (allOk)
				count++;
		}

		return count;
	}

}
