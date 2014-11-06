package com.hackerrank.arraysorting;

import java.util.Scanner;

/**Insertion Sort is a simple sorting technique which was covered in previous challenges. Sometimes, arrays may be too large for us to wait around for insertion sort to finish. Is there some other way we can calculate the number of times Insertion Sort shifts each elements when sorting an array?

 If ki is the number of elements over which ith element of the array has to shift then total number of shift will be k1 + k2 + ... + kN.

 Input: 
 The first line contains the number of test cases T. T test cases follow. The first line for each case contains N, the number of elements to be sorted. The next line contains N integers a[1],a[2]...,a[N].

 Output: 
 Output T lines, containing the required answer for each test case.

 Constraints: 
 1 <= T <= 5 
 1 <= N <= 100000 
 1 <= a[i] <= 1000000

 Sample Input:

 2  
 5  
 1 1 1 2 2  
 5  
 2 1 3 1 2
 Sample Output:

 0  
 4   
 Explanation 
 First test case is already sorted, therefore there's no need to shift any element. In second case, it will proceed in the following way.

 Array: 2 1 3 1 2 -> 1 2 3 1 2 -> 1 1 2 3 2 -> 1 1 2 2 3
 Moves:   -        1       -    2         -  1            = 4*/

/**
 * @author Shrey
 *
 */
public class InsertionSortAdvancedAnalysis {

	private static long inversions = 0l;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int N = scan.nextInt();
			int[] ar = new int[N];
			for (int j = 0; j < N; j++) {
				ar[j] = scan.nextInt();
			}
			getInversions(ar, 0, ar.length - 1);
			System.out.println(inversions);
			inversions=0;
		}
		scan.close();
	}

	
	public static void getInversions(int[] nums, int left, int right) {
		if (left < right) {
			// Split in half
			int mid = (left + right) / 2;
			// Sort recursively.
			getInversions(nums, left, mid);
			getInversions(nums, mid + 1, right);
			// Merge the two sorted sub arrays.
			merge(nums, left, mid, right);
		}
	}

	private static void merge(int[] nums, int left, int mid, int right) {
		int leftLength = mid - left + 1;
		int rightLength = right - mid;
		int[] lAr = new int[leftLength];
		// Just for simplicity, we are creating this right array.
		// We can use actual nums array with mid and right indexes.
		int[] rAr = new int[rightLength];
		for (int i = 0; i < leftLength; i++) {
			lAr[i] = nums[left + i];
		}
		for (int i = 0; i < rightLength; i++) {
			rAr[i] = nums[mid + 1 + i];
		}
		int i = 0, j = 0, k = left;
		while (i < leftLength && j < rightLength) {
			if (lAr[i] <= rAr[j]) {
				nums[k] = lAr[i];
				inversions += j;
				i++;
			} else {
				nums[k] = rAr[j];
				j++;
			}
			k++;
		}
		// remaining inversions
		inversions += (long) j * (leftLength - i);
		if (i >= leftLength) {
			// copy remaining elements from right
			for (; j < rightLength; j++, k++) {
				nums[k] = rAr[j];
			}
		} else {
			// copy remaining elements from left
			for (; i < leftLength; i++, k++) {
				nums[k] = lAr[i];
			}
		}
	}

}
