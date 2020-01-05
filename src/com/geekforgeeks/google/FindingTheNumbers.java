package com.geekforgeeks.google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <a href=
 * "https://practice.geeksforgeeks.org/problems/finding-the-numbers/0">Finding
 * the numbers</a>
 * 
 * @author Shrey
 *
 */
public class FindingTheNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			Map<Integer, Integer> map = new HashMap<>();
			int n = scan.nextInt();
			for (int i = 0; i < ((2 * n) + 2); i++) {
				int num = scan.nextInt();
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
			List<String> result = map.keySet().stream().filter(key -> map.get(key) % 2 != 0).sorted()
					.map(String::valueOf).collect(Collectors.toList());
			System.out.println(result.stream().collect(Collectors.joining(" ")));
		}
		scan.close();
	}

}
