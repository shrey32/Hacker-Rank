package com.hackerrank.datastructures.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
public class Trie {

	private TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("the");
		trie.add("word");
		trie.add("warden");
		trie.add("their");
		trie.add("work");
		System.out.println(trie.all());
		System.out.println(trie.startsWith("wo"));
	}

	/**
	 * 
	 * @param word
	 */
	public void add(String word) {
		TrieNode current = this.root;
		for (int i = 0; i < word.length(); i++) {
			char curr = word.charAt(i);
			if (!current.map.containsKey(curr))
				current.map.put(curr, new TrieNode());
			current = current.map.get(curr);
		}
		current.isEndOfWord = true;
	}

	/**
	 * 
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		TrieNode current = this.root;
		for (int i = 0; i < word.length(); i++) {
			char curr = word.charAt(i);
			if (!current.map.containsKey(curr))
				return false;
			current = current.map.get(curr);
		}
		return current.isEndOfWord;
	}

	public boolean delete(String word) {
		TrieNode current = this.root;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			if (!current.map.containsKey(character))
				return false;
			current = current.map.get(character);
		}
		if (current != null) {
			current.isEndOfWord = false;
			return true;
		}
		return false;
	}

	public boolean delete(String word, TrieNode root, int ind) {
		if (ind == word.length())
			return true;
		char curr = word.charAt(ind);
		if (!root.map.containsKey(curr))
			return false;
		boolean result = delete(word, root.map.get(curr), ind++);
		if (result)
			root.map.remove(curr);
		return false;
	}

	public void clear() {
		this.root = new TrieNode();
	}

	public List<String> startsWith(String prefix) {
		return startsWith("", prefix, this.root);
	}

	public List<String> all() {
		return all(this.root);
	}

	public List<String> all(TrieNode root) {
		TrieNode current = root;
		if (current == null)
			return Arrays.asList();
		List<String> list = new LinkedList<>();
		for (Character c : current.map.keySet()) {
			list.addAll(startsWith(String.valueOf(c)));
		}
		return list;
	}

	public List<String> startsWith(String prefix, String word, TrieNode node) {
		TrieNode current = node;
		if (current == null)
			return Arrays.asList();
		List<String> list = new LinkedList<>();
		for (int i = 0; i < word.length(); i++) {
			char curr = word.charAt(i);
			if (!current.map.containsKey(curr))
				return Arrays.asList();
			current = current.map.get(curr);
		}
		if (current != null) {
			if (current.isEndOfWord)
				list.add(prefix + word);
			for (Character c : current.map.keySet()) {
				list.addAll(startsWith(prefix + word, String.valueOf(c), current));
			}
		}
		return list;
	}

	private static class TrieNode {
		Map<Character, TrieNode> map;
		boolean isEndOfWord = false;

		public TrieNode() {
			this.map = new HashMap<>(26);
		}

		@Override
		public String toString() {
			return "{end:" + isEndOfWord + ",chars:" + map.keySet() + "}";
		}
	}
}
