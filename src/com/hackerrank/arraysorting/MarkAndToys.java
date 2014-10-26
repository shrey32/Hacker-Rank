package com.hackerrank.arraysorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Mark and Jane are very happy after having their first kid. Their son is very
 * fond of toys, so Mark wants to buy some. There are N different toys lying in
 * front of him, tagged with their prices, but he has only $K. He wants to
 * maximize the number of toys he buys with this money.
 * 
 * Now, you are Mark's best friend and have to help him buy as many toys as
 * possible.
 * 
 * Input Format The first line contains two integers, N and K, followed by a
 * line containing N space separated integers indicating the products' prices.
 * 
 * Output Format An integer that denotes maximum number of toys Mark can buy for
 * his son.
 * 
 * Constraints 1<=N<=105 1<=K<=109 1<=price of any toy<=109 A toy can't be
 * bought multiple times.
 * 
 * Sample Input
 * 
 * 7 50 1 12 5 111 200 1000 10 Sample Output
 * 
 * 4 Explanation
 * 
 * He can buy only 4 toys at most. These toys have the following prices:
 * 1,12,5,10.
 */

/**
 * @author Shrey
 *
 */
public class MarkAndToys {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		long N = scan.nextLong();
		long K = scan.nextLong();
		ArrayList<Long> array = new ArrayList<Long>();

		long sum = 0;
		for (long i = 0; i < N; i++) {
			array.add(scan.nextLong());
		}

		Collections.sort(array);

		int i = 0;
		int count = 0;
		while (sum < K && i < array.size()) {

			sum = sum + array.get(i);
			if (sum < K) {
				count++;
			}
			i++;
		}

		System.out.println(count);
		scan.close();
	}

}
