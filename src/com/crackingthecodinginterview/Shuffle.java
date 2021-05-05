package com.crackingthecodinginterview;

import java.util.Arrays;
import java.util.Random;

/***
 * 
 * @author Shrey
 *
 */
public class Shuffle {

	public static void main(String[] args) {
		int[] cards = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		shuffle(cards);
		System.out.println(Arrays.toString(cards));
	}

	public static void shuffle(int[] cards) {
		Random rand = new Random();
		for (int i = cards.length; i > 0; i--) {
			int swap = rand.nextInt(i);
			int temp = cards[i - 1];
			cards[i - 1] = cards[swap];
			cards[swap] = temp;
		}
	}

}
