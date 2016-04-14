package com.hackerrank.bitmanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Understanding 22's complement representation is fundamental to learning about Computer Science. Let's say you wrote down the 22's complement for each 3232-bit integer in the inclusive range from AA to BB; how many 11's would you write down in all?

Input Format

The first line contains TT, the number of test cases. 
The TT subsequent lines each contain two space-separated integers, AA and BB, respectively.

Constraints

T≤1000T≤1000
−231≤A≤B≤231−1−231≤A≤B≤231−1
Output Format

On a new line for each of the TT test cases, print the number of 11's in the 3232-bit 22's complement representation for integers in the inclusive range from AA to BB.

Sample Input

3  
-2 0  
-3 4  
-1 4
Sample Output

63  
99  
37
Explanation

Test Case 0: 
−2−2 contains 3131 ones followed by a zero. 
−1−1 contains 3232 ones. 
00 contains 00 ones. 
31+32+0=6331+32+0=63, so we print 6363 on a new line.

Test Case 1: 
31+31+32+0+1+1+2+1=9931+31+32+0+1+1+2+1=99, so we print 9999 on a new line.

Test Case 2: 
32+0+1+1+2+1=3732+0+1+1+2+1=37, so we print 3737 on a new line.
 */
/**
 * 
 * @author Shrey
 *
 */
public class TwosComplement {
	private final static byte BITS;
	private final static long[] BIT_COUNT_TO_BIT;
	static {
		BITS = 32;
		BIT_COUNT_TO_BIT = new long[BITS + 1];
		BIT_COUNT_TO_BIT[0] = 1;
		for (byte i = 1; i <= BITS; i++) {
			BIT_COUNT_TO_BIT[i] = ((BIT_COUNT_TO_BIT[i - 1] - 1L) << 1)
					+ (1L << (i - 1)) + 1L;
		}
	}

	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (short T = Short.parseShort(br.readLine().trim()); T > 0; T--) {
			String[] temp = br.readLine().trim().split(" ");
			int A = Integer.parseInt(temp[0]);
			int B = Integer.parseInt(temp[1]);
			long bits = bitCountToNum(B) - bitCountToNum(A)
					+ getHammingWeight(A);
			bits += (A < 0 && B >= 0) ? BIT_COUNT_TO_BIT[BITS] - 1L : 0;
			sb.append(bits + "\n");
		}
		System.out.print(sb);
	}

	// Bit count in number
	private static int getHammingWeight(int n) {
		byte count = 0;
		while (n != 0) {
			count++;
			n &= n - 1;
		}
		return count;
	}

	// Bit count to number, inclusive
	private static long bitCountToNum(int n) {
		long count = 0;
		for (byte b = BITS; n != 0;) {
			int x = 1 << --b;
			if ((n & x) != 0) {
				n &= ~x;
				count += BIT_COUNT_TO_BIT[b] + n;
			}
		}
		return count;
	}
}
