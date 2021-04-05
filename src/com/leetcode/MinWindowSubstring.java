package com.leetcode;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 
 * @author Shrey
 *
 */
public class MinWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ab", "b"));
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("ab", "a"));
	}

	public static String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || s.length() < t.length())
			return "";

		Map<Character, Integer> freq = new HashMap<>(t.length());
		for (char ch : t.toCharArray())
			freq.put(ch, freq.getOrDefault(ch, 0) + 1);

		PriorityQueue<Comb> q = new PriorityQueue<>((a, b) -> a.ind - b.ind);
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (freq.containsKey(cur))
				q.offer(new Comb(cur, i));
		}
		if (q.isEmpty())
			return "";
		String res = s;
		while (!q.isEmpty()) {
			Comb curr = q.poll();
			Map<Character, Integer> freq1 = new HashMap<>(freq);
			int start = curr.ind;
			int len = 0;
			for (int i = start; i < s.length(); i++) {
				char c = s.charAt(i);
				if (freq1.containsKey(c) && freq1.get(c) > 0) {
					freq1.put(c, freq1.get(c) - 1);
					len++;
				}
				if (len == t.length()) {
					String sub = s.substring(start, i + 1);
					if (len == 1)
						sub = curr.c + "";
					//System.out.println("==>" + sub);
					if (res.length() >= sub.length())
						res = sub;
					break;
				}
			}
		}
		return res;
	}

	public static class Comb {
		char c;
		int ind;

		public Comb(char c, int ind) {
			this.c = c;
			this.ind = ind;
		}
	}

}
