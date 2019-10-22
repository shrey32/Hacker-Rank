package com.hackerrank.warmup;

import java.util.Arrays;

public class MoveZerosToEnd {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(moveZerosToEnd(new int[] { 1, 2, 0,
				5, 0, 3, 4, 0, 0 })));
	}

	static int[] moveZerosToEnd(int[] ar) {

		int counter = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != 0) {
				ar[counter] = ar[i];
				counter++;
			}
		}
		for (int i = counter; i < ar.length; i++) {
			ar[i] = 0;
		}
		return ar;
	}

}
