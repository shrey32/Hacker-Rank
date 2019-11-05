package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/RETO2/">RETO2 - TIEMPO JUNTOS grado
 * 10</a>
 * 
 * @author Shrey
 *
 */
public class TiempoJuntos {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int l1 = scan.nextInt();
		int r1 = scan.nextInt();
		int l2 = scan.nextInt();
		int r2 = scan.nextInt();
		int k = scan.nextInt();
		System.out.println(minutesTogether(l1, r1, l2, r2, k));
		scan.close();
	}

	private final static int minutesTogether(int l1, int r1, int l2, int r2, int k) {

		int minutesTogether = 0;
		for (int i = l1; i <= r1; i++) {
			if (i == k)
				continue;
			if (i >= l2 && i <= r2)
				minutesTogether++;

		}
		return minutesTogether;
	}

}
