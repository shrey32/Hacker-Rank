package com.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You have a test string S. 
 Your task is to write a regex that will match S using the following conditions:

 S should begin with 2 or more digits.
 After that, S should have 0 or more lowercase letters.
 S should end with 0 or more uppercase letters
 */
/**
 * 
 * @author Shrey
 *
 */
public class MatchingZeroOrMoreRepetitions {

	public static void main(String[] args) {
		Regex_Test tester = new Regex_Test();
		tester.checker("^[0-9]{2,}[a-z]{0,}[A-Z]{0,}$");
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
