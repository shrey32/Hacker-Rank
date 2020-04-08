package com.leetcode.monthchallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 
 * <p>
 * <b>Counting Elements</b>
 * <p>
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * 
 * If there're duplicates in arr, count them seperately.
 * </p>
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> arr = [1,2,3]
 * <p>
 * <b>Output:</b> 2
 * <p>
 * <b>Explanation:</b> 1 and 2 are counted cause 2 and 3 are in arr.
 * </p>
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input:</b> arr = [1,1,3,3,5,5,7,7]
 * </p>
 * <p>
 * <b>Output:</b> 0
 * </p>
 * <p>
 * <b>Explanation:</b> No numbers are counted, cause there's no 2, 4, 6, or 8 in
 * arr.
 * </p>
 * <b>Example 3:</b>
 * 
 * <p>
 * <b>Input:</b> arr = [1,3,2,3,5,0]
 * </p>
 * <p>
 * <b>Output:</b> 3
 * </p>
 * <p>
 * <b>Explanation:</b> 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 * </p>
 * <b>Example 4:</b>
 * 
 * <p>
 * <b>Input:</b> arr = [1,1,2,2]
 * </p>
 * <p>
 * <b>Output:</b> 2
 * </p>
 * <p>
 * <b>Explanation:</b> Two 1s are counted cause 2 is in arr.
 * </p>
 * 
 * 
 * <b>Constraints:</b>
 * 
 * <li>1 <= arr.length <= 1000</li>
 * <li>0 <= arr[i] <= 1000</li>
 * </p>
 * 
 * @author Shrey
 *
 */
public class CountingElements {

	public static void main(String[] args) {
		System.out.println(countElements(new int[] { 1, 2, 3 }));// 2
		System.out.println(countElements(new int[] { 1, 1, 3, 3, 5, 5, 7, 7 }));// 0
		System.out.println(countElements(new int[] { 1, 3, 2, 3, 5, 0 }));// 3
		System.out.println(countElements(new int[] { 1, 1, 2, 2 }));// 2
		System.out.println(countElements(new int[] { 2, 9, 0, 7, 6, 2, 7, 7, 0 }));// 1
		System.out.println(countElements(new int[] { 4, 10, 11, 11, 1, 9, 6, 2, 4, 5, 8 }));// 7
	}

	public static int countElements(int[] arr) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int count = 0;

		List<Integer> items = new ArrayList<>(map.keySet());

		for (int i = 1; i < items.size(); i++) {
			int prev = items.get(i - 1);
			int curr = items.get(i);
			if (curr - prev == 1) {
				count += map.get(prev);
			}
		}
		return count;
	}

}
