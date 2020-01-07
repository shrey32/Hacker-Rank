package com.geekforgeeks.google;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/word-break/0">Word
 * Break</a>
 * 
 * @author Shrey
 *
 */
public class WordBreak {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			Set<String> set = new HashSet<>();
			StringBuilder sb = new StringBuilder();
			while (n-- > 0) {
				String str = scan.next();
				sb.append(str);
				set.add(str);
			}
			String input = scan.next();
			if (set.contains(input))
				System.out.println(1);
			else {
				String search = input;
				if (sb.length() < input.length()) {
					search = input;
				}
				StringBuilder iden = new StringBuilder();
				for (int i = 0; i < search.length(); i++) {
					char curr = search.charAt(i);
					iden.append(curr);
					if (set.contains(iden.toString())) {
						iden = new StringBuilder();
					}
				}
				System.out.println(iden.length() > 0 ? 0 : 1);
			}
		}
		scan.close();
	}

}
