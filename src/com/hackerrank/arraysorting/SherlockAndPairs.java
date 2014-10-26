package com.hackerrank.arraysorting;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**Sherlock is given an array of N integers A0, A1 ... AN-1 by Watson. Now Watson asks Sherlock that how many different pairs of indices i and j exist such that i is not equal to j but Ai is equal to Aj.

 That is, Sherlock has to count total number of pairs of indices (i, j) where Ai = Aj AND i ≠ j.

 Input Format 
 First line contains T, the number of testcases. T test case follows. 
 Each testcase consists of two lines, first line contains an integer N, size of array. 
 Next line contains N space separated integers.

 Output Format 
 For each testcase, print the required answer in different line.

 Constraints 
 1 ≤ T ≤ 10 
 1 ≤ N ≤ 105 
 1 ≤ A[i] ≤ 106

 Sample input

 2
 3
 1 2 3
 3
 1 1 2
 Sample output

 0
 2
 Explanation 
 In the first testcase, no two pair of indices exist which satisfy the given property. 
 In second testcase as A[0] = A[1] = 1, the pairs of indices (0,1) and (1,0) satisfy the given property.*/

/**
 * @author Shrey
 *
 */
public class SherlockAndPairs {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int N = scan.nextInt();
			int[] array = new int[N];
			for (int j = 0; j < N; j++) {
				array[j] = scan.nextInt();
			}
			Arrays.sort(array);
			System.out.println(solve(array));
		}
		scan.close();
	}


	 private static final BigInteger TWO = BigInteger.valueOf(2);

	    private static BigInteger solve(int[] in) {
	        Map<BigInteger, BigInteger> map = new HashMap<BigInteger, BigInteger>();
	        for (int i = 0; i < in.length; i++) {
	            BigInteger item = BigInteger.valueOf(in[i]);
	            if (map.containsKey(item)) {
	                map.put(item, map.get(item).add(BigInteger.ONE));
	            } else {
	                map.put(item, BigInteger.ONE);
	            }
	        }

	        BigInteger tot = BigInteger.ZERO;
	        for (Map.Entry<BigInteger, BigInteger> e : map.entrySet()) {
	            BigInteger freq = e.getValue();
	            if (TWO.equals(freq)) {
	                tot = tot.add(BigInteger.valueOf(2));
	            } else if (freq.compareTo(TWO) > 0) {
	                BigInteger res = freq.multiply((freq.subtract(BigInteger.ONE)));
	                tot = tot.add(res);
	            }
	        }
	        return tot;
	    }
}
