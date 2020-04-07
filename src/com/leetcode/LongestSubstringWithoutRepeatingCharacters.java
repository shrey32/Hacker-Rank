package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));//3
		System.out.println(lengthOfLongestSubstring("bbbb"));//1
		System.out.println(lengthOfLongestSubstring("pwwkew"));//3
		System.out.println(lengthOfLongestSubstring(""));// 0
		System.out.println(lengthOfLongestSubstring(" "));// 1
	}

	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Integer, Character> map2 = new HashMap<>();
		int len = 0;
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (map1.containsKey(curr)) {
				len = Math.max(len, map1.size());
				int ind = map1.get(curr);
				while(map2.containsKey(ind)) {
					int temp = ind;
					map1.remove(map2.get(temp));
					map2.remove(temp);
					ind--;
				}
			}
			map1.put(curr, i);
			map2.put(i, curr);
		}
		len = Math.max(len, map1.size());
		return len;
	}
}
