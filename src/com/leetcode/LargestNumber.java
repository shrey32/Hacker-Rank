package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

	public static void main(String[] args) {
		System.out.println(largestNumber(new int[] { 10, 2 }));
		System.out.println(largestNumber(new int[] { 3, 30, 34, 5, 9 }));
	}

	public static String largestNumber(int[] nums) {

		List<String> list = new ArrayList<>();

		for (int i : nums)
			list.add(i + "");

		Collections.sort(list, (a, b) -> {
			String x = a + b;
			String y = b + a;
			return x.compareTo(y) > 0 ? -1 : 1;
		});

		return list.stream().collect(Collectors.joining());
	}

}
