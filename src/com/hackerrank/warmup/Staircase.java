package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Your teacher has given you the task to draw the structure of a staircase. Being an expert programmer, you decided to make a program for the same. You are given the height of the staircase. You need to print a staircase as shown in the example.

 Input Format

 You are given an integer N depicting the height of the staircase.

 Constraints 
 1≤N≤100
 Output Format

 Draw a staircase of height N in the format given below.

 For example:

 #
 ##
 ###
 ####
 #####
 ######
 Staircase of height 6, note that last line has 0 spaces before it.

 Sample Input

 6
 Sample Output

 #
 ##
 ###
 ####
 #####
 ######
 */
/**
 * 
 * @author Shrey
 *
 */
public class Staircase {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		for (int i = 1; i <= n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}

}
