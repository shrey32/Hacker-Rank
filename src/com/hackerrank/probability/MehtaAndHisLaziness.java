package com.hackerrank.probability;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Long, String> map = new HashMap<Long, String>();
		for (int i = 0; i < N; i++) {
			long l = Long.parseLong(br.readLine());
			if (map.containsKey(l)) {
				System.out.println(map.get(l));
			} else {
				solution(l, map);
			}
		}
	}

	/**
	 * 
	 * @param l
	 */
	private static void solution(long l, Map<Long, String> map) {
		long p = 0;
		long q = 0;
		for (int i = 1; i <= l / 2; i++) {
			if (l % i == 0) {
				q++;
				if (i % 2 == 0) {
					int sqrt = (int) Math.sqrt(i);
					if (i % 2 == 0 && Math.ceil(sqrt) * Math.ceil(sqrt) == i) {
						p++;
					}
				}
			}
		}
		printSolution(p, q, l, map);
	}

	/**
	 * 
	 * @param p
	 * @param q
	 * @param l
	 * @param map
	 */
	private static void printSolution(long p, long q, long l,
			Map<Long, String> map) {
		if (q > 1 && p != 0) {
			if (!map.containsKey(l)) {
				int k = 2;
				while (p >= k) {
					if (p % k == 0 && q % k == 0) {
						p = p / k;
						q = q / k;
					} else {
						k++;
					}
				}
				map.put(l, p + "/" + q);
				System.out.println(p + "/" + q);
			}
		} else {
			System.out.println("0");
		}
	}
}
