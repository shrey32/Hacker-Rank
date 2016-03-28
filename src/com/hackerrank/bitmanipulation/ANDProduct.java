package com.hackerrank.bitmanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You will be given two integers AA and BB. You are required to compute the bitwise AND amongst all natural numbers lying between AA and BB, both inclusive.

 Input Format

 First line of the input contains T, the number of testcases to follow. 
 Each testcase in a newline contains A and B separated by a single space.

 Constraints

 1≤T≤2001≤T≤200 
 0≤A≤B<2320≤A≤B<232
 Output Format

 Output one line per test case with the required bitwise AND.

 Sample Input

 3 
 12 15 
 2 3 
 8 13
 Sample Output

 12 
 2 
 8
 Explanation

 For the first testcase,

 12 & 13 & 14 & 15 = 12
 For second testcase,

 2 & 3 = 2
 For the third testcase,

 8 & 9 & 10 & 11 & 12 & 13 = 8*/
/**
 * 
 * @author Shrey
 *
 */
public class ANDProduct {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String[] num = null;
		for (int i = 0; i < n; i++) {
			num = br.readLine().trim().split(" ");
			long a = Long.parseLong(num[0]);
			long b = Long.parseLong(num[1]);
			andProduct(a, b);
		}
		br.close();
	}

	private static void andProduct(long a, long b) {
		for (long i = a + 1; i <= b; i++) {
			a = a & i;
		}
		System.out.println(a);
	}

}
