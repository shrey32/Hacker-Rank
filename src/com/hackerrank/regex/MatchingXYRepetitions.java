package com.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You have a test string S. 
 Your task is to write a regex that will match S using the following conditions:

 S should begin with 1 or 2 digits.
 After that, S should have 3 or more letters (both lowercase and uppercase).
 Then S should end with up to 3 . symbol(s). You can end with 0 to 3 . symbol(s), inclusively.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MatchingXYRepetitions {

	public static void main(String[] args) {
		Regex_Test tester = new Regex_Test();
		tester.checker("^[0-9]{1,2}[a-zA-Z]{3,}[.]{0,3}$");
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
