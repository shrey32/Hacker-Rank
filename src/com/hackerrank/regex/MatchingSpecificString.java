package com.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You have a test string S. Your task is to match the string hackerrank. This is case sensitive.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MatchingSpecificString {

	public static void main(String[] args) {
		Regex_Test tester = new Regex_Test();
		tester.checker("hackerrank");
	}

	public static class Regex_Test {

		public void checker(String Regex_Pattern) {
			Scanner Input = new Scanner(System.in);
			String Test_String = Input.nextLine();
			Pattern p = Pattern.compile(Regex_Pattern);
			Matcher m = p.matcher(Test_String);
			int Count = 0;
			while (m.find()) {
				Count += 1;
			}
			Input.close();
			System.out.format("Number of matches : %d", Count);
		}

	}
}
