package com.leetcode.monthchallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class LastStoneWeight {

	public static void main(String[] args) {
		System.out.println(lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
		System.out.println(lastStoneWeight(new int[] { 6, 6, 4, 9, 4, 6, 3 }));
	}

	public static int lastStoneWeight(int[] stones) {

		if (stones == null || stones.length == 0)
			return 0;

		int n = stones.length;

		List<Integer> list = new ArrayList<>(n);

		for (int stone : stones)
			list.add(stone);

		Collections.sort(list);

		while (list.size() > 1) {
			int max1 = list.remove(list.size() - 1);
			int max2 = list.remove(list.size() - 1);
			int diff = Math.abs(max1 - max2);
			if (diff > 0) {
				list.add(diff);
				Collections.sort(list);
			}
		}

		return list.size() == 1 ? list.get(list.size() - 1) : 0;

	}
}
