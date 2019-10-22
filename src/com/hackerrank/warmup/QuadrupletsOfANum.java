package com.hackerrank.warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class QuadrupletsOfANum {

	public static void main(String[] args) {
		int[] arr = { 1, 7, 4, 0, 9, 5, 1, 3 };// 01134579
		int x = 20;
		System.out.println(Arrays.toString(findFourNumbersSumTo(arr, x)));
	}

	static Integer[] findTwoNumbersSumTo(int[] arr, int x) {
		Integer result[] = new Integer[2];
		Set<Integer> comps = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (comps.contains(arr[i])) {
				result[0] = arr[i];
				result[1] = x - arr[i];
			}
			comps.add(x - arr[i]);
		}
		return result;
	}

	static int[] findFourNumbersSumTo(int[] arr, int x) {
		int result[] = new int[4];
		Set<Integer> comps = new HashSet<>();
		x = x / 2;
		Integer[] sumOfTwo = findTwoNumbersSumTo(arr, x);
		List<Integer> elements = Arrays.stream(arr).boxed()
				.collect(Collectors.toList());
		Set<Integer> indexList = new HashSet<>(2);
		indexList.add(elements.indexOf(sumOfTwo[0]));
		indexList.add(elements.indexOf(sumOfTwo[1]));

		for (int i = 0; i < arr.length; i++) {
			if (!indexList.contains(i)) {
				if (comps.contains(arr[i])) {
					result[0] = sumOfTwo[0];
					result[1] = sumOfTwo[1];
					result[2] = arr[i];
					result[3] = x - arr[i];
				}
				comps.add(x - arr[i]);
			}
		}
		return result;
	}

}
