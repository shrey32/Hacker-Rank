package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/URJC2_D/">URJC2_D - Keyboard
 * Writing</a>
 * 
 * @author Shrey
 *
 */
public class KeyboardTyping {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			boolean[] letters = new boolean[26];
			String known = scan.next();
			for (char c : known.toCharArray())
				letters[c - 'a'] = true;
			long time = 0;
			String test = scan.next();
			for (char c : test.toCharArray()) {
				int letter = c - 'a';
				if (letters[letter])
					time += 50;
				else {
					letters[letter] = true;
					time += 150;
				}
			}
			System.out.println(time);
		}
		scan.close();
	}

}
