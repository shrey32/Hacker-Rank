package com.hackerrank.summationsandalgebra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 Given a triangle of numbers where each number is equal to the sum of the three numbers on top of it, find the first even number in a row.

 Explanatory Note: The vertex of the triangle (at the top) is 1. The structure of the triangle is shown below. Each number is equal to the sum of the numbers at the following positions: Position X: immediately above it. Position Y: to the immediate left of X. Position Z: to the immediate right of X. If there are no numbers at positions X, Y, or Z, then assume those positions are occupied by a zero (0). This can occur for positions at the edge. 

 Here are four rows of the triangle:

 1
 1   1  1
 1  2   3  2  1
 1  3  6   7  6  3  1
 Input Format and Constraints 
 First line contains a number T (number of test cases).
 Each of the next T lines contain a number N (the row number, assuming that the top vertex of the triangle is Row 1).

 Output Format 
 For each test case, display an integer that denotes the position of the first even number. 
 Note: Assume that the left most number in a row is Position 1.
 If there is no even number in a row, print -1.

 Constraints 
 1<=T<=100 
 3<=N<=1000000000

 Sample Input 
 2
 3
 4

 Sample Output 
 2
 3
 */

/**
 * 
 * @author Shrey
 *
 */
public class TriangleNumbers {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int ROW = Integer.parseInt(br.readLine());
			findPosition(ROW);
		}
		br.close();
	}

	private static void findPosition(int ROW) {
		if (ROW % 2 != 0) {
			System.out.println(2);
		} else {
			if ((ROW/2) % 2 == 0) {
				System.out.println(3);
			} else {
				System.out.println(4);
			}
		}
	}
}
