package com.hackerrank.combinatorics;


/**Problem Statement

 On the eve of Diwali, Hari is decorating his house with a serial light bulb set. The serial light bulb set has N bulbs placed sequentially on a string which is programmed to change patterns every second. If atleast one bulb in the set is on at any given instant of time, how many different patterns of light can the serial light bulb set produce?

 Note: Lighting two bulbs *-* is different from **-

 Input Format 
 The first line contains the number of test cases T, T lines follow. 
 Each line contains an integer N, the number of bulbs in the serial light bulb set.

 Output Format 
 Print the total number of patterns modulo 105

 Constraints 
 1 <= T <= 1000 
 0< N < 104

 Sample Input

 2
 1
 2
 Sample Output

 1
 3
 Explanation

 Case 1: 1 bulb can be lit in only 1 way. 
 Case 2: 2 bulbs can be lit in -*, *-, ** i.e. 3 ways.*/

/**
 * @author Shrey
 *
 */
public class DiwaliLights {

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			int T = Integer.parseInt(in.readLine());
			for (int i = 0; i < T; i++) {
				long N = Long.parseLong(in.readLine());
				System.out.println(diwaliLights(2, N).toString());
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static BigInteger diwaliLights(long x, long N) {
		BigInteger big = BigInteger.valueOf(x).pow((int) N)
				.subtract(BigInteger.ONE).min(new BigInteger("100000"));
		return big;
	}
}
