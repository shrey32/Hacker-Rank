package com.leetcode.monthchallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>LRU Cache</b>
 * 
 * <p>
 * <b>Solution</b>
 * </p>
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.<br>
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.<br>
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.<br>
 * 
 * <p>
 * The cache is initialized with a positive capacity.
 * </p>
 * 
 * <p>
 * <b>Follow up:</b>
 * </p>
 * <p>
 * Could you do both operations in O(1) time complexity?
 * </p>
 * 
 * <p>
 * <b>Example:</b>
 * </p>
 * 
 * <li>LRUCache cache = new LRUCache(2);</li>
 * <li>cache.put(1, 1);</li>
 * <li>cache.put(2, 2);</li>
 * <li>cache.get(1); // returns 1</li>
 * <li>cache.put(3, 3); // evicts key 2</li>
 * <li>cache.get(2); // returns -1 (not found)</li>
 * <li>cache.put(4, 4); // evicts key 1</li>
 * <li>cache.get(1); // returns -1 (not found)</li>
 * <li>cache.get(3); // returns 3</li>
 * <li>cache.get(4); // returns 4</li>
 * 
 * @author Shrey
 *
 */
public class LRUCache {

	class Node {
		int key;
		int value;
		Node prev;
		Node next;

		Node(int k, int v) {
			key = k;
			value = v;
		}
	}

	private Map<Integer, Node> map = new HashMap<>();
	private Node head;
	private Node last;
	private int capacity;

	public LRUCache(final int capacity) {
		this.capacity = capacity;
		head = new Node(0, 0);
		last = new Node(0, 0);
		head.next = last;
		last.prev = head;
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1;
		}
		remove(node);
		insert(node);
		return node.value;
	}

	private void insert(Node node) {
		map.put(node.key, node);
		node.next = head.next;
		head.next.prev = node;
		node.prev = head;
		head.next = node;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
		}
		if (map.size() == capacity) {
			remove(last.prev);
		}
		insert(new Node(key, value));
	}

	private void remove(Node node) {
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

}
