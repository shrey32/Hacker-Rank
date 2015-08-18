package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 You are given an array of integers of size . You need to print the sum of the elements of the array.

 Input Format 
 The first line of the input consists of an integer . The next line contains  space-separated integers describing the array.

 Constraints 



 Output Format 
 Output a single value equal to the sum of the elements of the array.

 Sample Input

 6
 1 2 3 4 10 11
 Sample Output

 31
 Explanation 

 */
/**
 * 
 * @author Shrey
 *
 */
public class SimpleArraySum {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String line = br.readLine();
		int sum = 0;
		for (String s : line.split(" ")) {
			sum += Integer.valueOf(s);
		}
		System.out.println(sum);
	}

}
