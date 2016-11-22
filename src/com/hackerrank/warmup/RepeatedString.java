package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Lilah has a string, , of lowercase English letters that she repeated infinitely many times.

 Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.

 Input Format

 The first line contains a single string, . 
 The second line contains an integer, .

 Constraints

 For  of the test cases, .
 Output Format

 Print a single integer denoting the number of letter a's in the first  letters of the infinite string created by repeating  infinitely many times.

 Sample Input 0

 aba
 10
 Sample Output 0

 7
 Explanation 0 
 The first  letters of the infinite string are abaabaabaa. Because there are  a's, we print  on a new line.

 Sample Input 1

 a
 1000000000000
 Sample Output 1

 1000000000000
 Explanation 1 
 Because all of the first  letters of the infinite string are a, we print  on a new line.
 */
/**
 * 
 * @author Shrey
 *
 */
public class RepeatedString {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		Long n = Long.parseLong(br.readLine().trim());
		br.close();
		System.out.println(repeatedString(line, n));
	}

	private static long repeatedString(String line, long n) {
		long acount = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == 'a')
				acount++;
		}
		long grp = n / line.length();
		long rem = n % line.length();
		acount = grp * acount;
		for (int i = 0; i < rem; i++) {
			if (line.charAt(i) == 'a')
				acount++;
		}
		return acount;
	}
}
