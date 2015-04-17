package com.hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * Problem Statement

 American English and British English differ in several aspects which are reflected in their spelling. One difference frequently observed, is that words written in American English, which have a suffix ze often end in se in British English. Given the American-English spelling of a word which ends in ze your task is to find the total count of all its British and American variants in all the given sequences of words. i.e. you need to account for the cases where the word occurs as it is given to you (i.e. the version ending in -ze) and you also need to find the occurances of its British-English counterparts (i.e, the version ending in -se).

 Input Format

 First line contains N, N lines follow each line contains a sequence of words (W) separated by a single space. Next line contains T. T testcases follow in a new line. Each line contains the American English spelling of a word (W')

 Constraints

 1 <= N <= 10 
 Each line doesn't contain more than 10 words (W) 
 Each character of W and W' is a lowercase alphabet. 
 If C is the count of the number of characters of W or W', then 
 1 <= C <= 20 
 1 <= T <= 10 
 W' ends with ze ( US version of the word)

 Output Format

 Output T lines and in each line output the total number of American and British versions of (W') in all of N lines that contains a sequence of words.

 Sample Input

 2
 hackerrank has such a good ui that it takes no time to familiarise its environment
 to familiarize oneself with ui of hackerrank is easy
 1
 familiarize
 Sample Output

 2
 Explanation

 In the given 2 lines, we find familiarize and familiarise once each. So, the total count is 2.

 Viewing Submissions

 You can view others' submissions if you solve this challenge. Navigate to the challenge leaderboard.
 */

/**
 * 
 * @author Shrey
 *
 */
public class TheBritishAndAmericanStyleOfSpelling {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] lines = new String[N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			lines[i] = line;
		}
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String word = br.readLine();
			System.out
					.println(theBritishAndAmericanStyleOfSpelling(lines, word));
		}
		br.close();
	}

	private static int theBritishAndAmericanStyleOfSpelling(String[] lines,
			String word) {
		int count = 0;
		Pattern pattern = Pattern.compile("^[a-zA-Z]{2,}(ze|se)$");
		for (String line : lines) {
			String[] words = line.split(" ");
			for (String w : words) {
				if (pattern.matcher(w).matches()) {
                   if(word.length()==w.length() && word.contains(w.substring(0, w.length()-2))){
                	   count++;
                   }
				}
			}
		}
		return count;
	}
}
