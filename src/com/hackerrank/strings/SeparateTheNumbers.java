package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A numeric string, , is beautiful if it can be split into a sequence of two or more positive integers, , satisfying the following conditions:

 for any  (i.e., each element in the sequence is  more than the previous element).
 No  contains a leading zero. For example, we can split  into the sequence , but it is not beautiful because  and  have leading zeroes.
 The contents of the sequence cannot be rearranged. For example, we can split  into the sequence , but it is not beautiful because it breaks our first constraint (i.e., ).
 The diagram below depicts some beautiful strings:

 image

 You must perform  queries where each query consists of some integer string . For each query, print whether or not the string is beautiful on a new line. If it's beautiful, print YES x, where  is the first number of the increasing sequence. If there are multiple such values of , choose the smallest. Otherwise, print NO.

 Input Format

 The first line contains an integer , the number of strings to evaluate. 
 Each of the next  lines contains an integer string  to query.

 Constraints

 Output Format

 For each query, print its answer on a new line (i.e., either YES x where  is the smallest first number of the increasing sequence, or NO).

 Sample Input 0

 7
 1234
 91011
 99100
 101103
 010203
 13
 1
 Sample Output 0

 YES 1
 YES 9
 YES 99
 NO
 NO
 NO
 NO
 Explanation 0

 The first three numbers are beautiful (see the diagram above). The remaining numbers are not beautiful:

 For , all possible splits violate the first and/or second conditions.
 For , it starts with a zero so all possible splits violate the second condition.
 For , the only possible split is , which violates the first condition.
 For , there are no possible splits because  only has one digit.
 */
/**
 * 
 * @author Shrey
 *
 */
public class SeparateTheNumbers {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String line = br.readLine().trim();
			long result = areNumbersSeparated(line);
			System.out.println(result > 0 ? "YES " + result : "NO");
		}
		br.close();
	}

	private static long areNumbersSeparated(String s) {
		if (s.charAt(0) == '0') {
			return -1;
		}

		for (int length = 1; length * 2 <= s.length(); length++) {
			long firstNumber = Long.parseLong(s.substring(0, length));

			StringBuilder sequence = new StringBuilder();
			long number = firstNumber;
			while (sequence.length() < s.length()) {
				sequence.append(number);
				number++;
			}
			if (sequence.toString().equals(s)) {
				return firstNumber;
			}
		}
		return -1;
	}

}
