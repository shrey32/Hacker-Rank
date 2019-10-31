package com.hackerrank.practice;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {

	public static void main(String[] args) {

		System.out.println(removeDuplicates(new int[] {}));
		System.out.println(removeDuplicates(new int[] { 2, 2, 2, 2, 2 }));
		System.out.println(removeDuplicates(new int[] { 1, 2, 2, 3, 4, 4, 4, 5, 5 }));
		reverse(new int[] { 1, 2, 2, 3, 4, 4, 4, 5, 5 });
	}

	static List<Integer> removeDuplicates(int[] ar) {
		List<Integer> result = new ArrayList<>();

		if (ar.length != 0)
			result.add(ar[0]);

		for (int i = 1; i < ar.length; i++) {
			if (ar[i] != ar[i - 1])
				result.add(ar[i]);
		}

		return result;
	}

	static void reverse(int[] ar) {
		for (int i = 0, j = ar.length - 1; i < ar.length / 2; i++, j--) {
			int temp = ar[i];
			ar[i] = ar[j];
			ar[j] = temp;
		}

		for (int i : ar)
			System.out.print(i + " ");

	}

}
