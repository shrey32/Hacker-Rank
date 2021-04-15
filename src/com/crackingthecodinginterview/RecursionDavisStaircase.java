package com.crackingthecodinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Davis has  staircases in his house and he likes to climb each staircase , , or  steps at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.

 Given the respective heights for each of the  staircases in his house, find and print the number of ways he can climb each staircase on a new line.

 Input Format

 The first line contains a single integer, , denoting the number of staircases in his house. 
 Each line  of the  subsequent lines contains a single integer, , denoting the height of staircase .

 Constraints

 Subtasks

 for  of the maximum score.
 Output Format

 For each staircase, print the number of ways Davis can climb it in a new line.

 Sample Input

 3
 1
 3
 7
 Sample Output

 1
 4
 44
 Explanation

 Let's calculate the number of ways of climbing the first two of the Davis'  staircases:

 The first staircase only has  step, so there is only one way for him to climb it (i.e., by jumping  step). Thus, we print  on a new line.
 The second staircase has  steps and he can climb it in any of the four following ways: 
 Thus, we print  on a new line.
 */
/**
 * 
 * @author Shrey
 *
 */
public class RecursionDavisStaircase {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			System.out.println(stairCase(n,""));
		}
		br.close();
	}

	public static int stairCase(int n) {
		if (n == 1 || n == 0)
			return 1;
		else if (n == 2)
			return 2;
		else if (n == 3)
			return 4;
		else {
			return stairCase(n - 1) + stairCase(n - 2) + stairCase(n - 3);
		}
	}

	public static int stairCase(int n, String s) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int f1 = 1;
		int f2 = 2;
		int f3 = 4;
		int f = f3;
		for (int i = 3; i < n; ++i) {
			f = f1 + f2 + f3;
			f1 = f2;
			f2 = f3;
			f3 = f;
		}
		return f;
	}

}
