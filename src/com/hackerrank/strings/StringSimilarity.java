package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * For two strings A and B, we define the similarity of the strings to be the length of the longest prefix common to both strings. For example, the similarity of strings "abc" and "abd" is 2, while the similarity of strings "aaa" and "aaab" is 3.

 Calculate the sum of similarities of a string S with each of it's suffixes.

 Input: 
 The first line contains the number of test cases T. Each of the next T lines contains a string each.

 Output: 
 Output T lines containing the answer for the corresponding test case.

 Constraints: 
 1 <= T <= 10 
 The length of each string is at most 100000 and contains only lower case characters.

 Sample Input:

 2
 ababaa  
 aa
 Sample Output:

 11  
 3
 Explanation: 
 For the first case, the suffixes of the string are "ababaa", "babaa", "abaa", "baa", "aa" and "a". The similarities of these strings with the string "ababaa" are 6,0,3,0,1, & 1 respectively. Thus, the answer is 6 + 0 + 3 + 0 + 1 + 1 = 11.

 For the second case, the answer is 2 + 1 = 3.
 */

/**
 * 
 * @author Shrey
 *
 */
public class StringSimilarity {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String a = br.readLine();
			System.out.println(stringSimilarity(a));
		}
		br.close();
	}

	/**
	 * algorithm is taking quadratic time(O(n^2)), it should run in linear time
	 * (O(n))
	 * 
	 * @param a
	 * @return
	 */
	private static int stringSimilarity(String a) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			String s = a.substring(i, a.length());
			if (i == 0) {
				count += a.length();
			} else {
				int j = 0;
				while (j < s.length() && a.charAt(j) == s.charAt(j)) {
					count++;
					j++;
				}
			}
		}
		return count;
	}
}
