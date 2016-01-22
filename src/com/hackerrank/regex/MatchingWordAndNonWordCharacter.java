package com.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *You have a test string S. Your task is to match the pattern xxxXxxxxxxxxxxXxxx 
Here x denotes any word character and X denotes any non-word character.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MatchingWordAndNonWordCharacter {

	public static void main(String[] args) {
		Regex_Test tester = new Regex_Test();
		tester.checker("[\\w]{3}[\\W][\\w]{10}[\\W][\\w]{3}");
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
