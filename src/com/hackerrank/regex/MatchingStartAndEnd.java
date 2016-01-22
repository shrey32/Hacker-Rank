package com.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You have a test string S. Your task is to match the pattern Xxxxx. 
 Here, x denotes a word character, and X denotes a digit. 
 S must start with a digit X and end with . symbol. 
 S should be 6 characters long only.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MatchingStartAndEnd {

	public static void main(String[] args) {
		Regex_Test tester = new Regex_Test();
		tester.checker("^\\d\\w\\w\\w\\w\\.$"); // Use \\ instead of using \
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
