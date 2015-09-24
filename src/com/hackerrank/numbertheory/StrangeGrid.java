package com.hackerrank.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Shrey
 *
 */
public class StrangeGrid {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		long r = Integer.parseInt(line.split(" ")[0]);
		long c = Integer.parseInt(line.split(" ")[1]);
		if (r % 2 == 0) {
			System.out.println((((r / 2) - 1) * 10) + ((c - 1) * 2) + 1);
		} else {
			System.out.println(5 * (r - 1) + ((c * 2) - 2));
		}
		br.close();
	}
}
