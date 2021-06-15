package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println(convertToTitle(57));
		System.out.println(convertToTitle(701));
	}

	public static String convertToTitle(int cn) {
		StringBuilder res = new StringBuilder();
		while (cn > 0) {
			res.append((char) (--cn % 26 + 65));
			cn = cn / 26;
		}
		return res.reverse().toString();
	}

}
