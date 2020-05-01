package com.hackerrank.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * <a href=
 * "https://www.hackerrank.com/challenges/largest-rectangle/problem">Largest
 * Rectangle</a>
 * 
 * @author Shrey
 *
 */
public class LargestRectangle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();

		System.out.println(largestRectangle(a, n));

		scan.close();
	}

	private static final long largestRectangle(int[] a, int n) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			int h = a[i];
			int w = 1;
			if (i > 0 && a[i] >= a[i - 1]) {
				stack.push(h);
			}
		}

		return -1;
	}

}
