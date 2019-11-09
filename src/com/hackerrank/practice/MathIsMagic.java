package com.hackerrank.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/NJEG1/">NJEG1 - Maths is Magic</a>
 * 
 * @author Shrey
 *
 */
public class MathIsMagic {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			String[] cards = new String[27];
			for (int i = 1; i < cards.length; i++)
				cards[i] = scan.next();
			String[] plate = new String[3];
			for (int i = 0; i < plate.length; i++)
				plate[i] = scan.next();
			System.out.println(solve(cards, plate));
		}
		scan.close();
	}

	private static final String solve(String[] cards, String[] plate) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("J", 1);
		map.put("Q", 2);
		map.put("K", 3);
		map.put("A", 4);
		int n = cards.length - 1;

		int index = 0;
		for (int i = 0; i < plate.length; i++) {
			String a = plate[i];
			int card = map.containsKey(a) ? map.get(a) : Integer.valueOf(a);
			n = n - 1 - (10 - card);
			index += card;
		}
		String ans = cards[index - n];
		return map.containsKey(ans) ? map.get(ans) + "" : ans;
	}

}
