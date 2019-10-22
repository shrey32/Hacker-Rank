package com.hackerrank.warmup;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountTriplets {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		List<Long> list = Arrays.stream(arr).mapToLong(Long::valueOf).boxed()
				.collect(Collectors.toList());
		System.out.println(countTriplets(list, 2));
	}

	static long countTriplets(List<Long> arr, long r) {
		Map<Long, Integer> map = new LinkedHashMap<>();
		for (Long i : arr)
			map.put(i, map.getOrDefault(i, 0) + 1);
		long count = map.size() - 2;
		for (int i : map.values()) {
			if (i > 1)
				count = count * i;
		}
		return count;
	}
}
