package com.hackerrank.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

public class NewYearChaos {

	public static void main(String[] args) {
		minimumBribes(new int[] { 2, 1, 5, 3, 4 });// 2
		minimumBribes(new int[] { 2, 5, 1, 3, 4 });// Too Chaotic
		minimumBribes(new int[] { 5, 1, 2, 3, 7, 8, 6, 4 });// Too Chaotic
		minimumBribes(new int[] { 1, 2, 5, 3, 7, 8, 6, 4 });// 3
	}

	static void minimumBribes(int[] arr) {
		Map<Integer, Integer> bribes = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int index = getMinElementIndex(arr, arr[i], i + 1);
			if (index >= 0) {
				int left = arr[index];
				arr[index] = arr[i];
				arr[i] = left;
				bribes.put(arr[index], bribes.getOrDefault(arr[index], 0) + 1);
				if (bribes.get(arr[index]) > 2) {
					System.out.println("Too chaotic");
					return;
				}
			}
		}
		System.out.println(bribes.size());
	}

	static int getMinElementIndex(int[] a, int item, int start) {
		int min = item;
		int index = -1;
		for (int i = start; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
				index = i;
			}
		}
		return index;
	}

}
