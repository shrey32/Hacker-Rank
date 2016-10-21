package com.hackerrank.crackingcodinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Fibonacci Sequence 
 The Fibonacci sequence begins with  and  as its respective first and second terms. After these first two elements, each subsequent element is equal to the sum of the previous two elements.

 Here is the basic information you need to calculate :

 Task 
 Given , complete the fibonacci function so it returns .

 Input Format

 Locked stub code in the editor reads a single integer denoting the value of  and passes it to the fibonacci function.

 Constraints

 Output Format

 Locked stub code in the editor prints the value of  returned by the fibonacci function.

 Sample Input

 3  
 Sample Output

 2
 Explanation

 Consider the Fibonacci sequence:








 ...

 We want to know the value of . If we look at the sequence above,  evaluates to . Thus, we print  as our answer.
 */
/**
 * 
 * @author Shrey
 *
 */
public class RecursionFibonacciNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		System.out.println(fabonacci(n));
		br.close();
	}

	private static int fabonacci(int n) {
		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}
}
