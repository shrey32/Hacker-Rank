package com.hackerrank.datastructures.queue;

/**
 * 
 * @author Shrey
 *
 */
public class DownToZeroII {

	public static void main(String[] args) {
		int[] a = new int[] { 966514, 812849, 808707 };
		for (int i : a)
			System.out.println(downToZero(i));
	}

	static int downToZero(int n) {
		int move1 = n;
		int num = n;
		int div = 2;
		int count = 0;
		while (num > div) {
			if (num % div == 0) {
				num = Math.max(div, num / div);
				count++;
			}
			div++;
		}
		return Math.min(move1, num + count);
	}

}
