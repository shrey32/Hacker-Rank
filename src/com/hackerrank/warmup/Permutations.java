package com.hackerrank.warmup;

import java.util.Set;

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
			permutation(prefix + remaining.charAt(i),
					remaining.substring(0, i) + remaining.substring(i + 1, remaining.length()));
		}
	}

	public static void permutation(String[] prefix, String[] remaining, Set<String> set) {

		if (remaining.length == 0) {
			StringBuilder sb = new StringBuilder();
			for (String s : prefix)
				sb.append(s);
			set.add(sb.toString());
			return;
		}
		for (int i = 0; i < remaining.length; i++) {
			String[] s = new String[prefix.length + 1];
			System.arraycopy(prefix, 0, s, 0, prefix.length);
			s[s.length - 1] = remaining[i];

			String[] rem = new String[remaining.length - 1];
			for (int j = 0, k = 0; j < remaining.length; j++) {
				if (j == i)
					continue;
				rem[k++] = remaining[j];
			}
			permutation(s, rem, set);
		}
	}

}
