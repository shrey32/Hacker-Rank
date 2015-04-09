package com.hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * Problem Statement

 The equivalent of SSN in India is a PAN number, which is unique to each of its citizens. In any of the country's official documents, the PAN number is listed as follows

 <char><char><char><char><char><digit><digit><digit><digit><char>
 Your task is to figure out if the PAN number is valid or not. A valid PAN number will have all its letters in uppercase and digits in the same order as listed above.

 Input Format

 First line contains N. N lines follow, each having a PAN number.

 Constraints

 1≤N≤10
 Each char is an uppercase letter, i.e., char∈[′A′,′Z′].
 Each digit lies between 0 and 9, i.e., digit∈[0,9].
 The length of the PAN number is always 10, i.e., length(PAN)=10
 Every character in PAN is either char or digit satisfying the above constraints.
 Output Format

 For every PAN number listed, print YES if it is valid and NO if it isn't.

 Sample Input

 3
 ABCDS1234Y
 ABAB12345Y
 avCDS1234Y
 Sample Output

 YES
 NO
 NO
 The first PAN number is valid since the first 5 characters are letters, the next 4 are digits and the last character is an alphabet. All letters in input is in uppercase. 
 The second PAN number is invalid as the fifth character is a digit as opposed to an letter. 
 The third PAN number contains lowercase characters. Hence invalid
 */

/**
 * 
 * @author Shrey
 *
 */
public class ValidPANFormat {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			String pan = br.readLine();
			validatePAN(pan);
			T--;
		}
		 br.close();
	}

	private static void validatePAN(String pan) {
		Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
		if (pattern.matcher(pan).matches()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
