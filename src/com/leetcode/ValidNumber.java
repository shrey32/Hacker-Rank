package com.leetcode;

import java.util.regex.Pattern;

/**
 * 
 * @author Shrey
 *
 */
public class ValidNumber {

	private static Pattern NUMBER = Pattern.compile("[+-]?(\\.\\d+|\\d+(\\.\\d*)?)([eE][+-]?\\d+)?");

	public static void main(String[] args) {
		System.out.println(isNumber(""));
		System.out.println(isNumber(""));
		System.out.println(isNumber(""));
		System.out.println(isNumber(""));
	}

	public static boolean isNumber(String s) {
		return NUMBER.matcher(s.trim()).matches();
	}

}
