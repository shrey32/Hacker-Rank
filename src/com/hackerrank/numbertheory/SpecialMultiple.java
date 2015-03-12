package com.hackerrank.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 You are given an integer N. Can you find the least positive integer X made up of only 9's and 0's, such that, X is a multiple of N?

 Update

 X is made up of one or more occurences of 9 and zero or more occurences of 0.

 Input Format 
 The first line contains an integer T which denotes the number of test cases. T lines follow. 
 Each line contains the integer N for which the solution has to be found.

 Output Format 
 Print the answer X to STDOUT corresponding to each test case. The output should not contain any leading zeroes.

 Constraints 
 1 <= T <= 104 
 1 <= N <= 500

 Sample Input

 3
 5
 7
 1
 Sample Output

 90
 9009
 9
 Explanation 
 90 is the smallest number made up of 9's and 0's divisible by 5. Similarly, you can derive for other cases.

 Timelimits Timelimits for this challenge is given here
 */
/**
 * 
 * @author Shrey
 *
 */
public class SpecialMultiple {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] series = new long[10000000];
		series[1] = 9;
		int offset = 1;
		long base = series[1];
		int lastAllNines = 1;

		for (int i = 2; i < series.length; i++) {
			if (offset == lastAllNines) {
				series[i] = (series[i - 1] + 1) * 9;
				base = series[i];
				offset = 0;
				lastAllNines = i - 1;
			} else {
				series[i] = base + series[1 + offset++];
			}
		}
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			int N = Integer.parseInt(br.readLine());
			for (long l : series) {
				if (l != 0 && l % N == 0) {
					System.out.println(l);
					break;
				}
			}
			T--;
		}
	}
}
