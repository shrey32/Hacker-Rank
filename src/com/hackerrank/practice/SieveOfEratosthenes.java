package com.hackerrank.practice;

import java.util.Arrays;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		primeGenerator(50);
	}

	static void primeGenerator(int num) {

		++num;

		boolean[] bool = new boolean[num];

		Arrays.fill(bool, true);

		for (int i = 2; i < Math.sqrt(num); i++) {
			for (int j = i * i; j < num; j += i) {
				bool[j] = false;
			}
		}

		for (int i = 2; i < num; i++) {
			if (bool[i])
				System.out.println(i);
		}

	}

}
