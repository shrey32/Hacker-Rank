package com.leetcode.monthchallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <b>Group Anagrams</b>
 * <p>
 * .Given an array of strings, group anagrams together.
 * </p>
 * 
 * <b>Example:</b>
 * 
 * <p>
 * <b>Input:</b> ["eat", "tea", "tan", "ate", "nat", "bat"]
 * </p>
 * <p>
 * <b> Output:</b> [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 * </p>
 * <p>
 * <b>Note:</b>
 * 
 * All inputs will be in lowercase. The order of your output does not matter.
 * </p>
 * 
 * @author Shrey
 *
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		System.out.println(groupAnagrams(new String[] { "", "" }));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] letters = letters(s);

			String ns = new String(letters);

			if (!map.containsKey(ns)) {
				map.put(ns, new ArrayList<>());
			}
			map.get(ns).add(s);
		}

		for (List<String> list : map.values()) {
			result.add(list.stream().sorted().collect(Collectors.toList()));
		}

		return result.stream().sorted((a, b) -> a.size() - b.size()).collect(Collectors.toList());

	}

	private static char[] letters(String s) {
		char[] letters = new char[26];
		for (char c : s.toCharArray()) {
			letters[c - 'a']++;
		}
		return letters;
	}

}
