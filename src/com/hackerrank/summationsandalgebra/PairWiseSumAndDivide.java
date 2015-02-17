package com.hackerrank.summationsandalgebra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are given an array of numbers. Let us denote the array with A[]. Your task is very simple. You need to find the value returned by the function fun(A).

 fun(A)
 sum = 0
 for i = 1 to A.length
 for j = i+1 to A.length
 sum = sum + Floor((A[i]+A[j])/(A[i]*A[j])) 
 return sum
 In short, this function takes all distinct pairs of indexes from the array and adds the value ⌊A[i]+A[j]A[i]×A[j]⌋ to the sum. Your task is to find the sum.

 Note: ⌊AB⌋ is the integer division function.

 Input Format 
 The first line contains T, the number of test cases to follow.

 Each test case contains two lines: the first line contains N, the size of the array, and the second line contains N integers separated by spaces.

 Output Format 
 The output should contain exactly T lines where the ith line contains the answer for the ith test case.

 Constraints 
 1≤T≤15 
 1≤N≤2×105 
 1≤Sum of N over all test cases ≤2×105 
 1≤A[i]≤109

 Sample Input

 2
 3
 4 2 3
 3
 1 4 1
 Sample Output

 0
 4
 Explanation 
 First Test Case: ⌊68⌋+⌊712⌋+⌊56⌋=0 
 Second Test Case: ⌊54⌋+⌊21⌋+⌊54⌋=4
 */
/**
 * 
 * @author Shrey
 *
 */
public class PairWiseSumAndDivide {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			int n = Integer.parseInt(br.readLine());
			String line = br.readLine();
			String[] ar = line.split(" ");
			int[] a = new int[n];
			long ones = 0, twos = 0;
			for (int i = 0; i < ar.length; i++) {
				a[i] = Integer.parseInt(ar[i]);
				if (a[i] == 1) {
					ones++;
				}
				if (a[i] == 2) {
					twos++;
				}
			}
			long sol = ones * (ones - 1) + ones * (n - ones);
			sol += (twos - 1) * twos / 2;
			System.out.println(sol);
			T--;
		}
		br.close();
	}

	
}
