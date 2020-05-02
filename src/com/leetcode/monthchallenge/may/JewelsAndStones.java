package com.leetcode.monthchallenge.may;

import java.util.HashSet;
import java.util.Set;

/**
 * <b>Jewels and Stones</b>
 * <p>
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * </p>
 * 
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 * </p>
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * </b>Input:</b> J = "aA", S = "aAAbbbb"
 * </p>
 * <p>
 * </b>Output:</b> 3
 * </p>
 * <b>Example 2:</b>
 * 
 * <p>
 * </b>Input:</b> J = "z", S = "ZZ"
 * </p>
 * <p>
 * </b>Output:</b> 0
 * </p>
 * 
 * <b>Note:</b>
 * 
 * <li>S and J will consist of letters and have length at most 50.</li>
 * <li>The characters in J are distinct.</li>
 * 
 * @author Shrey
 *
 */
public class JewelsAndStones {

	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));// 3
		System.out.println(numJewelsInStones("z", "ZZ"));// 0
	}

	public static int numJewelsInStones(String jewels, String stones) {
		if (jewels == null || stones == null)
			return 0;
		Set<Character> jewelSet = new HashSet<>();
		for (char c : jewels.toCharArray())
			jewelSet.add(c);
		int count = 0;
		for (char c : stones.toCharArray()) {
			if (jewelSet.contains(c))
				count++;
		}
		return count;
	}

}
