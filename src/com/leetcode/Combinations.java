package com.leetcode;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Shrey
 *
 */
public class Combinations {

	public static void main(String[] args) {
		System.out.println(combine(4, 2));
		System.out.println(combine(5, 3));
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		perm(1, n, k, temp, res);
		return res;
	}

	public static void perm(int start, int end, int k, List<Integer> temp, List<List<Integer>> res) {
		if (temp.size() == k) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i <= end; i++) {
			temp.add(i);
			perm(i + 1, end, k, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
