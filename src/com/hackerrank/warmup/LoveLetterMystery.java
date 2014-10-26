package com.hackerrank.warmup;

import java.util.Scanner;

/**
 * @author Shrey
 *
 */
public class LoveLetterMystery {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int numTestCases = s.nextInt();

		while (numTestCases > 0) {

			String word = s.next();

			System.out.println(numCount(word));

			--numTestCases;
		}

		s.close();
	}

	public static int numCount(String word) {
		int count = 0;
		char[] wordArray = word.toCharArray();
		int length = word.length() - 1;
		for (int i = 0; i < wordArray.length / 2; i++, length--) {
			count = count + Math.abs((int) wordArray[i] - wordArray[length]);
		}
		return count;
	}
}
