package com.leetcode.monthchallenge.may;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
public class Trie {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app"));
	}

	private class TrieNode {
		Map<Character, TrieNode> map = new HashMap<>(1);
		boolean isEndOfWord = false;
	}

	private TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode current = this.root;
		for (int i = 0; i < word.length(); i++) {
			char curr = word.charAt(i);
			if (!current.map.containsKey(curr))
				current.map.put(curr, new TrieNode());
			current = current.map.get(curr);
		}
		current.isEndOfWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode current = this.root;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			if (!current.map.containsKey(character))
				return false;
			current = current.map.get(character);
		}
		return current.isEndOfWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		return startsWith(prefix, this.root);
	}

	private boolean startsWith(String searchStr, TrieNode current) {
		if (current == null)
			return false;
		for (int i = 0; i < searchStr.length(); i++) {
			char character = searchStr.charAt(i);
			if (!current.map.containsKey(character))
				return false;
			current = current.map.get(character);
		}
		return true;
	}

}
