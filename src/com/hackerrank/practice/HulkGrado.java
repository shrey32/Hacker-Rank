package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/RETO6/">RETO6 - HULK Grado 10</a>
 * 
 * @author Shrey
 *
 */
public class HulkGrado {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(feelings(n));
		scan.close();
	}

	private static final String feelings(int n) {
		StringBuilder feelings = new StringBuilder();
		boolean isHate = true;
		for (int i = 1; i < n; i++) {
			if (isHate)
				feelings.append("I hate that ");
			else
				feelings.append("I love that ");
			isHate = !isHate;
		}
		if (isHate)
			feelings.append("I hate it");
		else
			feelings.append("I love it");

		return feelings.toString();
	}

}
