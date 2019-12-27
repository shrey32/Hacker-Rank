package com.spoj.basics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Write a function:
 * 
 * function solution(A);
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000].
 * 
 * @author Shrey
 *
 */
public class MissingInteger {

	public static void main(String[] args) {
		System.out.println(missingInteger(new int[] { 1, 3, 6, 4, 1, 2 }));// 5
		System.out.println(missingInteger(new int[] { 1, 2, 3 }));// 4
		System.out.println(missingInteger(new int[] { -1, -3 }));// 1
	}

	private static final int missingInteger(int[] ar) {
		Set<Integer> set = new HashSet<>();
		for (int a : ar)
			set.add(a);
		int start = 1;
		Iterator<Integer> itr = set.iterator();
		while (itr.hasNext()) {
			if (!set.contains(start))
				return start;
			start++;
		}
		return -1;
	}

}
