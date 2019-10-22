package com.hackerrank.warmup;

import java.util.LinkedList;
import java.util.Queue;

public class RegexSample {

	public static void main(String[] args) {
		System.out.println(matches("abc", "ab*")); // true
		System.out.println(matches("aba", "ab")); // false
		System.out.println(matches("aa", "a*")); // true
		System.out.println(matches("ab", ".*")); // true
		System.out.println(matches("ab", ".")); // false
		System.out.println(matches("aaa", "a*.")); // true
		System.out.println(matches("aab", "c*a*b")); // true
	}

	static boolean matches(String s, String p) {
		if (p.trim().length() == 0 || s.trim().length() == 0)
			return false;

		Queue<String> queue = new LinkedList<>();
		for (int i = 0; i < p.length(); i++) {
			String chars = p.charAt(i) + "";
			queue.add(chars);
		}

		String anyChar = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < s.length(); i++) {
			String chars = s.charAt(i) + "";
			if (".".equals(queue.peek())) {
				if (anyChar.indexOf(chars) < 0)
					return false;
			} else if ("*".equals(queue.peek())) {
				if (i > 0)
					chars = s.charAt(i - 1) + "";
				for (int j = i + 1; j < s.length(); j++) {
					if (!chars.equals(s.charAt(j) + ""))
						return false;
				}
			} else if (queue.peek() != null
					&& anyChar.indexOf(queue.peek()) >= 0) { // comes under a-z
				if (!chars.equals(queue.peek()))
					return false;
			} else if (queue.isEmpty()) {
				return false;
			}
			queue.poll();
		}
		return true;
	}
}
