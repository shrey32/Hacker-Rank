package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class DesignHashMap {

	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		System.out.println(hashMap.get(1)); // returns 1
		System.out.println(hashMap.get(3)); // returns -1 (not found)
		hashMap.put(2, 1); // update the existing value
		System.out.println(hashMap.get(2)); // returns 1
		hashMap.remove(2); // remove the mapping for 2
		System.out.println(hashMap.get(2));
	}

	public static class MyHashMap {

		private int[] entries;

		/** Initialize your data structure here. */
		public MyHashMap() {
			entries = new int[1000000];
			Arrays.fill(entries, -1);
		}

		/** value will always be non-negative. */
		public void put(int key, int value) {
			int hashcode = hashcode(key);
			entries[hashcode] = value;
		}

		/**
		 * Returns the value to which the specified key is mapped, or -1 if this map
		 * contains no mapping for the key
		 */
		public int get(int key) {
			return entries[key];
		}

		/**
		 * Removes the mapping of the specified value key if this map contains a mapping
		 * for the key
		 */
		public void remove(int key) {
			entries[key] = -1;
		}

		private int hashcode(int key) {
			return key;
		}

	}

}
