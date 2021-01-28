package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
public class SmallestStringWithAGivenNumericValue {

	public static void main(String[] args) {
		System.out.println(getSmallestString(3, 8));
		System.out.println(getSmallestString(3, 27));
		System.out.println(getSmallestString(5, 73));
	}

	public static String getSmallestString(int n, int k) {
		Map<Integer, String> map = getLookup();
		List<Integer> list = new ArrayList<>();
		int high = 26;
		int curr = n;

		while (list.size() < n) {
			int rem = k - high;
			if (rem >= curr - 1) {
				list.add(high);
				curr--;
				k = rem;
			} else {
				high = high - 1;
			}
		}

		Collections.reverse(list);
		StringBuilder sb = new StringBuilder();
		for (int i : list) {
			sb.append(map.get(i));
		}
		return sb.toString();
	}

	public static Map<Integer, String> getLookup() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");
		map.put(6, "f");
		map.put(7, "g");
		map.put(8, "h");
		map.put(9, "i");
		map.put(10, "j");
		map.put(11, "k");
		map.put(12, "l");
		map.put(13, "m");
		map.put(14, "n");
		map.put(15, "o");
		map.put(16, "p");
		map.put(17, "q");
		map.put(18, "r");
		map.put(19, "s");
		map.put(20, "t");
		map.put(21, "u");
		map.put(22, "v");
		map.put(23, "w");
		map.put(24, "x");
		map.put(25, "y");
		map.put(26, "z");
		return map;
	}

}
