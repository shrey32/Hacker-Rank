package com.crackingthecodinginterview;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Shrey
 *
 */
public class PowerSet {

	public static void main(String[] args) {
		System.out.println(powerSet(new int[] { 1, 2, 3, 4, 5 }));
	}

	/**
	 * 
	 * backtracking to get all the possible combination O(2^n)
	 * 
	 * 
	 * @param a
	 * @return
	 */
	public static List<List<Integer>> powerSet(int[] a) {
		List<List<Integer>> result = new ArrayList<>();
		powerSet(a, 0, new ArrayList<>(), result);
		return result;
	}

	private static void powerSet(int[] a, int start, List<Integer> curr, List<List<Integer>> result) {
		if (!curr.isEmpty()) {
			result.add(new ArrayList<>(curr));
		}
		for (int i = start; i < a.length; i++) {
			curr.add(a[i]);
			powerSet(a, i + 1, curr, result);
			curr.remove(curr.size() - 1);
		}
	}
}
