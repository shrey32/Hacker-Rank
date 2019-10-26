package com.hackerrank.practice;

import java.util.Scanner;

/**
 * <p>
 * <b>The Next Palindrome</b>
 * </p>
 * <p>
 * A positive integer is called a palindrome if its representation in the
 * decimal system is the same when read from left to right and from right to
 * left. For a given positive integer K of not more than 1000000 digits, write
 * the value of the smallest palindrome larger than K to output. Numbers are
 * always displayed without leading zeros.
 * </p>
 * 
 * <p>
 * <b>Input</b>
 * </p>
 * <p>
 * The first line contains integer t, the number of test cases. Integers K are
 * given in the next t lines.
 * </p>
 * 
 * <p>
 * <b>Output</b>
 * </p>
 * <p>
 * For each K, output the smallest palindrome larger than K.
 * </p>
 * 
 * <p>
 * <b>Example Input:</b>
 * <li>2</li>
 * <li>808</li>
 * <li>2133</li>
 * </p>
 * 
 * <p>
 * <b>Output:</b>
 * <li>818</li>
 * <li>2222</li>
 * </p>
 * 
 * @author Shrey
 *
 */
public class TheNextPalindrome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long num = scan.nextLong();
		next(num);
		scan.close();
	}

	static void next(long num) {
		if (num < 10)
			return;
		long divisor = 10;
		long originalNum = num;
		while (num / 10 > 10) {
			divisor *= 10;
			num = num / 10;
		}
		long firstDigit = originalNum / divisor;
		long firstPalindrome = firstDigit * divisor + firstDigit;
		long incr = 0;
		if (divisor == 100)
			incr = 10;
		else
			incr = 11 * (divisor / (divisor / 10));

		while (firstPalindrome <= originalNum) {
			firstPalindrome += incr;
		}
		System.out.println(firstPalindrome);
	}

}
