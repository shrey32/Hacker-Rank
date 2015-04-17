package com.hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 *Problem Statement

In a galaxy far far away, a planet different from ours, computer usernames follow a different format.

It has to begin with either an underscore '_' (ascii value 95) or a dot '.' (ascii value 46)
It has to be immediately followed by one or more occurrences of digits numbered 0-9
It can then have letters, both uppercase or lowercase, 0 or more in number
It can then end with an optional '_' (ascii value 95)
Your task is to validate whether a username is valid or not

Input Format

First line contains N, N usernames follow each in a newline.

Constraints

1 <= N <= 100

Output Format

For every username, print

VALID
if you think the username is correct and print

INVALID 
otherwise.

Sample Input

3
_0898989811abced_
_abce
_09090909abcD0
Sample Output

VALID
INVALID
INVALID
Explanation

The first username is valid as it passes all the 3 constraints as mentioned above. 
The second username is invalid as '_' is not immediately followed by a number. 
The third username is also invalid as letters are immediately followed by a number which is not a valid format.

Viewing Submissions

You can view others' submissions if you solve this challenge. Navigate to the challenge leaderboard.
 */

/**
 * 
 * @author Shrey
 *
 */
public class AlienUsername {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			String username = br.readLine();
			alienUsername(username);
			T--;
		}
		 br.close();
	}

	private static void alienUsername(String username) {
		Pattern pattern = Pattern.compile("^[._]{1}[0-9]{1,}[A-Za-z]{0,}_{0,1}$");
		if (pattern.matcher(username).matches()) {
			System.out.println("VALID");
		} else {
			System.out.println("INVALID");
		}
	}
}
