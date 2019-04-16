package com.hackerrank.warmup;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class NonRepeatingCharacter {

	public static void main(String[] args) {
		String s = "GeeksforGeeks";
		System.out.println(firstNonRepeatingChar(s));// f
		s = "GeeksQuiz";
		System.out.println(firstNonRepeatingChar(s));// G
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	static String firstNonRepeatingChar(String s) {
		if (s == null || s.trim().length() == 0)
			return null;
		LinkedHashMap<String, List<String>> map = s
				.chars()
				.mapToObj(c -> String.valueOf((char) c))
				.collect(
						Collectors.groupingBy(String::valueOf,
								LinkedHashMap::new, Collectors.toList()));
		return map.keySet().stream().filter(key -> map.get(key).size() == 1)
				.findFirst().get();
	}

}
