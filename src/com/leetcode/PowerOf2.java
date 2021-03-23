package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class PowerOf2 {

	public double myPow(double x, int n) {
		double res = 1;
		double curr = x;
		for (long i = Math.abs((long) n); i > 0; i = i / 2) {
			if (i % 2 == 1) {
				res = res * curr;
			}
			curr = curr * curr;
		}
		return n < 0 ? 1 / res : res;
	}

}
