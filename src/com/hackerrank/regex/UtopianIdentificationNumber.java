package com.hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * Problem Statement

 A new identification number is given for every Citizen of the Country Utopia and it has the following format.

 The string must begin with between 0-3 (inclusive) lowercase alphabets.
 Immediately following the letters, there must be a sequence of digits (0-9). The length of this segment must be between 2 and 8, both inclusive.
 Immediately following the numbers, there must be atleast 3 uppercase letters.
 Your task is to find out if a given identification number is valid or not.

 Input Format

 The first line contains N, N lines follow each line containing an identification number.

 Constraints

 1 <= N <= 100
 Output Format

 For every identification number, please print

 VALID
 if the identification number is valid and print

 INVALID
 otherwise.

 Sample Input

 2
 abc012333ABCDEEEE
 0123AB
 Sample Output

 VALID
 INVALID
 Explanation

 The first testcase is valid as it starts with 3 letters, followed by 3 integers (max of 8 and min of 2) and ends with more than 3 uppercase letters. 
 The second testcase is invalid as it satisfies the first (atleast 0 lowercase alphabets) and the second condition (alteast 2 integers) but fails on the third condition.

 Viewing Submissions

 You can view others' submissions if you solve this challenge. Navigate to the challenge leaderboard.
 */
/**
 * 
 * @author Shrey
 *
 */
public class UtopianIdentificationNumber {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			String line = br.readLine();
			utopianIdentificationNumber(line);
			T--;
		}
		br.close();
	}

	private static void utopianIdentificationNumber(String line) {
		Pattern pattern = Pattern.compile("[a-z]{0,3}[0-9]{2,8}[A-Z]{3,}");
		if (pattern.matcher(line).matches()) {
			System.out.println("VALID");
		} else {
			System.out.println("INVALID");
		}

	}

}
