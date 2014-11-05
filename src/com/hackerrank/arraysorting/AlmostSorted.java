package com.hackerrank.arraysorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**Given an array with n elements, can you sort this array in ascending order using just one of the following operations? You can perform only one of the following operations: 
 1. Swap two elements. 
 2. Reverse one sub-segment

 Input Format 
 The first line contains a single integer n, which indicates the size of the array. The next line contains n integers seperated by spaces.

 n  
 d1 d2 ... dn  
 Constraints

 2 <= n <= 100000 
 0 <= di <= 1000000

 All di are distinct.

 Output Format

 If the array is already sorted, output 'yes' in the first line. You do not need to output anything else.

 If you can sort this array using one single operation (from the two permitted operations):

 a. If you can sort the array by swap dl and dr, output "swap l r" in the second line. l and r are the indices of the elements to be swapped, assuming that the array is indexed from 1 to n.

 b. Else if it is possible to sort the array by reversing the segment d[l...r], output "reverse l r" in the second line. l and r are the indices of the first and last elements of the subsequence to be reversed, assuming that the array is indexed from 1 to n.

 d[l...r] represents the sub-sequence of the array, beginning at index l and ending at index r; inclusive of both.

 If an array can be sorted by either swapping or reversing, stick to the swap based method.

 If you cannot sort the array in either of the above ways, output "no" in the first line.

 Sample Input #1

 2  
 4 2  
 Sample Output #1

 yes  
 swap 1 2
 Sample Input #2

 3
 3 1 2
 Sample Output #2

 no
 Sample Input #3

 6
 1 5 4 3 2 6
 Sample Output #3

 yes
 reverse 2 5
 Explanation

 For #1: You can both swap(1, 2) and reverse(1, 2), but if you can sort the array but swap, output swap only. 
 For #2: It is impossible to sort by one single operation (among those permitted). 
 For #3, You can reverse the sub-array d[2...5] = "5 4 3 2" then the array become sorted.*/
/**
 * @author Shrey
 *
 */
public class AlmostSorted {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		int[] brr = Arrays.copyOf(arr, N);
		Arrays.sort(brr);
		HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++)
			mp.put(brr[i], i);
		for (int i = 0; i < N; i++) {
			arr[i] = mp.get(arr[i]);
		}

		int outofpos = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] != i)
				outofpos++;
		}

		if (outofpos == 0) {
			System.out.println("yes");
			System.out.close();
			System.exit(0);
		} else if (outofpos == 2) {
			System.out.println("yes");
			System.out.print("swap");
			for (int i = 0; i < N; i++) {
				if (arr[i] != i)
					System.out.print(" " + (i + 1));
			}
			System.out.println();
			System.out.close();
			System.exit(0);
		} else {
			int s = -1, e = -1;
			for (int i = 0; i < N; i++) {
				if (arr[i] != i) {
					e = i;
					if (s == -1)
						s = i;
				}
			}
			for (int i = s, j = e; i < j; i++, j--) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
			for (int i = 0; i < N; i++) {
				if (arr[i] != i) {
					System.out.println("no");
					System.out.close();
					System.exit(0);
				}
			}

			System.out.println("yes");
			System.out.printf("reverse %d %d\n", s + 1, e + 1);
			System.out.close();
			System.exit(0);
		}
		System.out.close();
		System.exit(0);
		scan.close();
	}

}
