package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**This follows from Game of Thrones - I.

 Now that the king knows how to find out whether a given word has an anagram which is a palindrome or not, he encounters another challenge. He realizes that there can be more than one palindrome anagrams for a given word. Can you help him find out how many palindrome anagrams are possible for a given word ?

 The king has many words. For each given word, he needs to find out the number of palindrome anagrams of the string. As the number of anagrams can be large, the king needs the number of anagrams % (109+ 7).

 Input format :
 A single line which contains the input string

 Output format : 
 A single line which contains the number of anagram strings which are palindrome % (109 + 7).

 Constraints : 
 1<=length of string <= 10^5 
 Each character of the string is a lowercase alphabet. 
 Each test case has at least 1 anagram which is a palindrome.

 Sample Input 01 :

 aaabbbb
 Sample Output 01 :

 3 
 Explanation : 
 Three palindrome permutations of the given string are abbabba , bbaaabb and bababab.

 Sample Input 02 :

 cdcdcdcdeeeef
 Sample Output 02 :

 90*/

/**
 * @author Shrey
 *
 */
public class GameOfThrones2 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String s = br.readLine();

			if (s.length() == 1) {
				System.out.println(1);
			}
			int[] letters = new int[26];
			for (int i = 0; i < s.length(); i++) {
				letters[s.charAt(i) - 'a']++;
			}
			int count = 0;
			BigInteger b = new BigInteger("1");
			for (int l : letters) {
				if (l != 0) {
					count += l;
					int h = l / 2;
					b = b.multiply(fact(Integer.parseInt((BigInteger.valueOf(h)
							.toString()))));
				}
			}
			int half = count / 2;
			BigInteger permutation = fact(half);
			BigInteger result = permutation.divide(b);
			result = result.mod(new BigInteger("1000000007"));
			System.out.println(result);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static BigInteger fact(int n) {
		BigInteger one = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++) {
			one = one.multiply(BigInteger.valueOf(i));
		}
		return one;
	}
}
