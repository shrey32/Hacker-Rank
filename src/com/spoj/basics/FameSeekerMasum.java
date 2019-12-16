package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/MASUM01/">MASUM01 - Fame seeker
 * Masum</a>
 * 
 * @author Shrey
 *
 */
public class FameSeekerMasum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String constant = "masum";
		String name = scan.next();
		int j = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (j < constant.length() && c == constant.charAt(j))
				j++;
			else
				result.append((i + 1) + " ");
		}
		System.out.println(result.length() == 0 ? "Nothing to delete" : result);
		scan.close();
	}

}
