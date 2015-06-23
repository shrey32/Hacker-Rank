package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 You are given a square matrix of size N×N. Calculate the absolute difference of the sums across the two main diagonals.

 Input Format

 The first line contains a single integer N. The next N lines contain N integers describing the matrix.

 Constraints 
 1≤N≤100 
 −100≤A[i]≤100
 Output Format

 Output a single integer equal to the absolute difference in the the sums across the diagonals.

 Sample Input

 3
 11 2 4
 4 5 6
 10 8 -12
 Sample Output

 15
 Explanation

 The first diagonal of the matrix is:

 11
 5
 -12
 Sum across the first diagonal = 11+5-12= 4

 The second diagonal of the matrix is:

 4
 5
 10
 Sum across the second diagonal = 4+5+10 = 19 
 Difference: |4-19| =15
 */
/**
 * 
 * @author Shrey
 *
 */
public class DiagonalDifference {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum1 = 0, sum2 = 0;
		int pointer = 0, pointer2 = N - 1;
		for (int i = 0; i < N; i++) {
			String[] a = br.readLine().split(" ");
			// left diagonal
			sum1 += Integer.parseInt(a[pointer++]);
			// right diagonal
			sum2 += Integer.parseInt(a[pointer2--]);
		}
		System.out.println(Math.abs(sum1 - sum2));
	}

}
