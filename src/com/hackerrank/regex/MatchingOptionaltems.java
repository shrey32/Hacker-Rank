package com.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You have a test string S. 
 Your task is to write a regex that will match S using following conditions:

 S should consist of only letters (both lowercase and uppercase).
 S should end with s or es.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MatchingOptionaltems {

	public static void main(String[] args) {
		Regex_Test tester = new Regex_Test();
		tester.checker("^[a-zA-Z]*e?s$");
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
