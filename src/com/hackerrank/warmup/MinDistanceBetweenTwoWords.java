package com.hackerrank.warmup;

public class MinDistanceBetweenTwoWords {

	public static void main(String[] args) {
		String sent = "geeks for geeks contribute practice";
		String w1 = "geeks";
		String w2 = "practice";
		System.out.println(minDistance2(sent, w1, w2)); // 1
		sent = "the quick the brown quick brown the frog";
		w1 = "quick";
		w2 = "frog";
		System.out.println(minDistance2(sent, w1, w2));// 2
	}

	static int minDistance(String sent, String w1, String w2) {
		if (w1.equals(w2))
			return 0;
		String[] ar = sent.split(" ");
		int count = 0;
		for (String word : ar) {
			if (word.equals(w1)) {
				count = 0;
			} else if (word.equals(w2)) {
				return count;
			} else {
				count++;
			}
		}
		return count;
	}

	static int minDistance2(String sent, String w1, String w2) {
		if (w1.equals(w2))
			return 0;
		String[] ar = sent.split(" ");
		int min = ar.length + 1;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i].equals(w1)) {
				for (int j = 0; j < ar.length; j++) {
					if (ar[j].equals(w2)) {
						int dist = Math.abs(i - j) - 1;
						min = Math.min(min, dist);
					}
				}
			}
		}

		return min;

	}

}
