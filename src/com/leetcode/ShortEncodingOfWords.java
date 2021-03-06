package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Shrey
 *
 */
public class ShortEncodingOfWords {

	public static void main(String[] args) {
		System.out.println(minimumLengthEncoding(new String[] { "time", "me", "bell" }));
		System.out.println(minimumLengthEncoding(new String[] { "t" }));
	}

	public static int minimumLengthEncoding(String[] words) {
		Set<String> set = new HashSet<>(Arrays.asList(words));
		for (String word : words)
			if (set.contains(word))
				for (int i = 1; i < word.length(); i++)
					set.remove(word.substring(i));
		int ans = set.size();
		for (String word : set)
			ans += word.length();
		return ans;
	}

}
