package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.out.println("ZY");
	}

	public static int titleToNumber(String ct) {
		int res = 0;
		for (char c : ct.toCharArray()) {
			res = res * 26;
			res += (c - 65 + 1);
		}
		return res;
	}
}
