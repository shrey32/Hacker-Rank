package com.hackerrank.dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

/**Problem Statement

 A series is defined in the following manner:

 Given the nth and (n+1)th terms, the (n+2)th can be computed by the following relation 
 Tn+2 = (Tn+1)2 + Tn

 So, if the first two terms of the series are 0 and 1: 
 the third term = 12 + 0 = 1 
 fourth term = 12 + 1 = 2 
 fifth term = 22 + 1 = 5 
 ... And so on.

 Given three integers A, B and N, such that the first two terms of the series (1st and 2nd terms) are A and B respectively, compute the Nth term of the series.

 Input Format

 You are given three space separated integers A, B and N on one line.

 Input Constraints 
 0 <= A,B <= 2 
 3 <= N <= 20

 Output Format

 One integer. 
 This integer is the Nth term of the given series when the first two terms are A and B respectively.

 Sample Input 
 0 1 5

 Sample Output 
 5

 Explanation

 The first two terms of the series are 0 and 1. The fifth term is 5. How we arrive at the fifth term, is explained step by step in the introductory sections   
 */

/**
 * @author Shrey
 *
 */
public class FabonacciModified {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long a = scan.nextLong();
		long b = scan.nextLong();
		int N = scan.nextInt();
		BigInteger b1 = BigInteger.valueOf(b);
		BigInteger a1 = BigInteger.valueOf(a);
		int i = 0;
		BigInteger c1 = new BigInteger("0");
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
