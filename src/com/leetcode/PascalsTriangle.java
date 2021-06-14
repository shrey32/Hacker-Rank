package com.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		System.out.println(generate(5));
		System.out.println(generate(30));
	}

	private static ArrayList<List<Integer>> list = new ArrayList<>();

	static {
		list = helper(30);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = list.subList(0, numRows);
		return res;
	}

	public static ArrayList<List<Integer>> helper(int numRows) {
		ArrayList<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1));
		list.add(Arrays.asList(1, 1));
		for (int i = 2; i < numRows; i++) {
			List<Integer> sub = new ArrayList<>(i);
			List<Integer> prev = list.get(i - 1);
			sub.add(1);
			for (int j = 1; j < i; j++) {
				sub.add(prev.get(j - 1) + prev.get(j));
			}
			sub.add(1);
			list.add(sub);
		}
		return list;
	}

}
