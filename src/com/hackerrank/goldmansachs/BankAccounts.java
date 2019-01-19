package com.hackerrank.goldmansachs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */
/**
 * 
 * @author Shrey
 *
 */
public class BankAccounts {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine().trim());
		for (int a0 = 0; a0 < q; a0++) {
			String[] line = br.readLine().trim().split(" ");
			int n = Integer.parseInt(line[0]);
			int k = Integer.parseInt(line[1]);
			int x = Integer.parseInt(line[2]);
			int d = Integer.parseInt(line[3]);
			// amounts
			line = br.readLine().trim().split(" ");
			String result = feeOrUpfront(n, k, x, d, line);
			System.out.println(result);
		}
		br.close();
	}

	private static String feeOrUpfront(int n, int k, int x, int d, String[] p) {
		double perAccountCharge = 0;
		for (String am : p) {
			int value = Integer.parseInt(am);
			perAccountCharge += Math.max(k, x * 0.01 * value);
		}
		return perAccountCharge <= d ? "fee" : "upfront";
	}

}
