package com.hackerrank.datastructures.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 You are given a 2D array with dimensions 6*6. An hourglass in an array is defined as a portion shaped like this:

 a b c
 d
 e f g
 For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:

 1 1 1 0 0 0
 0 1 0 0 0 0
 1 1 1 0 0 0
 0 0 0 0 0 0
 0 0 0 0 0 0
 0 0 0 0 0 0
 Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:

 1 1 1     1 1 0     1 0 0
 1         0         0
 1 1 1     1 1 0     1 0 0
 The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.

 In this problem, you have to print the largest sum among all the hourglasses in the array.

 Note: If you have already solved the problem "Java 2D array" in the data structures chapter of the Java domain, you may skip this challenge.

 Input Format

 There will be exactly 6 lines of input, each containing 6 integers separated by spaces. Each integer will be between -9 and 9, inclusively.

 Output Format

 Print the answer to this problem on a single line.

 Sample Input

 1 1 1 0 0 0
 0 1 0 0 0 0
 1 1 1 0 0 0
 0 0 2 4 4 0
 0 0 0 2 0 0
 0 0 1 2 4 0
 Sample Output

 19

 Explanation

 The hourglass possessing the largest sum is:

 2 4 4
 2
 1 2 4
 */
/**
 * 
 * @author Shrey
 *
 */
public class TwoDArrayDS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 6;
		String line = "";
		int[][] s = new int[n][n];
		int i = 0;
		while (i < n) {
			line = br.readLine().trim();
			String[] v = line.split(" ");
			for (int j = 0; j < v.length; j++) {
				s[i][j] = Integer.parseInt(v[j].trim());
			}
			i++;
		}
		solution(s, n);
		br.close();
	}

	private static void solution(int[][] s, int n) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < n - 2; j++) {
				int temp = s[i][j] + s[i][j + 1] + s[i][j + 2]
						+ s[i + 1][j + 1] + s[i + 2][j] + s[i + 2][j + 1]
						+ s[i + 2][j + 2];
				if (temp > max)
					max = temp;
			}
		}
		System.out.println(max);
	}

}
