package com.hackerrank.datastructures.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * There are  strings. Each string's length is no more than  characters. There are also  queries. For each query, you are given a string, and you need to find out how many times this string occurred previously.

 Input Format

 The first line contains , the number of strings.
 The next  lines each contain a string.
 The nd line contains , the number of queries.
 The following  lines each contain a query string.

 Constraints





 Sample Input

 4
 aba
 baba
 aba
 xzxb
 3
 aba
 xzxb
 ab
 Sample Output

 2
 1
 0
 Explanation

 Here, "aba" occurs twice, in the first and third string. The string "xzxb" occurs once in the fourth string, and "ab" does not occur at all.
 */
/**
 * 
 * @author Shrey
 *
 */
public class SparseArrays {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String s = "";
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			s = br.readLine().trim();
			map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
		}
		int q = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < q; i++) {
			s = br.readLine().trim();
			System.out.println(map.containsKey(s) ? map.get(s) : 0);
		}
		br.close();
	}
}
