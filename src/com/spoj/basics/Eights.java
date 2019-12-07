package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/STROOQ">A complex yet very simple
 * problem </a>
 * 
 * @author Shrey
 *
 */
public class Eights {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			long n = scan.nextLong();
			long res = 192 + (n - 1) * 250L;
			System.out.println(res);
		}
		scan.close();
	}

}
