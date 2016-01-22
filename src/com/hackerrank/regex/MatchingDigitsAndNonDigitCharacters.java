package com.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *you have a test string S. Your task is to match the pattern xxXxxXxxxx 
Here x denotes a digit character, and X denotes a non-digit character.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MatchingDigitsAndNonDigitCharacters {

	public static void main(String[] args) {
		Regex_Test tester = new Regex_Test();
		tester.checker("[\\d]{2}\\D[\\d]{2}\\D[\\d]{4}");
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
