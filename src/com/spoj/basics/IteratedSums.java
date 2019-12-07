package com.spoj.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * <a href="https://www.spoj.com/problems/SMPSUM/">SMPSUM - Iterated sums</a>
 * 
 * @author Shrey
 *
 */
public class IteratedSums {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inpLine = br.readLine();
		String[] inputs = inpLine.split(" ");
		int a = Integer.parseInt(inputs[0]);
		int b = Integer.parseInt(inputs[1]);
		System.out.println(iteratedSums(a, b));
		br.close();
	}

	private static final long iteratedSums(int a, int b) {
		long result = 0;
		for (int i = a; i <= b; i++) {
			result += (i * i);
		}
		return result;
	}

}
