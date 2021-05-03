package com.crackingthecodinginterview;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 7, 3, 7, 9, 4, 8, 6, 1, 4, 8, 5, 9 };
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr) {
		int[] aux = new int[arr.length];
		mergeSort(arr, aux, 0, aux.length - 1);
	}

	public static void mergeSort(int[] arr, int[] aux, int lo, int hi) {
		if (lo < hi) {
			int mid = (lo + hi) / 2;
			mergeSort(arr, aux, lo, mid);// sort left half
			mergeSort(arr, aux, mid + 1, hi);// sort right half
			sort(arr, aux, lo, mid, hi);// merge
		}
	}

	public static void sort(int[] arr, int[] aux, int lo, int mid, int hi) {
		// populate auxillary array
		for (int i = lo; i <= hi; i++)
			aux[i] = arr[i];
		int left = lo;
		int right = mid + 1;
		int current = lo;

		while (left <= mid && right <= hi) {
			if (aux[left] <= aux[right]) {
				arr[current] = aux[left];
				left++;
			} else {// if right is smaller than left
				arr[current] = aux[right];
				right++;
			}
			current++;
		}

		int rem = mid - left;
		for (int i = 0; i <= rem; i++) {
			arr[current + i] = aux[left + i];
		}

	}

}
