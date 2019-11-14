package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <a href="spoj.com/problems/AWESOMECHILDHOOD/">AWESOMECHILDHOOD - Awesome
 * Childhood</a>
 * 
 * @author Shrey
 *
 */
public class AwesomeChildhood {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			long n = scan.nextLong();
			System.out.println(n / 2);
		}
		scan.close();
	}

}
