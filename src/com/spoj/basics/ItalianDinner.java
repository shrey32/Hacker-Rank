package com.spoj.basics;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/VZLA2019I/">VZLA2019I - Italian
 * Dinner</a>
 * 
 * @author Shrey
 *
 */
public class ItalianDinner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BigInteger bigInt = BigInteger.ONE;
		for (int i = 0; i < 6; i++) {
			bigInt = bigInt.multiply(new BigInteger(scan.next()));
		}
		System.out.println(bigInt);
		scan.close();
	}

}
