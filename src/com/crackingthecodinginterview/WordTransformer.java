package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Shrey
 *
 */
public class WordTransformer {

	public static void main(String[] args) {
		System.out.println(transform("DAMP", "LIKE", Arrays.asList("LAMP", "LIMP", "LIME", "LIKE")));
		System.out.println(transform("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
	}

	public static List<String> transform(String begin, String end, List<String> words) {
		if (begin.length() == 0 || end.length() == 0 || begin.equals(end))
			return Arrays.asList();
		List<String> result = new ArrayList<>();
		Set<String> set = new HashSet<>(words);
		Queue<String> q = new LinkedList<>();
		q.add(begin);
		result.add(begin);
		while (!q.isEmpty()) {
			String curr = q.poll();
			final StringBuilder adj = new StringBuilder("");
			for (String next : set) {
				if (isAdjacent(curr, next)) {
					result.add(next);
					adj.append(next);
					q.offer(next);
					if (next.equals(end))
						return result;
					break;
				}
			}
			if (!"".equals(adj.toString())) {
				set.remove(adj.toString());
			}
		}
		return result;
	}

	/**
	 * 
	 * @param curr
	 * @param next
	 * @return
	 */
	private static boolean isAdjacent(String curr, String next) {
		int count = 0;
		for (int i = 0; i < curr.length(); i++) {
			if (curr.charAt(i) != next.charAt(i))
				count++;
			if (count > 1)
				return false;
		}
		return true;
	}

}
