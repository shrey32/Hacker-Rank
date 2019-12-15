package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/PLABON01/">PLABON01 - Plabon the rich
 * man</a>
 * 
 * @author Shrey
 *
 */
public class PlabonTheRichMan {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int j = scan.nextInt();

			int total = n * m;
			int each = total / j;
			int totalDivided = each * j;
			System.out.println(totalDivided>0?totalDivided:total);
		}
		scan.close();
	}

}
