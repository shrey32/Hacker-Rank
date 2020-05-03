package com.leetcode.monthchallenge.may;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Ransom Note</b>
 * <p>
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * </p>
 * 
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * </p>
 * 
 * <b>Note:</b>
 * <p>
 * You may assume that both strings contain only lowercase letters.
 * </p>
 * 
 * <li>canConstruct("a", "b") -> false</li>
 * <li>canConstruct("aa", "ab") -> false</li>
 * <li>canConstruct("aa", "aab") -> true</li>
 * 
 * @author Shrey
 *
 */
public class RansomNote {

	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));// false
		System.out.println(canConstruct("aa", "ab"));// false
		System.out.println(canConstruct("aa", "aab"));// true
	}

	public static boolean canConstruct(String r, String m) {
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		for (char c : r.toCharArray())
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		for (char c : m.toCharArray())
			map2.put(c, map2.getOrDefault(c, 0) + 1);

		for (char c : r.toCharArray()) {
			if (!map2.containsKey(c) || map2.get(c) < map1.get(c))
				return false;
		}
		return true;
	}

}
