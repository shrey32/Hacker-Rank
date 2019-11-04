package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/RETOCALENTAMIENT/">RETOCALENTAMIENT -
 * Pertre</a>
 * 
 * @author Shrey
 *
 */
public class Pertre {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		if (n < 2) {
			System.out.println("-1");
			System.exit(0);
		}

		boolean isRising = false;
		int prev = -1;
		while (n-- > 0) {
			if (prev < 0) {
				prev = scan.nextInt();
				continue;
			} else {
				int curr = scan.nextInt();
				if (curr > prev && curr - prev == 1)
					isRising = true;
				else if (curr < prev && curr - prev < 0)
					isRising = false;
				prev = curr;
			}
		}

		System.out.println(isRising ? "CRECIENTE" : "MENGUANTE");

		scan.close();
	}

}
