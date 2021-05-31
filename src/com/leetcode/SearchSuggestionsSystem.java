package com.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Shrey
 *
 */
public class SearchSuggestionsSystem {

	public static void main(String[] args) {
		String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		System.out.println(suggestedProducts(products, "mouse"));
	}

	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		TrieNode root = new TrieNode();
		// insert
		for (String product : products) {
			insert(root, product);
		}
		List<List<String>> result = new ArrayList<>();
		for (int i = 0; i < searchWord.length(); i++) {
			String prefix = searchWord.substring(0, i + 1);
			// System.out.println("pref=>"+prefix);
			List<String> searchResult = prefixSearch(root, prefix);
			result.add(searchResult);
		}
		return result;
	}

	private static void insert(TrieNode root, String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char curr = word.charAt(i);
			if (!current.map.containsKey(curr))
				current.map.put(curr, new TrieNode());
			current = current.map.get(curr);
		}
		current.isEnd = true;
	}

	public static List<String> prefixSearch(TrieNode root, String prefix) {
		List<String> searchRes = new ArrayList<>();
		prefixSearch("", prefix, root, searchRes);
		return searchRes;
	}

	private static void prefixSearch(String prefix, String word, TrieNode node, List<String> searchRes) {
		TrieNode current = node;
		if (current == null || searchRes.size() == 3)
			return;
		for (int i = 0; i < word.length(); i++) {
			char curr = word.charAt(i);
			if (!current.map.containsKey(curr))
				return;
			current = current.map.get(curr);
		}
		if (current != null) {
			if (current.isEnd && searchRes.size() < 3)
				searchRes.add(prefix + word);
			for (Character c : current.map.keySet()) {
				List<String> temp = new ArrayList<>();
				prefixSearch(prefix + word, String.valueOf(c), current, temp);
				if (!temp.isEmpty()) {
					int i = 0;
					while (searchRes.size() < 3 && i < temp.size()) {
						searchRes.add(temp.get(i++));
					}
				}
			}
		}
	}

	private static class TrieNode {
		Map<Character, TrieNode> map;
		boolean isEnd = false;

		TrieNode() {
			map = new TreeMap<>();
		}
	}

}
