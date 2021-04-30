package com.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * 
 * @author Shrey
 *
 */
public class PowerfulIntegers {

	public static void main(String[] args) {
		System.out.println(powerfulIntegers(2, 3, 10));
		System.out.println(powerfulIntegers(3, 5, 15));
	}

	public static List<Integer> powerfulIntegers(int x, int y, int bound) {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i < bound; i *= x) {
			for (int j = 1; j < bound; j *= y) {
				int sum = i + j;
				if (sum <= bound)
					set.add(sum);
				if (y == 1)
					break;
			}
			if (x == 1)
				break;
		}
		return new ArrayList<>(set);
	}

}
