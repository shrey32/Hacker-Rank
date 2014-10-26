package com.hackerrank.warmup;

import java.util.Scanner;

public class CutTheSticks {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] ar = getArray(sc);

		getCutsPerRow(ar);

	}

	public static int getMin(int[] args) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < args.length; i++) {
			if (args[i] < min && args[i] > 0) {
				min = args[i];
			}
		}

		return min;
	}

	public static void getCutsPerRow(int[] args) {

		int min = 1;
		while (true) {
			if (onlyZeros(args)) {
				break;
			}

			int cut = 0;
			min = (getMin(args));
			for (int i = 0; i < args.length; i++) {
				if (args[i] != 0) {
					args[i] = args[i] - min;
					cut++;
				}
			}

			System.out.println(cut);
		}

	}

	private static boolean onlyZeros(int[] in) {
		for (int item : in) {
			if (item > 0) {
				return false;
			}
		}
		return true;
	}

	private static int[] getArray(Scanner scan) {
		int N = scan.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {

			arr[i] = scan.nextInt();

		}
		return arr;
	}
}
