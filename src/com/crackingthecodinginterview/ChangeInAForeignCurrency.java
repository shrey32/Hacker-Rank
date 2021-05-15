package com.crackingthecodinginterview;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Shrey
 *
 */
public class ChangeInAForeignCurrency {

	public static void main(String[] args) {
		System.out.println(canGetExactChange(94, new int[] { 5, 10, 25, 100, 200 }));
		System.out.println(canGetExactChange(94, new int[] { 4, 17, 29 }));
	}

	private static void helper(int[] ar, int target, int curr, List<Integer> list, List<List<Integer>> res) {
		if (curr == target) {
			res.add(new ArrayList<>(list));
			return;
		}

		if (!res.isEmpty() || curr > target)
			return;

		for (int i = 0; i < ar.length; i++) {
			curr += ar[i];
			list.add(ar[i]);
			helper(ar, target, curr, list, res);
			curr -= list.get(list.size() - 1);
			list.remove(list.size() - 1);
		}
	}

	public static boolean canGetExactChange(int targetMoney, int[] denominations) {
		// Write your code here
		List<List<Integer>> res = new ArrayList<>();
		helper(denominations, targetMoney, 0, new ArrayList<>(), res);
		System.out.println(res);
		return !res.isEmpty();
	}

}
