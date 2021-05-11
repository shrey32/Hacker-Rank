package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class NextGreaterElementI {

	public static void main(String[] args) {
		System.out.println(nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }));
	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> st = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums2.length; i++) {

			while (!st.isEmpty() && nums2[i] > st.peek()) {
				map.put(st.pop(), nums2[i]);
			}
			st.push(nums2[i]);
		}

		while (!st.isEmpty())
			map.put(st.pop(), -1);

		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++)
			res[i] = map.get(nums1[i]);

		return res;
	}

}
