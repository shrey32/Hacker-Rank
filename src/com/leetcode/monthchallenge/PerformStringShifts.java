package com.leetcode.monthchallenge;

/**
 * <b>Perform String Shifts</b>
 * <p>
 * You are given a string s containing lowercase English letters, and a matrix
 * shift, where shift[i] = [direction, amount]:<br>
 * direction can be 0 (for left shift) or 1 (for right shift).<br>
 * amount is the amount by which string s is to be shifted.<br>
 * A left shift by 1 means remove the first character of s and append it to the
 * end.<br>
 * Similarly, a right shift by 1 means remove the last character of s and add it
 * to the beginning.<br>
 * Return the final string after all operations.
 * </p>
 * 
 * 
 * 
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> s = "abc", shift = [[0,1],[1,2]]
 * </p>
 * <p>
 * <b>Output:</b> "cab"
 * </p>
 * <p>
 * <b>Explanation:</b>
 * </p>
 * <li>[0,1] means shift to left by 1. "abc" -> "bca"</li>
 * <li>[1,2] means shift to right by 2. "bca" -> "cab"</li>
 * 
 * <b>Example 2:</b>
 * <p>
 * <b>Input:</b> s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * </p>
 * <p>
 * <b>Output:</b> "efgabcd"
 * </p>
 * <p>
 * <b>Explanation:</b>
 * </p>
 * <li>[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"</li>
 * <li>[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"</li>
 * <li>[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"</li>
 * <li>[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"</li>
 * 
 * 
 * <b>Constraints:</b>
 * 
 * <li>1 <= s.length <= 100</li>
 * <li>s only contains lower case English letters.</li>
 * <li>1 <= shift.length <= 100</li>
 * <li>shift[i].length == 2</li>
 * <li>0 <= shift[i][0] <= 1</li>
 * <li>0 <= shift[i][1] <= 100</li>
 * 
 * @author Shrey
 *
 */
public class PerformStringShifts {

	public static void main(String[] args) {
		System.out.println(stringShift("abc", new int[][] { { 0, 1 }, { 1, 2 } }));
		System.out.println(stringShift("abcdefg", new int[][] { { 1, 1 }, { 1, 1 }, { 0, 2 }, { 1, 3 } }));
		System.out.println(stringShift("yisxjwry",
				new int[][] { { 1, 8 }, { 1, 4 }, { 1, 3 }, { 1, 6 }, { 0, 6 }, { 1, 4 }, { 0, 2 }, { 0, 1 } }));
		System.out.println(stringShift("xqgwkiqpif", new int[][] { { 1, 4 }, { 0, 7 }, { 0, 8 }, { 0, 7 }, { 0, 6 },
				{ 1, 3 }, { 0, 1 }, { 1, 7 }, { 0, 5 }, { 0, 6 } }));
		System.out.println(stringShift("wpdhhcj",
				new int[][] { { 0, 7 }, { 1, 7 }, { 1, 0 }, { 1, 3 }, { 0, 3 }, { 0, 6 }, { 1, 2 } }));
	}

	public static String stringShift(String s, int[][] shift) {

		if (s == null || "".equals(s.trim()))
			return null;

		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < shift.length; i++) {
			int operation = shift[i][0];
			int times = shift[i][1];
			StringBuilder result = new StringBuilder(sb.toString());

			for (int j = 0; j < times; j++) {
				if (operation == 1)
					result = new StringBuilder(rightShift(result, 1));
				else
					result = new StringBuilder(leftShift(result, 1));
			}

			sb = result;
		}
		return sb.toString();
	}

	private static String leftShift(StringBuilder sb, int d) {

		return sb.substring(d) + sb.substring(0, d);
	}

	private static String rightShift(StringBuilder sb, int d) {
		return leftShift(sb, Math.abs(sb.length() - d));
	}
}
