package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Shrey
 *
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		return new ArrayList<>(
				Arrays.stream(strs).collect(Collectors.groupingBy(str -> getKey(str), Collectors.toList())).values());
	}

	public static String getKey(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

}
