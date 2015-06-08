package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 Task

 Given the time in numerals we may convert it into words, as shown below:

 5:005:015:105:305:405:455:475:28→ five o' clock→ one minute past five→ ten minutes past five→ half past five→ twenty minutes to six→ quarter to six→ thirteen minutes to six→ twenty eight minutes past five
 Task: 
 Write a program which prints the time in words for the input given in the format mentioned above.

 Input Format

 There will be two lines of input:
 H, representing the hours
 M, representing the minutes

 Constraints
 1≤H≤12
 0≤M<60
 Output Format

 Display the time in words.

 Sample Input

 5  
 47  
 Sample Output

 thirteen minutes to six

 */

/**
 * 
 * @author Shrey
 *
 */
public class TheTimeInWords {

	private static final String[] NUMBERS = new String[] { "","one", "two",
			"three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen", "twenty", "twenty one",
			"twenty two", "twenty three", "twenty four", "twenty five","twenty six",
			"twenty seven", "twenty eight", "twenty nine" };

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int h = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		if (m == 0) {
			System.out.println(NUMBERS[h] + " o\' clock");
		} else if (m == 15) {
			System.out.println("quarter past " + NUMBERS[h]);
		} else if (m < 30) {
			System.out.println(NUMBERS[m] + " minutes past " + NUMBERS[h]);
		} else if (m == 30) {
			System.out.println("half past " + NUMBERS[h]);
		} else if (m == 45) {
			System.out.println("quarter to " + NUMBERS[(h + 1) % 12]);
		} else {
			System.out.println(NUMBERS[60 - m] + " minutes to "
					+ NUMBERS[(h + 1) % 12]);
		}

	}

}
