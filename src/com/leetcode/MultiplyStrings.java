package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("2", "3"));
		System.out.println(multiply("15", "25"));
		System.out.println(multiply("456", "123"));
	}

	public static String multiply(String num1, String num2) {
		if ("".equals(num1) || "".equals(num2))
			return "";
		if (num1.charAt(0) == '0' || num2.charAt(0) == '0')
			return "0";
		int len1 = num1.length();
		int len2 = num2.length();

		String[] toSum = new String[len1];
		int maxLength = 0;
		int trainlingZeros = 1;
		for (int i = len1 - 1; i >= 0; i--) {
			int curr1 = Character.getNumericValue(num1.charAt(i));
			int carryOver = 0;
			StringBuilder val = new StringBuilder();
			for (int j = len2 - 1; j >= 0; j--) {
				int curr2 = Character.getNumericValue(num2.charAt(j));
				int prod = curr1 * curr2 + carryOver;
				carryOver = prod / 10;
				val.append(prod % 10);
			}
			if (carryOver > 0)
				val.append(carryOver);
			if (i < len1 - 1) {
				StringBuilder zeros = new StringBuilder();
				for (int k = 0; k < trainlingZeros; k++)
					zeros.append("0");
				trainlingZeros++;
				val = zeros.append(val);
			}
			toSum[i] = val.toString();

			maxLength = Math.max(maxLength, toSum[i].length());
		}
		// System.out.println(Arrays.toString(toSum));
		String sum = sum(toSum, maxLength);
		return sum;
	}

	private static String sum(String[] numStr, int maxLength) {
		StringBuilder result = new StringBuilder();
		int carryOver = 0;
		for (int i = 0; i < maxLength; i++) {
			int sum = 0;
			for (int j = numStr.length - 1; j >= 0; j--) {
				String s = numStr[j];
				if (i < s.length()) {
					int digit = Character.getNumericValue(s.charAt(i));
					sum += digit;
				}
			}
			sum += carryOver;
			carryOver = sum / 10;
			result.append(sum % 10);
		}
		if (carryOver > 0)
			result.append(carryOver);
		return result.reverse().toString();
	}

}
