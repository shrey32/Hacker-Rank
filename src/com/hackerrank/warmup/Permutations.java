package com.hackerrank.warmup;

public class Permutations {

	public static void main(String[] args) {
		permutation("ABC");
	}

	static void permutation(String s) {
		if (s.length() == 0) {
			System.out.println("pass a valid string");
			return;
		}
		permutation("", s);
	}

	static void permutation(String prefix, String remaining) {
		if (remaining.length() == 0) {
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < remaining.length(); i++) {
			permutation(prefix + remaining.charAt(i), remaining.substring(0, i)
					+ remaining.substring(i + 1, remaining.length()));
		}
	}

}
