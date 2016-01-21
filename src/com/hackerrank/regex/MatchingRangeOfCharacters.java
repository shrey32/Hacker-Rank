package com.hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * Task

 You have a test string S. 
 Your task is to write a regex that will match S with the following conditions:

 S must be of length 6.
 First character should not be a digit ( 1,2,3,4,5,6,7,8,9 or 0 ).
 Second character should not be a lowercase vowel ( a,e,i,o or u ).
 Third character should not be b, c, D or F.
 Fourth character should not be a whitespace character ( \r, \n, \t, \f or <space> ).
 Fifth character should not be a uppercase vowel ( A,E,I,O or U ).
 Sixth character should not be a . or , symbol.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MatchingRangeOfCharacters {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Pattern pattern = Pattern
				.compile("^[^0-9][^aeiou][^bcDF][^\\r\\n\\t\\f\\s][^AEIOU][^.,]${6}");
		String pair = "";
		while (T > 0) {
			pair = br.readLine();
			System.out.println(pattern.matcher(pair).matches());
			T--;
		}
		br.close();

	}
}
