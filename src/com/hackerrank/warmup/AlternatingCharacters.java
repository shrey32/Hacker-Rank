package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**Problem Statement

 Shashank likes strings in which consecutive characters are different. For example, he likes ABABA, while he doesn't like ABAA. Given a string containing characters A and B only, he wants to change it into a string he likes. To do this, he is allowed to delete the characters in the string.

 Your task is to find the minimum number of required deletions.

 Input Format 
 The first line contains an integer T i.e. the number of test cases. 
 Next T lines contain a string each.

 Output Format 
 Print minimum number of required steps for each test case.

 Constraints

 1≤T≤10 
 1≤lengthofString≤105 

 Sample Input

 5
 AAAA
 BBBBB
 ABABABAB
 BABABA
 AAABBB
 Sample Output

 3
 4
 0
 0
 4
 Explanation

 AAAA⟹A, 3 deletions
 BBBBB⟹B, 4 deletions
 ABABABAB⟹ABABABAB, 0 deletions
 BABABA⟹BABABA, 0 deletions
 AAABBB⟹AB, 4 deletions*/
/**
 * @author Shrey
 *
 */
public class AlternatingCharacters {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String line = br.readLine();
				System.out.println(noOfDeletions(line));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int noOfDeletions(String line) {
		int count = 0;
		for (int i = 0; i < line.length(); i++) {
			if (i < line.length() - 1) {
				Character c = line.charAt(i);
				Character c1 = line.charAt(i + 1);
				if (c1 > c) {
					if (i < line.length() - 2) {
						Character c2 = line.charAt(i + 2);
						if (String.valueOf(c1).equals(String.valueOf(c2))) {
							count++;
						}
					}
					i++;
				} else if (String.valueOf(c1).equals(String.valueOf(c))) {
					count++;
				}
			}
		}
		return count;
	}
}
