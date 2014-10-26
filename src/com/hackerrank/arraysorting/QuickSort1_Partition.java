package com.hackerrank.arraysorting;

import java.util.Scanner;

/**The previous challenges covered Insertion Sort, which is a simple and intuitive sorting algorithm. Insertion Sort has a running time of O(N2) which isn't fast enough for most purposes. Instead, sorting in the real-world is done with faster algorithms like Quicksort, which will be covered in the challenges that follow.

 The first step of Quicksort is to partition an array into two smaller arrays.

 Challenge 
 You're given an array ar and a number p. Partition the array, so that, all elements greater than p are to its right, and all elements smaller than p are to its left.

 In the new sub-array, the relative positioning of elements should remain the same, i.e., if n1 was before n2 in the original array, it must remain before it in the sub-array. The only situation where this does not hold good is when p lies between n1 and n2

 i.e., n1 > p > n2.

 Guideline - In this challenge, you do not need to move around the numbers 'in-place'. This means you can create 2 lists and combine them at the end.

 Input Format 
 You will be given an array of integers. The number p is the first element in ar.

 There are 2 lines of input:

 n - the number of elements in the array ar
 the n elements of ar (including p at the beginning)
 Output Format 
 Print out the numbers of the partitioned array on one line.

 Constraints 
 1<=n<=1000 
 -1000<=x<= 1000 , x ∈ ar 
 All elements will be distinct

 Sample Input 
 5 
 4 5 3 7 2

 Sample Output 
 3 2 4 5 7

 Explanation 
 p = 4. The 5 was moved to the right of the 4, 2 was moved to the left of 4 and the 3 is also moved to the left of 4. The numbers otherwise remained in the same order.

 Task 
 Complete the method partition which takes an array ar. The first element in ar is the number p.*/

/**
 * @author Shrey
 *
 */
public class QuickSort1_Partition {
	private int array[];
	private int length;

	public void sort(int[] inputArr) {

		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.array = inputArr;
		length = inputArr.length;
		quickSort(0, length - 1);
	}

	private void quickSort(int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a
			 * number from right side which is less then the pivot value. Once
			 * the search is done, then we exchange both numbers.
			 */
			while (array[i] < pivot) {
				i++;
				count++;
			}
			while (array[j] > pivot) {
				j--;
				count--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				// move index to next position on both sides
				i++;
				j--;
				count++;
			}

		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(lowerIndex, j);
		if (i < higherIndex)
			quickSort(i, higherIndex);
	}

	private void exchangeNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
	}

	public static int count = 0;

	public static void main(String a[]) {

		QuickSort1_Partition sorter = new QuickSort1_Partition();
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = scan.nextInt();
		}
		sorter.sort(input);
		/*for (int i : input) {
			System.out.print(i);
			System.out.print(" ");
		}*/
		System.out.println(count);
		scan.close();
	}
}
