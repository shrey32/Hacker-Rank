package com.geekforgeeks.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/word-boggle/0">Word
 * Boggle</a>
 * 
 * @author Shrey
 *
 */
public class WordBoggle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int len = scan.nextInt();
			Map<String, Map<Character, Integer>> wordFreqMap = new LinkedHashMap<>();
			for (int i = 0; i < len; i++) {
				String word = scan.next();
				wordFreqMap.put(word, getFrequency(word));
			}
			int n = scan.nextInt();
			int m = scan.nextInt();
			Map<Character, Integer> freqMap = new HashMap<>();
			for (int i = 0; i < n * m; i++) {
				char curr = scan.next().trim().charAt(0);
				freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);
			}

			List<String> result = new ArrayList<>();
			for (String word : wordFreqMap.keySet()) {
				Map<Character, Integer> currWordFreqMap = wordFreqMap.get(word);
				boolean exist = true;
				for (char curr : word.toCharArray()) {
					if (!freqMap.containsKey(curr) || currWordFreqMap.get(curr) > freqMap.get(curr)) {
						exist = false;
						break;
					}
				}
				if (exist)
					result.add(word);
			}
			if (result.isEmpty())
				System.out.println(-1);
			System.out.println(result.stream().sorted((a, b) -> ((Integer) a.length()).compareTo(b.length()))
					.collect(Collectors.joining(" ")));
		}
		scan.close();
	}

	private static final Map<Character, Integer> getFrequency(String s) {
		Map<Character, Integer> frequencies = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			frequencies.put(curr, frequencies.getOrDefault(curr, 0) + 1);
		}
		return frequencies;
	}

}
