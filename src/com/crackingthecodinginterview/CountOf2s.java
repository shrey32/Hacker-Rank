package com.crackingthecodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class CountOf2s {

	public static void main(String[] args) {
		System.out.println(countOf2s(0, 5));
		System.out.println(countOf2s(0, 50));
	}

	public static int countOf2s(int r1, int r2) {
		int count2 = 0;
		for (int i = r1; i <= r2; i++) {
			count2 += split(i);
		}
		return count2;
	}

	private static int split(int n) {
		if (n <= 0)
			return 0;
		int countTwo = 0;
		while (true) {
			int rem = n % 10;
			if (rem == 2)
				countTwo++;
			n = (n - rem) / 10;
			if (n == 0)
				break;
		}

		return countTwo;

	}

}
