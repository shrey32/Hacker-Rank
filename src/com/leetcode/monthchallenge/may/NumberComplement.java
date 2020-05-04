package com.leetcode.monthchallenge.may;

/**
 * <b>Number Complement</b>
 * <p>
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 * </p>
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> 5
 * </p>
 * <p>
 * <b>Output:</b> 2
 * </p>
 * <p>
 * <b>Explanation:</b> The binary representation of 5 is 101 (no leading zero
 * bits), and its complement is 010. So you need to output 2.
 * </p>
 * 
 * 
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input:</b> 1
 * </p>
 * <p>
 * <b>Output:</b> 0
 * </p>
 * <p>
 * <b>Explanation:</b> The binary representation of 1 is 1 (no leading zero
 * bits), and its complement is 0. So you need to output 0.
 * </p>
 * 
 * 
 * <b>Note:</b>
 * 
 * <li>The given integer is guaranteed to fit within the range of a 32-bit
 * signed integer.</li>
 * <li>You could assume no leading zero bit in the integer’s binary
 * representation.</li>
 * <li>This question is the same as 1009:
 * https://leetcode.com/problems/complement-of-base-10-integer/</li>
 * 
 * @author Shrey
 *
 */
public class NumberComplement {

	public static void main(String[] args) {
		System.out.println(findComplement(5));// 2
		System.out.println(findComplement(1));// 0
	}

	public static int findComplement(int num) {
		char[] binary = Integer.toString(num, 2).toCharArray();
		for (int i = 0; i < binary.length; i++) {
			char curr = binary[i];
			binary[i] = curr == '1' ? '0' : '1';
		}
		return Integer.parseInt(String.valueOf(binary), 2);
	}

}
