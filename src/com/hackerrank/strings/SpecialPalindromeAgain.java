package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A string is said to be a special palindromic string if either of two conditions is met:

 All of the characters are the same, e.g. aaa.
 All characters except the middle one are the same, e.g. aadaa.
 A special palindromic substring is any substring of a string which meets one of those criteria. Given a string, determine how many special palindromic substrings can be formed from it.

 For example, given the string , we have the following special palindromic substrings: .

 Function Description

 Complete the substrCount function in the editor below. It should return an integer representing the number of special palindromic substrings that can be formed from the given string.

 substrCount has the following parameter(s):

 n: an integer, the length of string s
 s: a string
 Input Format

 The first line contains an integer, , the length of . 
 The second line contains the string .

 Constraints


 Each character of the string is a lowercase alphabet, .

 Output Format

 Print a single line containing the count of total special palindromic substrings.

 Sample Input 0

 5
 asasd
 Sample Output 0

 7 
 Explanation 0

 The special palindromic substrings of  are 

 Sample Input 1

 7
 abcbaba
 Sample Output 1

 10 
 Explanation 1

 The special palindromic substrings of  are 

 Sample Input 2

 4
 aaaa
 Sample Output 2

 10
 Explanation 2

 The special palindromic substrings of  are 
 */
/**
 * 
 * @author Shrey
 *
 */
public class SpecialPalindromeAgain {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String s = br.readLine().trim();
		System.out.println(count(n, s));
	}

	private static int count(int n, String s) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				StringBuilder pri = new StringBuilder(s.substring(i, j));
				if (pri.toString().equals(pri.reverse().toString())) {
					int subLen = pri.length();
					int add = pri.length() % 2 == 0 ? 0 : 1;
					if (subLen == 2
							|| pri.toString()
									.substring(0, subLen / 2)
									.equals(pri.toString().substring(
											subLen / 2 + add, subLen))) {
						count++;
					}
				}
			}
		}
		return count + n;
	}

	static boolean findNumber(List<Integer> arr, int k) {
		Set<Integer> set = new HashSet<Integer>(arr);
		return set.contains(k);
	}

}
