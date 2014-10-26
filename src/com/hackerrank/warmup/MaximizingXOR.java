package com.hackerrank.warmup;

import java.util.Scanner;

/**
 * @author Shrey
 *
 */
public class MaximizingXOR {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int res;
		int _l;
		_l = Integer.parseInt(in.nextLine());

		int _r;
		_r = Integer.parseInt(in.nextLine());

		res = maxXor(_l, _r);
		System.out.println(res);
		in.close();
	}

	static int maxXor(int l, int r) {

		int res = Integer.MIN_VALUE;
		for (int a = l; a <= r; a++) {
			for (int b = l; b <= r; b++) {
				int curr = a ^ b;
				if (curr > res) {
					res = curr;
				}
			}
		}
		return res;
	}
}
