package com.hackerrank.search;

import java.util.Arrays;
import java.util.Scanner;

/**In the Quicksort challenges, you sorted an entire array. Sometimes, you just need specific information about a list of numbers, and doing a full sort would be unnecessary. Can you figure out a way to use your partition code to find the median in an array?

 Challenge 
 Given a list of numbers, can you find the median?

 Input Format 
 There will be two lines of input:

 n - the size of the array
 ar - n numbers that makes up the array
 Output Format 
 Output one integer, the median.

 Constraints 
 1<= n <= 1000001 
 -10000 <= x <= 10000 , x ∈ ar 
 There will be an odd number of elements.

 Sample Input

 7
 0 1 2 4 6 5 3
 Sample Output

 3*/

/**
 * @author Shrey
 *
 */
public class FindTheMedian {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] a = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			a[i] = scan.nextInt();
			if (a[i] > sum) {
			}
		}
		Arrays.sort(a);

		int median = (a.length - 1) / 2;

		System.out.println(a[median]);
		
		scan.close();
	}

	public static int search(int[] a, int num) {
		int lo = 0;
		int hi = a.length - 1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;

			if (num < a[mid]) {
				hi = mid - 1;
			} else if (num > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
