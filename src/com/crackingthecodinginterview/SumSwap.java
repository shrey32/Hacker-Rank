package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Shrey
 *
 */
public class SumSwap {

	public static void main(String[] args) {
		System.out.println(sumSwap(new int[] { 4, 1, 2, 1, 1, 2 }, new int[] { 3, 6, 3, 3 }));
		System.out.println(sumSwap(new int[] { 5, 7, 4, 6 }, new int[] { 1, 2, 3, 8 }));
	}

	public static List<Integer> sumSwap(int[] a, int[] b) {
		List<Integer> swap = new ArrayList<>(2);
		int sumA = sum(a);
		int sumB = sum(b);

		if (sumA == sumB || ((sumA + sumB) % 2) != 0)// can't make equal some if the total sum is not divisible by 2
			return swap;
		int req = 0;
		if (sumA > sumB) {
			req = sumA - (sumA + sumB) / 2;
		} else {
			req = sumB - (sumA + sumB) / 2;
		}

		int[] max = sumA > sumB ? a : b;
		int[] min = sumA > sumB ? b : a;
		Set<Integer> set = new HashSet<>();
		for (int i : max)
			set.add(i);

		for (int i = 0; i < min.length; i++) {
			if (set.contains(min[i] + req)) {
				swap.add(min[i]);
				swap.add(min[i] + req);
				break;
			}
		}
		return swap;
	}

	public static int sum(int[] ar) {
		int sum = 0;
		for (int i : ar)
			sum += i;
		return sum;
	}

}
