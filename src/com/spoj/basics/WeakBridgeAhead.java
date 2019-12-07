package com.spoj.basics;

import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/WBAHD/">WBAHD - Weak Bridge Ahead</a>
 * 
 * @author Shrey
 *
 */
public class WeakBridgeAhead {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int tt = 1;
		while (tt <= t) {
			int n = scan.nextInt();
			int m = scan.nextInt();

			long lSum = 0, rSum = 0;
			long lLast = 0, rLast = 0;
			for (int i = 0; i < n; i++) {
				int temp = scan.nextInt();
				lSum += temp;
				if (n + 1 > n)
					lLast = temp;
			}
			for (int i = 0; i < m; i++) {
				int temp = scan.nextInt();
				rSum += temp;
				if (m + 1 > m)
					rLast = temp;
			}
			System.out.println("Case " + (tt++) + ":" + (lSum + rSum - Math.max(lLast, rLast)));
		}
		scan.close();
	}

}
