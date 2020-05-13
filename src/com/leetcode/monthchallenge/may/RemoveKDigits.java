package com.leetcode.monthchallenge.may;

/**
 * 
 * <b>Remove K Digits</b>
 * <p>
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * </p>
 * 
 * <p>
 * <b>Note:</b>
 * </p>
 * <li>The length of num is less than 10002 and will be ≥ k.</li>
 * <li>The given num does not contain any leading zero.</li>
 * 
 * <b>Example 1:</b>
 * 
 * <pre class="code">
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * </pre>
 * 
 * <b>Example 2:</b>
 * 
 * <pre class="code">
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * </pre>
 * 
 * <b>Example 3:</b>
 * 
 * <pre class="code">
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * </pre>
 * 
 * @author Shrey
 *
 */
public class RemoveKDigits {

	public static void main(String[] args) {
		System.out.println(removeKdigits("1432219", 3));
		System.out.println(removeKdigits("10200", 1));
		System.out.println(removeKdigits("10", 2));
	}

	public static String removeKdigits(String num, int k) {
		if (num.length() == k)
			return "0";

		StringBuilder sb = new StringBuilder(num);

		/*
		 * We will iterate the number k times. In each iteration: 1. Remove the digit
		 * for which the next digit is smaller. 2. If we reach at the end than remove
		 * last digit.
		 */
		for (int j = 0; j < k; j++) {
			int i = 0;
			while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
				i++;
			}
			sb.delete(i, i + 1);
		}

		// remove leading 0's
		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.delete(0, 1);

		if (sb.length() == 0) {
			return "0";
		}

		return sb.toString();
	}

}
