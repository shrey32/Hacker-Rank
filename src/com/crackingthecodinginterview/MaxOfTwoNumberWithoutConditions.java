package com.crackingthecodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class MaxOfTwoNumberWithoutConditions {

	public static void main(String[] args) {
		System.out.println(max(5, 6));
		System.out.println(max(6, 5));
	}

	public static int max(int a, int b) {
		return ((a + b) + (Math.abs(a - b))) / 2;
	}

}
