package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shrey
 *
 */

/**
 * The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain prime
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left to
 * right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

public class TruncatablePrimes {

	public static void main(String[] args) {

		List<String> truncatableList = new ArrayList<String>();
		int count = 0;
		for (int i = 20; i < 2000000; i++) {
			if (getPrime(i)) {

				String word = String.valueOf(i).trim();

				if (isTruncable(word)) {
					truncatableList.add(word);
				}

			}
		}

		for (int i = 0; i < 11; i++) {
			System.out.println(truncatableList.get(i));
			count = count + Integer.parseInt(truncatableList.get(i));
		}
		System.out.println(count);
	}

	public static boolean getPrime(int num) {
		boolean flag = true;
		for (int i = 2; i <= num / 2; i++) {

			if (num % i == 0) {
				flag = false;
				break;
			} else {
				flag = true;
			}
		}
		return flag;
	}

	public static boolean isTruncable(String word) {
		boolean result = false;
		int length = 1;

		while (length < word.length()) {
			// left to right
			String newS = word.substring(length, word.length());
			// right to left
			String newC = word.substring(0, word.length() - length);
			if (Integer.parseInt(newS) != 1 && Integer.parseInt(newC) != 1
					&& getPrime(Integer.parseInt(newS))
					&& getPrime(Integer.parseInt(newC))) {
				length++;

				result = true;
			} else {
				result = false;
				break;
			}

		}

		return result;
	}
}
