package com.hackerrank.warmup;

/**
 * 
 * @author Shrey
 *
 */
public class Square {

	public static void main(String[] args) {
		int x = 5, y = 5;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (i == 0 || i == x - 1 || j == 0 || j == y - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
