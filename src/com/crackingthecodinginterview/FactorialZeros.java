package com.crackingthecodinginterview;

/**
 * 
 * <p>
 * Write an algorithm which computes the number of trailing zeros in n
 * factorial.
 * </p>
 * 
 * @author Shrey
 *
 */
public class FactorialZeros {

	public static void main(String[] args) {
		System.out.println(trailingZerosInFact(5));//1
		System.out.println(trailingZerosInFact(10));//2
		System.out.println(trailingZerosInFact(15));//3
		System.out.println(trailingZerosInFact(38));//3
	}

	public static int trailingZerosInFact(int n) {
		return n/5;
	}

}
