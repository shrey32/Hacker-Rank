package com.spoj.basics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 
 * <a href="https://www.spoj.com/problems/RG11/">RG11 - SORT FREQUENCY OF
 * INTEGER GRADO 11</a>
 * 
 * @author Shrey
 *
 */
public class SortFrequency {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		while (n-- > 0) {
			int in = scan.nextInt();
			frequencyMap.put(in, frequencyMap.getOrDefault(in, 0) + 1);
		}
		System.out.println(frequencyMap.values().stream().sorted(Comparator.reverseOrder()).map(String::valueOf)
				.collect(Collectors.joining(" ")));
		scan.close();
	}

}
