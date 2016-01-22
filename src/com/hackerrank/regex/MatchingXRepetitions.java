package com.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You have a test string S. 
 Your task is to write a regex that will match S using the following conditions:

 S must be of length equal to 45.
 The first 40 characters should consist of letters(both lowercase and uppercase), or of even digits.
 The last 5 characters should consist of odd digits or whitespace characters.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MatchingXRepetitions {

	public static void main(String[] args) {
		Regex_Test tester = new Regex_Test();
		tester.checker("^[a-zA-Z02468]{40}[13579\\s]{5}$");
	}

	static class Regex_Test {

		public void checker(String Regex_Pattern) {
			Scanner Input = new Scanner(System.in);
			String Test_String = Input.nextLine();
			Pattern p = Pattern.compile(Regex_Pattern);
			Matcher m = p.matcher(Test_String);
			System.out.println(m.find());
			Input.close();
		}

	}
}
