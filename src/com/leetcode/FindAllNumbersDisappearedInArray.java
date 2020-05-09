package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class FindAllNumbersDisappearedInArray {

	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));// [5,6]
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int i : nums)
			set.add(i);
		int i = 1;
		List<Integer> list = new ArrayList<>();
		while (i <= nums.length) {
			if (!set.contains(i))
				list.add(i);
			i++;
		}
		return list;
	}
}
