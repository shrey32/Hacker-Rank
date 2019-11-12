package com.hackerrank.strings;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * <a href="https://www.spoj.com/problems/TESTPASS/">TESTPASS - Password01<a/>
 * 
 * @author Shrey
 *
 */
public class ThePassword {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			String s = scan.next();
			System.out.println(validate(s));
		}
		scan.close();
	}

	private static final String validate(String s) {
		if (s.length() < 6 || s.length() > 20)
			return "NO";
		Pattern numbers = Pattern.compile("[0-9]{1,}");
		Pattern lowerCase = Pattern.compile("[a-z]{1,}");
		Pattern upperCase = Pattern.compile("[A-Z]{1,}");
		Pattern specialCharacters = Pattern.compile("(\\W)");
		boolean hasNum = numbers.matcher(s).find();
		boolean hasLowerCase = lowerCase.matcher(s).find();
		boolean hasUpperCase = upperCase.matcher(s).find();
		boolean hasSpclChars = specialCharacters.matcher(s).find();
		boolean isValid = isValid(s);
		return (hasNum && hasLowerCase && hasUpperCase && hasSpclChars && isValid) ? "YES" : "NO";
	}

	private static final boolean isValid(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length() - 2; i++) {
			sb.append(s.charAt(i));
			sb.append(s.charAt(i + 1));
			sb.append(s.charAt(i + 2));
			if (s.substring(i + 3, s.length()).indexOf(sb.toString()) >= 0)
				return false;
			sb.delete(2, sb.length());
			if (s.substring(i + 2, s.length()).indexOf(sb.toString()) >= 0)
				return false;
			sb.delete(0, sb.length());
		}
		return true;
	}

}
