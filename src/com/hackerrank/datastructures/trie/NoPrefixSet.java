package com.hackerrank.datastructures.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Given  strings. Each string contains only lowercase letters from (both inclusive). The set of  strings is said to be GOOD SET if no string is prefix of another string else, it is BAD SET. (If two strings are identical, they are considered prefixes of each other.)

 For example, aab, abcde, aabcd is BAD SET because aab is prefix of aabcd.

 Print GOOD SET if it satisfies the problem requirement. 
 Else, print BAD SET and the first string for which the condition fails.

 Input Format 
 First line contains , the number of strings in the set. 
 Then next  lines follow, where  line contains  string.

 Constraints 

 Length of the string 

 Output Format 
 Output GOOD SET if the set is valid. 
 Else, output BAD SET followed by the first string for which the condition fails.

 Sample Input00

 7
 aab
 defgab
 abcde
 aabcde
 cedaaa
 bbbbbbbbbb
 jabjjjad
 Sample Output00

 BAD SET
 aabcde
 Sample Input01

 4
 aab
 aac
 aacghgh
 aabghgh
 Sample Output01

 BAD SET
 aacghgh
 Explanation 
 aab is prefix of aabcde. So set is BAD SET and it fails at string aabcde.
 */
/**
 * 
 * @author Shrey
 *
 */
public class NoPrefixSet {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		Set<String> set = new HashSet<String>();
		boolean isPrefix = false;
		String s = "", result = "";
		while (n-- > 0) {
			s = br.readLine().trim();
			if (!isPrefix) {
				for (String v : set) {
					int ind = s.indexOf(v);
					int ind2 = v.indexOf(s);
					if ((ind == 0 || ind2 == 0) && !isPrefix) {
						isPrefix = true;
						result = s;
						break;
					}
				}
				if (!isPrefix) {
					set.add(s);
				}
			}
		}

		if (isPrefix) {
			System.out.println("BAD SET");
			System.out.println(result);
		} else {
			System.out.println("GOOD SET");
		}
		br.close();
	}
}
