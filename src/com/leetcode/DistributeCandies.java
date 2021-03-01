package com.leetcode;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Shrey
 *
 */
public class DistributeCandies {

	public static void main(String[] args) {
		System.out.println(distributeCandies(new int[] { 1, 1, 2, 2, 3, 3 }));// 3
	}

	public static int distributeCandies(int[] candyType) {
		int n = candyType.length;
		Set<Integer> set = new HashSet<>();
		for (int i : candyType)
			set.add(i);
		Iterator<Integer> itr = set.iterator();
		int count = 0;
		while (count < n / 2 && itr.hasNext()) {
			itr.next();
			count++;
		}
		return count;
	}

}
