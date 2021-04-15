package com.crackingthecodinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Consider the following version of Bubble Sort:

 for (int i = 0; i < n; i++) {
 // Track number of elements swapped during a single array traversal
 int numberOfSwaps = 0;

 for (int j = 0; j < n - 1; j++) {
 // Swap adjacent elements if they are in decreasing order
 if (a[j] > a[j + 1]) {
 swap(a[j], a[j + 1]);
 numberOfSwaps++;
 }
 }

 // If no elements were swapped during a traversal, array is sorted
 if (numberOfSwaps == 0) {
 break;
 }
 }
 Task 
 Given an -element array, , of distinct elements, sort array  in ascending order using the Bubble Sort algorithm above. Once sorted, print the following three lines:

 Array is sorted in numSwaps swaps., where  is the number of swaps that took place.
 First Element: firstElement, where  is the first element in the sorted array.
 Last Element: lastElement, where  is the last element in the sorted array.
 Hint: To complete this challenge, you must add a variable that keeps a running tally of all swaps that occur during execution.

 Input Format

 The first line contains an integer, , denoting the number of elements in array . 
 The second line contains  space-separated integers describing the respective values of .

 Constraints

 , 
 Output Format

 You must print the following three lines of output:

 Array is sorted in numSwaps swaps., where  is the number of swaps that took place.
 First Element: firstElement, where  is the first element in the sorted array.
 Last Element: lastElement, where  is the last element in the sorted array.
 Sample Input 0

 3
 1 2 3
 Sample Output 0

 Array is sorted in 0 swaps.
 First Element: 1
 Last Element: 3
 Explanation 0 
 The array is already sorted, so  swaps take place and we print the necessary three lines of output shown above.

 Sample Input 1

 3
 3 2 1
 Sample Output 1

 Array is sorted in 3 swaps.
 First Element: 1
 Last Element: 3
 Explanation 1 
 The array is not sorted, and its initial values are: . The following  swaps take place:

 At this point the array is sorted and we print the necessary three lines of output shown above.
 */
/**
 * 
 * @author Shrey
 *
 */
public class SortingBubbleSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[n];
		String line = br.readLine().trim();
		br.close();
		int i = 0;
		for (String s : line.split(" "))
			arr[i++] = Integer.parseInt(s);
		int numOfSwaps = 0;
		for (i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					numOfSwaps++;
				}
			}
		}
		System.out.println("Array is sorted in " + numOfSwaps + " swaps.");
		System.out.println("First Element: " + arr[0]);
		System.out.println("Last Element: " + arr[n - 1]);
	}

}
