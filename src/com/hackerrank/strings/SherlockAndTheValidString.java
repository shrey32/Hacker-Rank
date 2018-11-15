package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Sherlock considers a string to be valid if it all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid.

 For example, if , it is a valid string because frequencies are . So is  because we can remove one  and have  of each character in the remaining string. If  however, the string is not valid as we can only remove  occurrence of . That would leave character frequencies of .

 Input Format

 A single string .

 Constraints

 Each character 
 Output Format

 Print YES if string  is valid, otherwise, print NO.

 Sample Input 0

 aabbcd
 Sample Output 0

 NO
 Explanation 0

 We would need to remove two characters, both c and d, from  to make it valid. We are limited to removing only one character, so  is invalid.

 Sample Input 1

 aabbccddeefghi
 Sample Output 1

 NO
 Explanation 1

 Frequency counts for the letters are as follows:

 {'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}

 There are  characters with a frequency of  that would need to be removed: . If only one of those  had been in the string, it would have been valid.
 */
/**
 * 
 * @author Shrey
 *
 */
public class SherlockAndTheValidString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		boolean isValid = isValid(s);
		System.out.println(isValid ? "YES" : "NO");
	}

	private static boolean isValid(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>(s.length());
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char key = s.charAt(i);
			map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
		}
		int max = Collections.max(map.values());
		int min = Collections.min(map.values());
		int countMax = 0, countMin = 0;
		for (Integer i : map.values()) {
			if (i == max)
				countMax++;
			if (i == min)
				countMin++;
		}
		if (countMax == map.keySet().size() || countMin == map.keySet().size())
			return true;
		else if ((countMin == 1 && countMax == (map.keySet().size() - 1))
				|| (countMax == 1 && countMin == (map.keySet().size() - 1)))
			return true;
		else
			return false;
	}
}
