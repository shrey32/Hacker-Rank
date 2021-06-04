package com.leetcode;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class OpenTheLock {

	public static void main(String[] args) {

	}

	public static int openLock(String[] deadends, String target) {
		Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
		if (deadSet.contains("0000"))
			return -1;
		Queue<String> queue = new LinkedList<>();
		queue.add("0000");
		int steps = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String temp = queue.poll();
				if (temp.equals(target))
					return steps;
				List<String> next = next(temp);
				for (String nxt : next) {
					if (deadSet.contains(nxt))
						continue;
					deadSet.add(nxt);
					queue.offer(nxt);
				}
			}
			++steps;
		}
		return -1;
	}

	private static List<String> next(String code) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int x = code.charAt(i) - '0';
			for (int diff = -1; diff <= 1; diff += 2) {
				int y = (x + diff + 10) % 10;
				result.add(code.substring(0, i) + ("" + y) + code.substring(i + 1));
			}
		}
		return result;
	}

}
