package com.hackerrank.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 Download Pdf version

 Watson gives an integer N to Sherlock and asks him: What is the number of divisors of N that are divisible by 2?.

 Input Format 
 First line contains T, the number of testcases. This is followed by T lines each containing an integer N.

 Output Format 
 For each testcase, print the required answer in one line.

 Constraints 
 1≤T≤100 
 1≤N≤109

 Sample Input

 2
 9
 8
 Sample Output

 0
 3
 Explanation 
 9 has three divisors 1, 3 and 9 none of which is divisible by 2. 
 8 has four divisors 1,2,4 and 8, out of which three are divisible by 2.
 */
/**
 * 
 * @author Shrey
 *
 */
public class SherlockAndDivisors {

	public static void main(String[] args) throws NumberFormatException, IOException {			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(divisors(num));
			T--;
		}
	}

	static int divisors(int n) {
		int count = 0;
		if (n % 2 == 0)
			count++;
		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0 && i % 2 == 0)
				count++;
			if (n % (n / i) == 0 && ((n / i) != i) && ((n / i) % 2 == 0))
				count++;
		}
		return count;
	}

}
