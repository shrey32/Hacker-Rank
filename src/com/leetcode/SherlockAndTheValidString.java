package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author Shrey
 *
 */
public class SherlockAndTheValidString {

	public static void main(String[] args) {
		System.out.println(isValid("aabbcd"));
		System.out.println(isValid("abcdefghhgfedecba"));
		System.out.println(isValid("aabbccddeefghi"));
	}

	private static String isValid(String s) {
		if (s.isEmpty())
			return "NO";
		if (s.length() <= 3)
			return "YES";
		Map<Character, Long> map = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		map = map.entrySet().stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));

		Long min = map.values().stream().max(Comparator.reverseOrder()).get();
		Long max = map.values().stream().max(Comparator.naturalOrder()).get();
		List<Long> list = new ArrayList<>(map.values());
		if (min == max)
			return "YES";
		else if (max - min == 1 && max > list.get(list.size() - 2)) {
			return "YES";
		}
		return "NO";
	}

}
