package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/FUCT_FOR_TRINUM/">FUCT_FOR_TRINUM -
 * Number triangular</a>
 * 
 * @author Shrey
 *
 */
public class NumberTriangular {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		draw(n);
		scan.close();
	}

	private static final void draw(int n) {

		for (int i = 1; i <= n; i++) {
			for (int j = i; j >= 1; j--)
				System.out.print(j + " ");
			System.out.println();
		}
	}

}
