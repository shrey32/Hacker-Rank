package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 Julius Caesar protected his confidential information from his enemies by encrypting it. Caesar rotated every letter in the string by a fixed number K. This made the string unreadable by the enemy. You are given a string S and the number K. Encrypt the string and print the encrypted string.

 For example: 
 If the string is middle-Outz and K=2, the encoded string is okffng-Qwvb. Note that only the letters are encrypted while symbols like - are untouched. 
 'm' becomes 'o' when letters are rotated twice, 
 'i' becomes 'k', 
 '-' remains the same because only letters are encoded, 
 'z' becomes 'b' when rotated twice.

 Input Format

 Input consists of an integer N equal to the length of the string, followed by the string S and an integer K.

 Constraints 
 1≤N≤100 
 0≤K≤100 
 S is a valid ASCII string and doesn't contain any spaces.

 Output Format

 For each test case, print the encoded string.

 Sample Input

 11
 middle-Outz
 2
 Sample Output

 okffng-Qwvb
 */
/**
 * 
 * @author Shrey
 *
 */
public class CaesarCipher {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String line = br.readLine();
		int offset = Integer.parseInt(br.readLine());
		StringBuffer buffer = new StringBuffer();
		offset = offset % 26 + 26;
		for (char c : line.toCharArray()) {
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
					buffer.append((char) ('A' + (c - 'A' + offset) % 26));
				} else {
					buffer.append((char) ('a' + (c - 'a' + offset) % 26));
				}
			} else {
				buffer.append(c);
			}
		}
		System.out.println(buffer);
	}
}
