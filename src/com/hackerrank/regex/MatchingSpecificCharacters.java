package com.hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * Task

 You have a test string S. 
 Your task is to write a regex that will match S using the following conditions:

 S must be of length, greater than or equal to 5.
 First character should be a lowercase alphabet.
 Second character should be a positive digit.
 Third character should not be a lowercase alphabet.
 Fourth character should not be a uppercase alphabet.
 Fifth character should be an uppercase alphabet.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MatchingSpecificCharacters {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Pattern pattern = Pattern
				.compile("^[a-z][1-9][^a-z][^A-Z][A-Z]");
		String pair = "";
		while (T > 0) {
			pair = br.readLine();
			System.out.println(pattern.matcher(pair).matches());
			T--;
		}
		br.close();
	}
}
