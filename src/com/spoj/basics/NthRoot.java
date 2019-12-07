package com.spoj.basics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * <a href="https://www.spoj.com/problems/CHI_ROOT/">CHI_ROOT - n-th root</a>
 * 
 * @author Shrey
 *
 */
public class NthRoot {

	public static void main(String[] args) throws java.lang.Exception {
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int numCases = Integer.parseInt(reader.readLine().split(" ")[0]);
		for (int i = 0; i < numCases; i++) {
			String[] temp = reader.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			BigDecimal x = new BigDecimal(temp[1]);

			BigDecimal guess = BigDecimal.TEN;
			builder.append(convert(newton(n, x, guess)));
			builder.append("\n");
		}

		System.out.print(builder.toString());

	}

	// newton's method
	public static BigDecimal newton(Integer root, BigDecimal decimal, BigDecimal guess) {
		int scale = 102;

		double pow = 1.0 / root;

		BigDecimal result = new BigDecimal(Math.pow(decimal.doubleValue(), pow)).setScale(scale,
				BigDecimal.ROUND_HALF_DOWN);

		return result;
	}

	// checks final string for "." and trailing 0's
	public static String convert(BigDecimal in) {
		String input = in.toString();

		// look for trailing 0's
		if (input.contains(".")) {
			int iter = input.length() - 1;
			while (iter > input.indexOf(".") && input.charAt(iter) == '0') {
				iter -= 1;
			}
			input = input.substring(0, iter);
		}

		// look for decimals
		input = input.replace(".", "");

		// ensure its less than 102 in length
		if (input.length() > 101) {
			input = input.substring(0, 101);
		}

		return input;
	}
}
