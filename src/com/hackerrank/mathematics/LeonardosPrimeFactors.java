package com.hackerrank.mathematics;

/**
 * Leonardo loves primes and created  queries where each query takes the form of an integer, . For each , he wants you to count the maximum number of unique prime factors of any number in the inclusive range  and then print this value on a new line.

 Note: Recall that a prime number is only divisible by  and itself, and  is not a prime number.

 Input Format

 The first line contains an integer, , denoting the number of queries. 
 Each line  of the  subsequent lines contains a single integer, .

 Constraints

 Output Format

 For each query, print the maximum number of unique prime factors for any number in the inclusive range  on a new line.

 Sample Input

 6
 1
 2
 3
 500
 5000
 10000000000
 Sample Output

 0
 1
 1
 4
 5
 10
 Explanation

 The maximum number of unique prime factors of any number in the inclusive range  is , because  is not prime and its only factor is itself.
 The maximum number of unique prime factors of any number in the inclusive range  is . We already know that the number  has  prime factors, but  has  prime factor (itself).
 The maximum number of unique prime factors of any number in the inclusive range  is . The number  has  prime factor (itself), and we already know that the number  has  prime factor and the number  has  prime factors.
 The maximum number of unique prime factors in the inclusive range  is . The product of our first four unique primes is , and there are no additional unique primes we can multiply that number by that results in a value .
 */
/**
 * 
 * @author Shrey
 *
 */
public class LeonardosPrimeFactors {

	public static void main(String[] args) {
		System.out.println(primeCount(5000));
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	static int primeCount(long n) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };
		int count = 0;
		long product = 1;
		for (int i : prime) {
			product *= i;
			if (product <= n) {
				count++;
			}
		}
		return count;
	}

}
