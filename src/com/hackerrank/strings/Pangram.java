package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**Problem Statement

 Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly because it is a pangram. ( pangrams are sentences constructed by using every letter of the alphabet at least once. )

 After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

 Given a sentence s, tell Roy if it is a pangram or not.

 Input Format

 Input consists of a line containing s.

 Constraints 
 Length of s can be atmost 103 (1≤|s|≤103) and it may contain spaces, lowercase and uppercase letters. Lowercase and uppercase instances of a letter are considered same.

 Output Format

 Output a line containing pangram if s is a pangram, otherwise output not pangram.

 Sample Input #1

 We promptly judged antique ivory buckles for the next prize    
 Sample Output #1

 pangram
 Sample Input #2

 We promptly judged antique ivory buckles for the prize    
 Sample Output #2

 not pangram
 Explanation

 In the first testcase, the answer is pangram because the sentence contains all the letters.*/
/**
 * @author Shrey
 *
 */
public class Pangram {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String s = br.readLine().toLowerCase();
			List<String> list = charList();
			for (int i = 0; i < s.length(); i++) {
				Character c = new Character(s.charAt(i));
				String sr = String.valueOf(c);
				if (!sr.equals("") && list.contains(sr)) {
					list.remove(list.indexOf(sr));
				}
			}
			if (list.size() == 0) {
				System.out.println("pangram");
			} else {
				System.out.println("not pangram");
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<String> charList() {
		List<String> list = new ArrayList<String>();
		for (char c = 'a'; c <= 'z'; c++) {
			list.add(String.valueOf(c));
		}
		return list;
	}
}
