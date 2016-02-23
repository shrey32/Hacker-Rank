package com.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Shrey
 *
 */
public class MatchingWordBoundaries {

	public static void main(String[] args) {
		Regex_Test tester = new Regex_Test();
		tester.checker("\\b[aeiouAEIOU][a-zA-Z]*\\b"); // Use \\ instead of using \
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
