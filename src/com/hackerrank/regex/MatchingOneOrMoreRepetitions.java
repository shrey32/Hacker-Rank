package com.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You have a test string S. 
 Your task is to write a regex that will match S using the following conditions:

 S should begin with 1 or more digits.
 After that, S should have 1 or more uppercase letters.
 S should end with 1 or more lowercase letters.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MatchingOneOrMoreRepetitions {

	public static void main(String[] args) {
		Regex_Test tester = new Regex_Test();
		tester.checker("^[0-9]{1,}[A-Z]{1,}[a-z]{1,}$");
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
