package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Louise joined a social networking site to stay in touch with her friends. The signup page required her to input a name and a password. However, the password must be strong. The website considers a password to be strong if it satisfies the following criteria:

 Its length is at least .
 It contains at least one digit.
 It contains at least one lowercase English character.
 It contains at least one uppercase English character.
 It contains at least one special character. The special characters are: !@#$%^&*()-+
 She typed a random string of length  in the password field but wasn't sure if it was strong. Given the string she typed, can you find the minimum number of characters she must add to make her password strong?

 Note: Here's the set of types of characters in a form you can paste in your solution:

 numbers = "0123456789"
 lower_case = "abcdefghijklmnopqrstuvwxyz"
 upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
 special_characters = "!@#$%^&*()-+"
 Input Format

 The first line contains an integer  denoting the length of the string.

 The second line contains a string consisting of  characters, the password typed by Louise. Each character is either a lowercase/uppercase English alphabet, a digit, or a special character.

 Constraints

 Output Format

 Print a single line containing a single integer denoting the answer to the problem.

 Sample Input 0

 3
 Ab1
 Sample Output 0

 3
 Explanation 0

 She can make the password strong by adding  characters, for example, $hk, turning the password into Ab1$hk which is strong.

 characters aren't enough since the length must be at least .

 Sample Input 1

 11
 #HackerRank
 Sample Output 1

 1
 Explanation 1

 The password isn't strong, but she can make it strong by adding a single digit.
 */
/**
 * 
 * @author Shrey
 *
 */
public class StrongPassword {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String password = br.readLine();
		int rem = remainingCharCount(password);
		if (rem + password.length() >= 6)
			System.out.println(rem);
		else
			System.out.println(6 - password.length());
		br.close();
	}

	private static int remainingCharCount(String password) {
		int remainingCharCount = 4;
		Pattern numbers = Pattern.compile("[0-9]{1,}");
		Pattern lowerCase = Pattern.compile("[a-z]{1,}");
		Pattern upperCase = Pattern.compile("[A-Z]{1,}");
		Pattern specialCharacters = Pattern.compile("(\\W)");
		Matcher nMatcher = numbers.matcher(password);
		Matcher lMatcher = lowerCase.matcher(password);
		Matcher uMatcher = upperCase.matcher(password);
		Matcher spMatcher = specialCharacters.matcher(password);
		while (uMatcher.find()) {
			remainingCharCount -= 1;
			break;
		}
		while (lMatcher.find()) {
			remainingCharCount -= 1;
			break;
		}
		while (nMatcher.find()) {
			remainingCharCount -= 1;
			break;
		}
		while (spMatcher.find()) {
			remainingCharCount -= 1;
			break;
		}
		return remainingCharCount;
	}

}
