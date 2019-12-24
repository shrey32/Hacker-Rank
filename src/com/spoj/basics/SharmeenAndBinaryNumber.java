package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/MOZSABN/">MOZSABN - Sharmeen and
 * binary number</a>
 * 
 * @author Shrey
 *
 */
public class SharmeenAndBinaryNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num = scan.next();
		num = num.replace("0", "");
		System.out.println(num.length());
		scan.close();
	}

}
