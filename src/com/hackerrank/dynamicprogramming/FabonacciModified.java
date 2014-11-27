package com.hackerrank.dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

public class FabonacciModified {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long a = scan.nextLong();
		long b = scan.nextLong();
		int N = scan.nextInt();
		BigInteger b1 = BigInteger.valueOf(b);
		BigInteger a1 = BigInteger.valueOf(a);
		int i = 0;
        BigInteger c1=new BigInteger("0");
		while (i < N) {

			c1 = a1;
			a1 = b1;
			b1 = (a1.multiply(a1)).add(c1);
			i++;
		}
		System.out.println(c1);
		scan.close();
	}

}
