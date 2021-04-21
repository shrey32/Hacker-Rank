package com.crackingthecodinginterview;

/**
 * n=5 1,1,1,1,1 1,1,1,2 1,2,2 1,1,3 2,3
 * 
 * @author Shrey
 *
 */
public class TripleStep {

	public static void main(String[] args) {
		System.out.println(tripleStep(19));
		System.out.println(tripleStepDP(19));
	}

	public static int tripleStep(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return tripleStep(n - 1) + tripleStep(n - 2) + tripleStep(n - 3);
	}

	public static int tripleStepDP(int n) {
		if (n == 0 || n == 1)
			return 1;
		if (n == 2)
			return 2;
		int a = 1;
		int b = 1;
		int c = 2;
		int count = 0;
		for (int i = 3; i <= n; i++) {
			count = a + b + c;
			a = b;
			b = c;
			c = count;
		}
		return count;
	}
}
