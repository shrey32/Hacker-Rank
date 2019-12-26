package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/MOZSAPAR/">MOZSAPAR - Sharmeen and
 * parentheses</a>
 * 
 * @author Shrey
 *
 */
public class SharmeenAndParenthesis {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			String s = scan.next();
			int count1 = 0, count2 = 0;
			for (char c : s.toCharArray()) {
				if ('(' == c || ')' == c)
					count1++;
				if ('?' == c)
					count2++;
			}
			String result = (count1 + count2) % 2 == 0 ? "yes" : "no";
			System.out.println(result);
		}
		scan.close();
	}

}
