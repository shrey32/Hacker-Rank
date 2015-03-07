package com.hackerrank.probability;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 Mehta is a very lazy boy. He always sleeps in Maths class. One day his teacher catches him sleeping and tells him that she would mark him absent for the whole semester. While she pretends to be strict, she is actually very kind-hearted. So she wants to give Mehta a chance to prove himself. She gives him a problem. If Mehta can answer it correctly, she will forgive him. Can you help Mehta find the answer to this problem?

 The problem: The teacher gives Mehta a number N and asks him to find out the probability that any proper divisor of N would be an even perfect square.

 Note: Even perfect square means the number should be even and a perfect square.

 Input Format 
 The first line of input contains an integer T, the number of test cases. 
 T lines follow, each line containing N, the number that the teacher provides.

 Output Format 
 For each test case, print in a newline the output in p/q format where p and q are positive coprime integers. 
 if p is 0, you should simply output 0.

 Constraints 
 1≤T≤4×104 
 2≤N≤106

 Sample Input

 4
 2
 8
 36
 900
 Sample Output

 0
 1/3
 1/8
 3/26
 Explaination 
 For the first case N=2, the set of proper divisors is {1}. Since 1 is not an even perfect square, the probability is 0. 
 For the second case N=8, the set of proper divisors is {1,2,4} and only 4 is an even perfect square among them, so probability = 1/3. 
 For the third case N=36, the set of proper divisors is {1,2,3,4,6,9,12,18}, and only 4 is an even perfect square, so probability = 1/8. 
 For the fourth case N=900, there will be total of 26 proper divisors and 3 of them {4,36,100} are even perfect squares.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MehtaAndHisLaziness {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int n = 1000000;
		int[] divcount = new int[n + 1];
		int[] evensq = new int[n + 1];
		boolean[] e = new boolean[n + 1];
		for (int i = 1; i <= n; i++)
			for (int j = i; j <= n; j += i)
				divcount[j]++;
		for (int i = 2; i * i <= n; i += 2) {
			e[i * i] = true;
			for (int j = i * i; j <= n; j += i * i)
				evensq[j]++;
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int l = Integer.parseInt(br.readLine());
			int num = evensq[l], den = divcount[l] - 1;
			if (e[l])
				num--;
			int gcd = gcd(num, den);
			num /= gcd;
			den /= gcd;
			if (num == 0)
				System.out.println(0);
			else
				System.out.println(num + "/" + den);
		}
	}

	public static int gcd(int a, int b) {
	    return b == 0 ? a : gcd(b, a % b);
	  }

}
