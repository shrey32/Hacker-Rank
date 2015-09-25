package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Problem Statement

 You are given two strings, A and B. Find if there is a substring that appears in both A and B.

 Input Format

 Several test cases will be given to you in a single file. The first line of the input will contain a single integer T, the number of test cases.

 Then there will be T descriptions of the test cases. Each description contains two lines. The first line contains the string A and the second line contains the string B.

 Output Format

 For each test case, display YES (in a newline), if there is a common substring. Otherwise, display NO.

 Constraints

 All the strings contain only lowercase Latin letters.
 1<=T<=10
 1<=|A|,|B|<=105
 Sample Input

 2
 hello
 world
 hi
 world
 Sample Output

 YES
 NO
 Explanation

 For the 1st test case, the letter o is common between both strings, hence the answer YES. 
 For the 2nd test case, hi and world do not have a common substring, hence the answer NO.
 */
/**
 * 
 * @author Shrey
 *
 */
public class TwoStrings {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		String a = "", b = "";
		for (int i = 0; i < t; i++) {
			a = br.readLine().trim();
			b = br.readLine().trim();
			boolean val = false;
			char[] c = b.toCharArray();
			Arrays.sort(c);
			for (int j = 0; j < a.length(); j++) {
				if (Arrays.binarySearch(c, a.charAt(j)) >= 0) {
					val = true;
					break;
				}
			}
			if (val)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		br.close();
	}

}
