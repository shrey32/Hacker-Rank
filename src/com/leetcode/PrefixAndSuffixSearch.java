package com.leetcode;

import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
public class PrefixAndSuffixSearch {

	private TrieNode root;

	public PrefixAndSuffixSearch(String[] words) {
		this.root = new TrieNode();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				String w = new StringBuilder(word.substring(j)).append("#").append(word).toString();
				insert(w, i);
			}
		}
	}

	public static void main(String[] args) {

	}

	public int search(String pre, String suff) {
		return search(suff + "#" + pre);
	}

	private int search(String word) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (!curr.map.containsKey(c))
				return -1;
			curr = curr.map.get(c);
		}
		return curr.index;
	}

	public void insert(String word, int index) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (!curr.map.containsKey(c))
				curr.map.put(c, new TrieNode());
			curr.map.get(c).index = 1;
			curr = curr.map.get(c);
		}
		curr.index = index;
	}

	private static class TrieNode {
		private int index;
		private Map<Character, TrieNode> map;
	}

}
