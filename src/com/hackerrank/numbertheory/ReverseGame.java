package com.hackerrank.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 Akash and Akhil are playing a game. They have N balls numbered from 0 to N−1. Akhil asks Akash to reverse the position of the balls, i.e., to change the order from say, 0,1,2,3 to 3,2,1,0. He further asks Akash to reverse the position of the balls N times, each time starting from one position further to the right, till he reaches the last ball. So, Akash has to reverse the positions of the ball starting from 0th position, then from 1st position, then from 2nd position and so on. At the end of the game, Akhil will ask Akash the final position of any ball numbered K. Akash will win the game, if he can answer. Help Akash.

 Input Format 
 The first line contains an integer T, i.e., the number of the test cases. 
 The next T lines will contain two integers N and K.

 Output Format 
 Print the final index in array.

 Constraints 
 1≤T≤50 
 1≤N≤105 
 0≤K<N
 Sample Input

 2
 3 1
 5 2
 Sample Output

 2
 4
 Explanation 
 For first test case, The rotation will be like this: 
 0 1 2 -> 2 1 0 -> 2 0 1 -> 2 0 1
 So, Index of 1 will be 2.
 */

/**
 * 
 * @author Shrey
 *
 */
public class ReverseGame {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			String line = br.readLine();
			int N = Integer.parseInt(line.split(" ")[0]);
			int K = Integer.parseInt(line.split(" ")[1]);
			reverseGame(N, K);
			T--;
		}
	}

	private static void reverseGame(int N, int K) {
		int[] a = new int[N];
		int pos = 0;
		for (int i = N - 1, j = 0, z = 0, k = 1; i >= 0; i--, z += 1, j += 2, k += 2) {
			if (j < N) {
				a[j] = i;
				if (i == K) {
					pos = j;
					break;
				}
			}
			if (k < N) {
				a[k] = z;
				if (z == K) {
					pos = k;
					break;
				}
			}
		}
		System.out.println(pos);
	}
}
