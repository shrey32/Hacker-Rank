package com.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 You are given an array of size N and another integer M. Your target is to find the maximum value of sum of subarray modulo M.

 Subarray is a continous subset of array elements.

 Note that we need to find the maximum value of (Sum of Subarray)%M , where there are N∗(N+1)/2 possible subarrays.

 Input Format 
 First line contains T , number of test cases to follow. Each test case consists of exactly 2 lines. First line of each test case contain 2 space separated integers N and M, size of the array and modulo value M. 
 Second line contains N space separated integers representing the elements of the array.

 Output Format 
 For every test case output the maximum value asked above in a newline.

 Constraints 
 2 ≤ N ≤ 105 
 1 ≤ M ≤ 1014 
 1 ≤ elements of the array ≤ 1018 
 2 ≤ Sum of N over all test cases ≤ 500000

 Sample Input

 1
 5 7
 3 3 9 9 5
 Sample Output

 6
 Explanation

 Max Possible Sum taking Modulo 7 is 6 , and we can get 6 by adding first and second element of the array
 */
/**
 * 
 * @author shrey.sharma
 *
 */
public class MaximiseSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		String line = "";
		while (t > 0) {
			line = br.readLine().trim();
			long n = Long.parseLong(line.split(" ")[0].trim());
			long m = Long.parseLong(line.split(" ")[1].trim());
			String a[] = br.readLine().split(" ");
			long[] s = new long[a.length];
			for (int i = 0; i < n; i++) {
				s[i] = Long.parseLong(a[i]);
			}
			maximizeSum(n, m, s);
			t--;
		}
		br.close();
	}

	private static void maximizeSum(long n, long m, long... s) {
		long curr = 0;
		long prefix[] = new long[s.length];
		for (int i = 0; i < n; i++) {
			curr = (s[i] % m + curr) % m;
			prefix[i] = curr;
		}
		curr = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				curr = Math.max(curr, (prefix[i] - prefix[j] + m) % m);
			}
			curr = Math.max(curr, prefix[i]);
		}
		System.out.println(curr);
	}
}
