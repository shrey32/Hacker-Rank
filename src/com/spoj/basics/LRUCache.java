package com.spoj.basics;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

	private final Map<K, Node<K, V>> cache;
	private Node<K, V> head, tail;
	private int size = 4;

	public LRUCache() {
		cache = new HashMap<>(size);
	}

	public LRUCache(int size) {
		this.size = size;
		cache = new HashMap<>(size);
	}

	public final void put(K key, V value) {
		Node<K, V> node = null;
		if (!cache.containsKey(key)) {
			node = new Node<>(key, value);
		} else {
			node = cache.get(key);
			node.value = value;
		}
		if (this.head == null) {// first
			this.head = node;
			this.tail = node;
		} else {
			Node<K, V> temp = this.head;
			temp.prev = node;
			this.head = node;
			this.head.next = temp;
		}
		cache.put(key, node);
		if (cache.size() > size) {// remove the element from the tail
			Node<K, V> tempTail = this.tail.prev;
			cache.remove(this.tail.key);
			this.tail = tempTail;
			this.tail.next = null;
		}
	}

	public final V get(K key) {
		if (!this.cache.containsKey(key))
			return null;

		Node<K, V> node = this.cache.get(key);

		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			this.head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			this.tail = node.prev;
		}

		node.next = this.head;
		node.prev = null;
		if (this.head != null)
			this.head.prev = node;

		this.head = node;
		if (this.tail == null)
			this.tail = head;

		return node.value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<K, V> temp = this.head;
		while (temp != null) {
			sb.append(temp.value + " ");
			temp = temp.next;
		}
		sb.append("\n");
		/*
		 * temp = this.tail; while (temp != null) { sb.append(temp.value + " "); temp =
		 * temp.prev; }
		 */
		return sb.toString();
	}

	private static class Node<K, V> {
		private K key;
		private V value;
		private Node<K, V> prev;
		private Node<K, V> next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		LRUCache<Integer, String> cache = new LRUCache<>();
		cache.put(1, "One");
		cache.put(2, "Two");
		cache.put(3, "Three");
		cache.put(4, "Four");
		cache.put(5, "Five");

		System.out.println(cache);
		
		System.out.println(cache.get(3));

		System.out.println(cache);
	}

}
