package com.hackerrank.warmup;

import java.util.Scanner;

/**Problem Statement 
You are given a number N, you need to print the number of positions where digits exactly divides N.

Input format

The first line contains T (number of test cases followed by T lines each containing N).

Constraints 
1 <=T <= 15 
0 < N < 1010

Output Format 
For each test case print the number of positions in N where digits in that number exactly divides the number N in separate line.

Input

1  
12
Output

2
Explanation 
2 digits in the number 12 divide the number exactly. Digits at ten's place, 1, divides 12 exactly in 12 parts, and digit at one's place, 2 divides 12 equally in 6 parts.
*/
public class FindDigits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int N = scan.nextInt();
			String s = String.valueOf(N);
			int count = 0;
			char[] c = s.toCharArray();
			for (int j = 0; j < c.length; j++) {
				int a = Integer.parseInt(String.valueOf(c[j]));

				if (a > 0) {
					int ab = N % a;
					if (ab == 0) {
						count++;
					}

				}

			}
			System.out.println(count);
		}
		scan.close();
	}
}
