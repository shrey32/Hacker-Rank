package com.crackingthecodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class EnglishToInt {

	private static String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	private static String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };

	private static String helper(int num) {
		StringBuilder word = new StringBuilder();
		if (num >= 1000000000)
			word.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
		else if (num >= 1000000)
			word.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
		else if (num >= 1000)
			word.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
		else if (num >= 100)
			word.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
		else if (num >= 20)
			word.append(tens[num / 10]).append(" ").append(helper(num % 10));
		else
			word.append(ones[num]);

		return word.toString().trim();
	}

	public static String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		return helper(num);
	}

	public static void main(String[] args) {
		System.out.println(numberToWords(5));
		System.out.println(numberToWords(16));

	}

}
