package com.hackerrank.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Problem Statement

 Jim enters a candy shop which has N different types of candies, each candy is of the same price. Jim has enough money to buy K candies.
 In how many different ways can he purchase K candies if there are infinite candies of each kind?

 Input Format 
 The first line contains an integer T, the number of tests. 
 This is followed by 2T lines which contain T tests: 
 The first line (of each testcase) is an integer N and the second line (of each testcase) is an integer K.

 Output Format 
 For each testcase, print the number of ways Jim can buy candies from the shop in a newline. If the answer has more than 9 digits, print 
 the last 9 digits.

 Note 
 This problem may expect you to have solved nCr Table

 Constraints 
 1 <= T <= 200 
 1 <= N < 1000 
 1 <= K < 1000

 Sample Input

 2
 4
 1
 2
 3
 Sample Output

 4
 4
 Explanation 
 There are 2 testcases, for the first testcase we have N = 4 and K = 1, as Jim can buy only 1 candy, he can choose to buy any of the 4 types of
 candies available. Hence, his answer is 4. For the 2nd testcase, we have N = 2 and K = 3, If we name two chocolates as a and b, he can buy

 aaa bbb aab abb 
 chocolates, hence 4.
 */
/**
 * 
 * @author Shrey
 *
 */
public class KCandyStore {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for (int j = 0; j < t; j++) {
			BigInteger n = BigInteger.valueOf(Long.parseLong(br.readLine()
					.trim()));
			BigInteger k = BigInteger.valueOf(Long.parseLong(br.readLine()
					.trim()));
			BigInteger ways = fact(n.add(k).subtract(BigInteger.ONE)).divide(
					(fact(n.subtract(BigInteger.ONE)).multiply(fact(k))));
			System.out.println(ways.mod(new BigInteger("1000000000")));
		}
		br.close();
	}

	private static BigInteger fact(BigInteger number) {
		BigInteger a = BigInteger.ONE;
		for (int i = 1; i <= number.intValue(); i++) {
			a = a.multiply(BigInteger.valueOf(i));
		}
		return a;
	}

}
