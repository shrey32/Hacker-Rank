package com.crackingthecodinginterview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		boolean[] sieve = prepareSieve(20000);
		System.out.println(findAllPrimesUpto(19000, sieve));
	}

	public static boolean[] prepareSieve(int max) {
		boolean[] sieve = new boolean[max];
		Arrays.fill(sieve, true);
		int prime = 2;
		while (prime < Math.sqrt(max)) {
			for (int i = prime * prime; i < sieve.length; i += prime) {
				sieve[i] = false;
			}
			// find next value which is true;
			int next = prime + 1;
			while (next < sieve.length && !sieve[next]) {
				next++;
			}
			prime = next;
		}
		return sieve;
	}

	public static List<Integer> findAllPrimesUpto(int n, boolean[] sieve) {
		List<Integer> list = new LinkedList<>();
		for (int i = 1; i < n; i++)
			if (sieve[i])
				list.add(i);
		return list;
	}

}
