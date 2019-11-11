package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/two-characters/problem">Two
 * Characters</a>
 * 
 * @author Shrey
 *
 */
public class TwoCharacters {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		bufferedReader.readLine();
		String s = bufferedReader.readLine();

		int result = alternate(s);

		System.out.println(result);
		bufferedReader.close();
	}

	final static int alternate(String s) {

		List<Character> list = IntStream.range(0, s.length()).mapToObj(i -> new Character(s.charAt(i))).distinct()
				.collect(Collectors.toList());

		int size = list.size();
		int max = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(list.get(i));
				sb.append(list.get(j));
				StringBuilder result = get(s, sb.toString());
				if (validate(result.toString()))
					max = Math.max(max, result.length());
			}
		}
		return max;
	}

	final static StringBuilder get(String s, String r1) {
		Pattern p = Pattern.compile("[" + r1 + "]{1,}");
		Matcher m = p.matcher(s);
		StringBuilder sb = new StringBuilder();
		while (m.find()) {
			sb.append(m.group());
		}
		return sb;
	}

	final static boolean validate(String s) {
		for (int i = 0; i < s.length() - 1; i++)
			if (s.charAt(i) == s.charAt(i + 1))
				return false;
		return true;
	}

}
