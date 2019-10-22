package com.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Madam Hannah Otto, the CEO of Reviver Corp., is fond of palindromes, or words that read the same forwards or backwards. She thinks palindromic brand names are appealing to millennials.

 As part of the marketing campaign for the company's new juicer called the Rotator™, Hannah decided to push the marketing team's palindrome-searching skills to a new level with a new challenge.

 In this challenge, Hannah provides a string  consisting of lowercase English letters. Every day, for  days, she would select two integers  and , take the substring  (the substring of  from index  to index ), and ask the following question:

 Consider all the palindromes that can be constructed from some of the letters from . You can reorder the letters as you need. Some of these palindromes have the maximum length among all these palindromes. How many maximum-length palindromes are there?

 For example, if ,  and , then we have,

 image

 Your job as the head of the marketing team is to answer all the queries. Since the answers can be very large, you are only required to find the answer modulo .

 Complete the functions initialize and answerQuery and return the number of maximum-length palindromes modulo .

 Input Format

 The first line contains the string .

 The second line contains a single integer .

 The  of the next  lines contains two space-separated integers ,  denoting the  and  values Anna selected on the day.

 Constraints

 Here,  denotes the length of .

 Subtasks

 For 30% of the total score:

 For 60% of the total score:

 Output Format

 For each query, print a single line containing a single integer denoting the answer.

 Sample Input 0

 week
 2
 1 4
 2 3
 Sample Output 0

 2
 1
 Explanation 0

 On the first day,  and . The maximum-length palindromes are "ewe" and "eke".

 On the second day,  and . The maximum-length palindrome is "ee".

 image

 Sample Input 1

 abab
 1
 1 4
 Sample Output 1

 2
 Explanation 1

 Here, the maximum-length palindromes are "abba" and "baab".
 */
/**
 * 
 * @author Shrey
 *
 */
public class MaximumPalindromes {

	public static void main(String[] args) {
		/*System.out.println(initialize("week", 1, 4));// 2
		System.out.println(initialize("week", 2, 3));// 1
		System.out.println(initialize("abab", 1, 4));// 2
		System.out.println(initialize("aaabbb", 1, 4));// 1
		System.out.println(initialize("wuhmbspjnfviogqzldrcxtaeyk", 4, 5));// 2
		System.out
				.println(initialize(
						"daadabbadcabacbcccbdcccdbcccbbaadcbabbdaaaabbbdabdbbdcadaaacaadadacddabbbbbdcccbaabbbacacddbbbcbbdbd",
						81, 83));*/
		System.out
				.println(initialize(
						"daadabbadcabacbcccbdcccdbcccbbaadcbabbdaaaabbbdabdbbdcadaaacaadadacddabbbbbdcccbaabbbacacddbbbcbbdbd",
						14, 17));
		System.out
		.println(initialize(
				"daadabbadcabacbcccbdcccdbcccbbaadcbabbdaaaabbbdabdbbdcadaaacaadadacddabbbbbdcccbaabbbacacddbbbcbbdbd",
				76, 79));
	}

	public static long initialize(String s, int l, int r) {

		String substr = s.substring(l - 1, r);
		if (substr.length() == 1)
			return 1;
		String[] ar = substr.split("");
		Map<String, Integer> wordCountMap = new HashMap<>();
		for (String ch : ar)
			wordCountMap.put(ch, wordCountMap.getOrDefault(ch, 0) + 1);
		// if some chars are odd;
		long count1 = wordCountMap.values().stream()
				.filter(value -> value % 2 != 0).count();
		int mod = 1000000009;
		if (substr.length() == count1)
			return count1 % mod;
		long count2 = wordCountMap.values().stream()
				.filter(value -> value % 2 == 0).count();
		long resultCount = 0;
		if (count1 == 0 && count2 > 0) {// all chars are even
			resultCount = substr.length() / 2;
		} else if (count1 > 0 && count2 == 0) {// all are odd
			if (substr.length() % 2 == 0) {// even length,max palindrome would
											// be substr.length-1
				resultCount = 2;
			} else { // odd length,max palindrome would be substr.length-2
				resultCount = substr.length() - 2 > 3 ? (substr.length() - 3)
						: substr.length();
			}
		} else { // both even and odd;
			resultCount = count1;
		}
		return resultCount % mod;
	}
}
