package com.hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Problem Statement

 You are given N lines and your task is to find out which of the N lines starts with

 hi<BLANK>
 where hi is case-insensitive and is not immediately followed by a space and a letter d(or D). 
 In the above representation, BLANK denotes a space character.

 Input Format

 First line contains an integer N. N lines follow each line with a sentence not more than 10 words W each, separated by a single space.

 Constraints

 1 <= N <= 10 
 If C is the count of the number of words W in every sentence, then 
 1 <= C <= 10 
 Each non-empty character in W is either a lowercase or an uppercase letter only

 Output Format

 Print each line that satisfies the constraint as mentioned in the problem statement.

 Sample Input

 5
 Hi Alex how are you doing
 hI dave how are you doing
 Good by Alex
 hidden agenda
 Alex greeted Martha by saying Hi Martha
 Sample Output

 Hi Alex how are you doing
 First line satisfies the constraint mentioned in the problem statement. 
 Second line fails as it contains a d next to

 hi<blank>
 Third line fails as it doesn't start with h 
 Fourth line fails as the third character in the line is not empty ( BLANK ) 
 Fifth line fails as Hi Martha doesn't appear at the beginning of the line.

 Viewing Submissions

 You can view others' submissions if you solve this challenge. Navigate to the challenge leaderboard.
 */

/**
 * 
 * @author Shrey
 *
 */
public class SayingHi {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			String line = br.readLine();
			sayingHi(line);
			T--;
		}
		br.close();
	}

	private static void sayingHi(String line) {
		Pattern hiPattern = Pattern.compile("^(h|H){1}(I|i){1} [^d]");
		Matcher m = hiPattern.matcher(line);
		if (m.find()) {
			System.out.println(line);
		}
	}
}
