package com.spoj.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://www.spoj.com/problems/SERI07/">SERI07 - Strange But Easy</a>
 * 
 * @author Shrey
 *
 */
public class StrangeButEasy {

	private static List<Integer> primeNums = null;

	static {
		generatePrimes();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			solve(n);
		}
		br.close();
	}

	private final static void solve(int n) {

		for (int i = 1; i <= n; i++) {
			int total = i * 3;
			int a = primeNums.get(total - 3);
			int b = primeNums.get(total - 2);
			int c = primeNums.get(total - 1);
			System.out.print(((a * b) + c) + " ");
		}
		System.out.println();
	}

	private final static void generatePrimes() {
		int limit = 10000;

		boolean[] primes = new boolean[limit];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i < Math.sqrt(limit); i++) {
			if (primes[i]) {
				for (int j = i * i; j < limit; j += i) {
					primes[j] = false;
				}
			}
		}
		primeNums = IntStream.range(2, limit).mapToObj(Integer::valueOf).filter(i -> primes[i])
				.collect(Collectors.toList());
	}

}
