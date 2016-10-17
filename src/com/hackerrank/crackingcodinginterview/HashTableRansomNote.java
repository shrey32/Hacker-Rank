package com.hackerrank.crackingcodinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use substrings or concatenation to create the words he needs.

 Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.

 Input Format

 The first line contains two space-separated integers describing the respective values of  (the number of words in the magazine) and  (the number of words in the ransom note). 
 The second line contains  space-separated strings denoting the words present in the magazine. 
 The third line contains  space-separated strings denoting the words present in the ransom note.

 Constraints

 .
 Each word consists of English alphabetic letters (i.e.,  to  and  to ).
 The words in the note and magazine are case-sensitive.
 Output Format

 Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No.

 Sample Input

 6 4
 give me one grand today night
 give one grand today
 Sample Output

 Yes
 Explanation

 All four words needed to write an untraceable replica of the ransom note are present in the magazine, so we print Yes as our answer.
 */
/**
 * 
 * @author Shrey
 *
 */
public class HashTableRansomNote {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		int m = Integer.parseInt(line.split(" ")[0]);
		int w = Integer.parseInt(line.split(" ")[1]);
		line = br.readLine().trim();// magazine
		Map<String, Integer> map1 = new HashMap<String, Integer>(m);
		for (String s : line.split(" "))
			map1.put(s, map1.containsKey(s) ? map1.get(s) + 1 : 1);
		line = br.readLine().trim();// note
		Map<String, Integer> map2 = new HashMap<String, Integer>(w);
		for (String s : line.split(" "))
			map2.put(s, map2.containsKey(s) ? map2.get(s) + 1 : 1);
		boolean isPresent = true;
		for (String s : map2.keySet()) {
			if (!map1.containsKey(s) || map1.get(s) < map2.get(s)) {
				isPresent = false;
				break;
			}
		}
		System.out.println(isPresent ? "Yes" : "No");
		br.close();
	}
}
