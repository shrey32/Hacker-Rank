package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * @author Shrey
 *
 */
public class TheKWeakestRowsInAMatrix {

	public static void main(String[] args) {
		
	}

	public static int[] kWeakestRows(int[][] mat, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < mat.length; i++) {
			int ar[] = mat[i];
			map.put(i, Arrays.stream(ar).filter(j -> j == 1).sum());
		}

		int[] rows = new int[k];
		List<Integer> list = map.entrySet().stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
				.map(e -> e.getKey()).limit(k).collect(Collectors.toList());
		for (int i = 0; i < k; i++) {
			rows[i] = list.get(i);
		}
		return rows;
	}

}
