package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class CombinationSum {

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 1, 2, 3 }, 4));
		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
		System.out.println(combinationSum(new int[] { 2 }, 1));
		System.out.println(combinationSum(new int[] { 1 }, 1));
		System.out.println(combinationSum(new int[] { 1 }, 2));
	}

	public static List<List<Integer>> combinationSum(int[] ar, int target) {
		List<List<Integer>> res = new ArrayList<>();
		helper(ar, 0, target, 0, new ArrayList<>(), res);
		return res;
	}

	public static void helper(int[] ar, int ind, int target, int curr, List<Integer> l, List<List<Integer>> res) {

		if (curr == target) {
			res.add(new ArrayList<>(l));
			return;
		}

		if (curr > target)
			return;

		for (int i = 0; i < ar.length; i++) {
			curr += ar[i];
			l.add(ar[i]);
			helper(ar, i, target, curr, l, res);
			curr -= l.get(l.size() - 1);
			l.remove(l.size() - 1);
		}
	}
}
