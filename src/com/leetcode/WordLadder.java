package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class WordLadder {

	public static void main(String[] args) {

		System.out.println(ladderLength("hit", "cog", test1()));// 5
		System.out.println(ladderLength("hit", "cog", test2()));// 0
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		if (beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0)
			return 0;

		Queue<Word> queue = new LinkedList<>();
		queue.add(new Word(beginWord, 1));
		while (!queue.isEmpty()) {
			Word curr = queue.poll();
			ListIterator<String> itr = wordList.listIterator();
			while (itr.hasNext()) {
				String next = itr.next();
				if (isAdjacent(curr.word, next)) {
					queue.add(new Word(next, curr.length + 1));
					itr.remove();
					if (next.equals(endWord))
						return curr.length + 1;
				}
			}
		}
		return 0;
	}

	private static class Word {
		String word;
		int length;

		public Word(String word, int length) {
			this.word = word;
			this.length = length;
		}
	}

	private static boolean isAdjacent(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				count++;
			if (count > 1)
				return false;
		}
		return count > 1 ? false : true;
	}

	private static List<String> test1() {
		List<String> list = new ArrayList<>();
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");
		return list;
	}

	private static List<String> test2() {
		List<String> list = new ArrayList<>();
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		return list;
	}

}
