package com.hackerrank.probability;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement



 Watson gave a string S to Sherlock. It is N characters long and consists of only 1s and 0s. Now he asks: Given an integer K, I'll pick two indices i and j at random between 1 and N, both inclusive. What's the probability that both S[i] and S[j] are 1 and |i−j|≤K?

 Input Format 
 First line contains T, the number of testcases. Each testcase consists of N(the length of S) and K in one line and string in second line.

 Output Format 
 Print the required probability as an irreducible fraction. If required answer is 0, output 0/1.

 Constraints 
 1≤T≤105 
 1≤N≤105 
 1≤K≤N 
 1≤Sum of N over all testcases in one file≤105

 Sample input

 2
 4 3
 1011
 4 1
 1011
 Sample output

 9/16
 5/16
 Explanation 
 test1: Out of 16 choices, 9 pairs of (i,j) satisfy our condition. 
 test2: Out of 16 choices, 5 pairs of (i,j) satisfy our condition.
 */

/**
 * 
 * @author Shrey
 *
 */
public class SherlockAndProbability {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int a = 0; a < T; a++) {
			String line = br.readLine();
			int N = Integer.parseInt(line.split(" ")[0]);
			int K = Integer.parseInt(line.split(" ")[1]);
			String bin = br.readLine();
			probability(K, bin, N * N);
		}
	}

	private static void probability(int K, String bin, long val) {
		char[] array = bin.toCharArray();
		long count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (Integer.parseInt(String.valueOf(array[i])) == 1 && Integer.parseInt(String.valueOf(array[j])) == 1
						&& Math.abs(i - j) <= K) {
					count++;
				}
			}
		}
		 final long factor = gcd(count, val);
		 count /= factor;
		 val /= factor;
		System.out.println(count + "/" + val);
	}
	
	
	private static long gcd(long a, long b){
        while (b != 0){
            long c = a;
            a = b;
            b = c%b;
        }
        return a;
    }
}
