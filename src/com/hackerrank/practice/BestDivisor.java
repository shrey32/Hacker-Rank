package com.hackerrank.practice;

/**
 * Kristen loves playing with and comparing numbers. She thinks that if she takes two different positive numbers, the one whose digits sum to a larger number is better than the other. If the sum of digits is equal for both numbers, then she thinks the smaller number is better. For example, Kristen thinks that  is better than  and that  is better than .

Given an integer, , can you find the divisor of  that Kristin will consider to be the best?

Input Format

A single integer denoting .

Constraints

Output Format

Print an integer denoting the best divisor of .

Sample Input 0

12
Sample Output 0

6
Explanation 0

The set of divisors of  can be expressed as . The divisor whose digits sum to the largest number is  (which, having only one digit, sums to itself). Thus, we print  as our answer.
 */
/**
 * 
 * @author Shrey
 *
 */
public class BestDivisor {

	public static void main(String[] args) {

		System.out.println(bestDivisor(12));

	}

	static int bestDivisor(int n) {
		int best = Integer.MIN_VALUE;
		int bestDivisor = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				int sum = sumOfDigits(i);
				if (sum > best) {
					best = sum;
					bestDivisor = i;
				}
			}
		}
		return bestDivisor;
	}

	static int sumOfDigits(int n) {
		int sum;
		for (sum = 0; n != 0; n /= 10) {
			sum += n % 10;
		}
		return sum;
	}

}
