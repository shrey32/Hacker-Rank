package com.hackerrank.arraysorting;

import java.util.Scanner;

/**Watson gives an array A1,A2...AN to Sherlock. Then he asks him to find if there exists an element in the array, such that, the sum of elements on its left is equal to the sum of elements on its right. If there are no elements to left/right, then sum is considered to be zero. 
 Formally, find an i, such that, A1+A2...Ai-1 = Ai+1+Ai+2...AN.

 Input Format 
 The first line contains T, the number of test cases. For each test case, the first line contains N, the number of elements in the array A. The second line for each testcase contains N space separated integers, denoting the array A.

 Output Format 
 For each test case, print YES if there exists an element in the array, such that, the sum of elements on its left is equal to the sum of elements on its right, else print NO.

 Constraints 
 1 ≤ T ≤ 10 
 1 ≤ N ≤ 105 
 1 ≤ Ai ≤ 2*104 for 1 ≤ i ≤ N

 Sample Input

 2
 3
 1 2 3
 4
 1 2 3 3
 Sample Output

 NO
 YES
 Explanation 
 For test case 1, no such index exists. 
 For test case 2, A[1]+A[2]=A[4], therefore index 3 satisfies.*/

/**
 * @author Shrey
 *
 */
public class SherlockAndArray {

	/*
	 * public static void main(String[] args) { Scanner scan = new
	 * Scanner(System.in); int T = scan.nextInt();
	 * 
	 * for (int j = 0; j < T; j++) { List<Integer> arr = new
	 * ArrayList<Integer>(); int N = scan.nextInt(); for (int i = 0; i < N; i++)
	 * { arr.add(scan.nextInt()); } System.out.println(sherlockAndArray(arr)); }
	 * scan.close(); }
	 * 
	 * public static String sherlockAndArray(List<Integer> arr) { int sum1 = 0;
	 * for (int i = 0; i < arr.size(); i++) { int sum2 = 0; if (i > 0) { sum1 =
	 * sum1 + arr.get(i - 1); } if (i + 1 < arr.size()) { for (int j = i + 1; j
	 * < arr.size(); j++) { sum2 = sum2 + arr.get(j); } } if (sum1 == sum2) {
	 * return "YES"; } } return "NO"; }
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			String answer = "NO";
			int N = in.nextInt();

			int[] a = new int[N];
			int total = 0;
			for (int j = 0; j < N; j++) {
				a[j] = in.nextInt();
				total = total + a[j];
			}
			if (N == 1) {
				answer = "YES";
				System.out.println(answer);
				continue;
			}
			if (N == 2) {
				System.out.println(answer);
				continue;
			}
			int left = 0;
			int right = total;
			for (int j = 1; j < N - 1; j++) {
				left = left + a[j - 1];
				right = total - a[j] - left;
				if (left == right) {
					answer = "YES";
					break;
				}
			}
			System.out.println(answer);
		}
		in.close();
	}
}
