package com.crackingthecodinginterview;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * You have a large text file containing words. Given any two words, find the
 * shortest distance (in terms of number of words) between them in the file. If
 * the operation will be repeated many times for the same file (but different
 * pairs of words), can you optimize your solution?
 * 
 * @author Shrey
 *
 */
public class WordDistance {

	public static void main(String[] args) {

	}

	public static int minWordDistance(String a, String b, Map<String, List<Integer>> occurrences) {
		Iterator<Integer> itrA = occurrences.get(a).iterator();
		Iterator<Integer> itrB = occurrences.get(b).iterator();
		int minDistance = Integer.MIN_VALUE;
		int nextA = itrA.next();
		int nextB = itrB.next();
		while (itrA.hasNext() && itrB.hasNext()) {
			minDistance = Math.min(minDistance, Math.abs(nextA - nextB));
			if (nextA > nextB) {
				nextB = itrB.next();
			} else {

				nextA = itrA.next();
			}
		}
		return minDistance;
	}

}
