package com.hackerrank.arraysorting;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Shrey
 *
 */
public class AlgorithmicCrush {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int T = scan.nextInt();

		TreeMap<Integer, Long> map = new TreeMap<Integer, Long>();

		for (int i = 0; i < T; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			long k = scan.nextLong();

			Long aLong = map.get(a);
			if (aLong == null)
				aLong = 0L;
			map.put(a, aLong + k);
			Long bLong = map.get(b + 1);
			if (bLong == null)
				bLong = 0L;
			map.put(b + 1, bLong - k);
		}
		long result = 0;
		long current = 0;
		for (Long part : map.values()) {
			current += part;
			result = Math.max(result, current);
		}

		scan.close();
		System.out.println(result);
	}

}
