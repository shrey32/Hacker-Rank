package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class PrintAllPossibleWordsFromTheList {

	public static void main(String[] args) {
		generateNumberToCharMap();
		System.out.println(combinations(new int[] { 2 }));
		System.out.println(combinations(new int[] { 2, 3, 4 }));
		System.out.println(combinations(new int[] { 8, 7, 3, 3 }));
	}

	static char[][] numberToCharMap;

	private static void generateNumberToCharMap() {
		numberToCharMap = new char[10][5];
		numberToCharMap[0] = new char[] { '\0' };
		numberToCharMap[1] = new char[] { '\0' };
		numberToCharMap[2] = new char[] { 'a', 'b', 'c' };
		numberToCharMap[3] = new char[] { 'd', 'e', 'f' };
		numberToCharMap[4] = new char[] { 'g', 'h', 'i' };
		numberToCharMap[5] = new char[] { 'j', 'k', 'l' };
		numberToCharMap[6] = new char[] { 'm', 'n', 'o' };
		numberToCharMap[7] = new char[] { 'p', 'q', 'r', 's' };
		numberToCharMap[8] = new char[] { 't', 'u', 'v' };
		numberToCharMap[9] = new char[] { 'w', 'x', 'y', 'z' };
	}

	public static List<String> combinations(int[] nums) {
		List<String> combinations = new ArrayList<>();
		helper(nums, 0, "", combinations);
		return combinations;
	}

	public static void helper(int[] nums, int ind, String s, List<String> res) {

		if (ind == nums.length) {
			res.add(s);
			return;
		}
		int key = nums[ind];
		char[] ch = numberToCharMap[key];
		for (int i = 0; i < ch.length; i++) {
			StringBuilder copy = new StringBuilder(s);
			copy.append(ch[i]);
			helper(nums, ind + 1, copy.toString(), res);
		}
	}

}
