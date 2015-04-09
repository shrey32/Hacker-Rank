package com.hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * Problem Statement

 Increasing popularity of hackerrank can be seen in tweets like

 I love #hackerrank
 I just scored 27 points in the Picking Cards challenge on #HackerRank
 I just signed up for summer cup @hackerrank
 Given a set of most popular tweets, your task is to find out how many of those tweets has the string hackerrank in it.

 Input Format

 First line is an integer N. N lines follow. Each line is a valid tweet.

 Constraints

 1 <= N <= 10 
 Each character of the tweet is a valid ASCII character.

 Output format

 Print the total number of tweets that has hackerrank (case insensitive) in it

 Sample Input

 4
 I love #hackerrank
 I just scored 27 points in the Picking Cards challenge on #HackerRank
 I just signed up for summer cup @hackerrank
 interesting talk by hari, co-founder of hackerrank
 Sample Output

 4
 Explanation

 All the 4 lines have the string hackerrank in them and thus 4.

 Viewing Submissions

 You can view others' submissions if you solve this challenge. Navigate to the challenge leaderboard.
 */
/**
 * 
 * @author Shrey
 *
 */
public class HackerRankTweets {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int count = 0;
		while (T > 0) {
			String tweet = br.readLine();
			count += tweetCount(tweet);
			T--;
		}
		System.out.println(count);
		br.close();
	}

	private static int tweetCount(String tweet) {
		Pattern pattern = Pattern.compile("\\@{1}[A-Z]{10}|\\#{1}[A-Z]{10}");
		String[] words = tweet.split(" ");
		int count = 0;
		for (String word : words) {
			if (pattern.matcher(word.toUpperCase()).matches()
					|| word.toUpperCase().equals("HACKERRANK")) {
				count++;
			}
		}
		return count;
	}

}
