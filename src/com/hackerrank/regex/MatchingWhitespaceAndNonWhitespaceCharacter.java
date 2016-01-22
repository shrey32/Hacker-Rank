package com.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *You have a test string S. Your task is to match the pattern XXxXXxXX 
 Here, x denotes whitespace characters, and X denotes non-white space characters.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MatchingWhitespaceAndNonWhitespaceCharacter {

	public static void main(String[] args) {
		Regex_Test tester = new Regex_Test();
		tester.checker("[\\w]{1,2}\\s[\\w]{1,2}\\s[\\w]{1,2}");
	}

	static class Regex_Test {

		public void checker(String Regex_Pattern) {
			Scanner Input = new Scanner(System.in);
			String Test_String = Input.nextLine();
			Pattern p = Pattern.compile(Regex_Pattern);
			Matcher m = p.matcher(Test_String);
			System.out.println(m.matches());
			Input.close();
		}
	}
}
