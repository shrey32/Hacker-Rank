package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/OMIOPOLYGON/">OMIOPOLYGON - TUHIN The
 * Mathematician</a>
 * 
 * @author Shrey
 *
 */
public class TuhinTheMathematician {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println((n - 2) * 180);
		scan.close();
	}

}
