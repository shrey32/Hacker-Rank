package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("IV"));// 4
		System.out.println(romanToInt("IX"));// 9
		System.out.println(romanToInt("LVIII"));// 58
		System.out.println(romanToInt("MCMXCIV"));// 1994
	}

	public static int romanToInt(String s) {
		int sum = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			String curr = s.charAt(i) + "";
			int temp = getNumberForRomanLetter(curr);
			if ("I".equals(curr) && checkNextLetter(s, i, "V", "X")) {
				temp = getNumberForRomanLetter(s.charAt(i + 1) + "") - temp;
				i++;
			} else if ("X".equals(curr) && checkNextLetter(s, i, "L", "C")) {
				temp = getNumberForRomanLetter(s.charAt(i + 1) + "") - temp;
				i++;
			} else if ("C".equals(curr) && checkNextLetter(s, i, "D", "M")) {
				temp = getNumberForRomanLetter(s.charAt(i + 1) + "") - temp;
				i++;
			}
			sum += temp;
		}
		return sum;
	}

	private static boolean checkNextLetter(String s, int index, String first, String second) {
		int len = s.length();
		int next = index + 1;
		if (next < len && (first.equals(s.charAt(next) + "") || second.equals(s.charAt(next) + "")))
			return true;
		return false;
	}

	private static int getNumberForRomanLetter(String s) {
		switch (s) {
		case "I":
			return 1;
		case "V":
			return 5;
		case "X":
			return 10;
		case "L":
			return 50;
		case "C":
			return 100;
		case "D":
			return 500;
		case "M":
			return 1000;
		default:
			return 0;
		}
	}

}
