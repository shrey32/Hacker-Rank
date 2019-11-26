package com.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/MOZSLM/">MOZSLM - Sharmeen Loves
 * Mozahid Loves Sharmeen [ EASY ]</a>
 * 
 * @author Shrey
 *
 */
public class MOZSLM {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			String s = scan.next();
			System.out.println(bruteForce(s));
		}
		scan.close();
	}

	static final int orderOfN(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray())
			if (c == 's' || c == 'm')
				map.put(c, map.getOrDefault(c, 0) + 1);
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != 's')
				continue;
			// find next s before m
			int scount = 1;
			int j = i + 1;
			while (j < s.length() && s.charAt(j) != 'm') {
				if (s.charAt(j) == 's')
					scount++;
				j++;
			}
			// find next m count before s
			int mcount = 1;
			int k = j + 1;
			while (k < s.length() && s.charAt(k) != 's') {
				if (s.charAt(k) == 'm')
					mcount++;
				k++;
			}
			map.put('s', map.get('s') - scount);
			count += (map.get('s') * scount) * mcount;
			i = k-1;
		}

		return count;
	}

	static final int bruteForce(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if ('s' != s.charAt(i))
				continue;
			for (int j = i + 1; j < s.length(); j++) {
				if ('m' != s.charAt(j))
					continue;
				for (int k = j + 1; k < s.length(); k++) {
					if ('s' != s.charAt(k))
						continue;
					count++;
				}
			}
		}
		return count;
	}

}
