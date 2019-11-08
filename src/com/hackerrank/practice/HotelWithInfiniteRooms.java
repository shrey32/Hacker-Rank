package com.hackerrank.practice;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/RETO7/">RETO7 - El Hotel con
 * Habitaciones Infinitas</a>
 * 
 * @author Shrey
 *
 */
public class HotelWithInfiniteRooms {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int s = scan.nextInt();
		int d = scan.nextInt();
		sizeOfGroup(s, d);
		scan.close();
	}

	private final static void sizeOfGroup(int s, int d) {

		/*
		 * long start = s; long count = 1; for (int i = 1; i <= d; i++) { if (start ==
		 * count) { start = start + 1; count = 0; continue; } count++; }
		 * 
		 * System.out.println(start);
		 */

		long C = -2L * (d + f(s) - 1L);
		double x = (1.0 + Math.sqrt(1 - 4.0 * C)) / 2.0;
		System.out.println((int) (Math.floor(x) + 1e-7));
	}

	static long f(int x) {
		return BigInteger.valueOf(x).multiply(BigInteger.valueOf(x - 1)).shiftRight(1).longValue();
	}

}
