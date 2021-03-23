package com.leetcode;

import java.util.Map;
import java.util.HashMap;

/**
 * 
 * @author Shrey
 *
 */
public class ThreeSumWithMultiplicity {

	public static void main(String[] args) {
		System.out.println(threeSumMulti(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, 8));
	}

	public static int threeSumMulti(int[] arr, int target) {
		int mod = 1000000007;
		Map<Integer, Long> map = new HashMap<>();
		for (int i : arr)
			map.put(i, map.getOrDefault(i, 0l) + 1l);
		long result = 0;
		for (int key1 : map.keySet()) {
			for (int key2 : map.keySet()) {
				int diff = target - key1 - key2;
				if (map.containsKey(diff)) {
					if (key1 == key2 && key1 == diff) {
						result += ((map.get(key1)) * (map.get(key1) - 1) * (map.get(key1) - 2)) / 6;
					} else if (key1 == key2 && key1 != diff) {
						result += ((map.get(key1) * (map.get(key1) - 1)) / 2 * map.get(diff));
					} else if (key1 < key2 && key2 < diff) {
						result += ((map.get(key1) * map.get(key2) * map.get(diff)));
					}
				}
			}
		}
		return ((int) (result % mod));
	}

}
