package com.hackerrank.summationsandalgebra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Problem Statement

 James is very naive in Mathematics, He always makes new things out of a given list of integers. Today he is given a list L, so he creates a value S out of it.

 S from a given list can be calculated as follows.

 value_of_S(list L)
 {
 while ((number of elements in L) > 1)
 {
 a = L[0]
 b = L[1]
 delete L[1]
 L[0] = a+b+ab
 }
 return L[0] % 1000000007
 }
 James has an ample amount of time, so he calculates the values of S for all the permutations of the given list L and finds their average value. Then he asks you to report that value.

 Input Format 
 The first line contains an integer N, the number of integers in the list. 
 The second line contains N integral values, L[0],…,L[N−1], separated by single spaces.

 Output Format 
 Print the floor of the average value.

 Constraints 
 2≤N≤104 
 2≤L[i]≤106
 Sample Input

 2
 2 3
 Sample Output

 11
 Explanation 
 The S value corresponding to the two permutations of the given list is 11.
 */
/**
 * 
 * @author Shrey
 *
 */
public class TellTheAverage {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().trim().split(" ");
		BigInteger[] data = new BigInteger[n];
		for (int j = 0; j < n; j++) {
			data[j] = new BigInteger(line[j]);
		}
		BigInteger mod = new BigInteger("1000000007");
		int i = 1;
		while (n > 1) {
			data[0] = data[0].add(data[i]).add(data[0].multiply(data[i]));
			i++;
			n--;
		}
		System.out.println(data[0].mod(mod));
		br.close();
	}
}
