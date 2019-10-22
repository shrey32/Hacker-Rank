package com.hackerrank.strings;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

 For example , the list of all anagrammatic pairs is  at positions  respectively.

 Function Description

 Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .

 sherlockAndAnagrams has the following parameter(s):

 s: a string .
 Input Format

 The first line contains an integer , the number of queries. 
 Each of the next  lines contains a string  to analyze.

 Constraints



 String  contains only lowercase letters  ascii[a-z].

 Output Format

 For each query, return the number of unordered anagrammatic pairs.

 Sample Input 0

 2
 abba
 abcd
 Sample Output 0

 4
 0
 Explanation 0

 The list of all anagrammatic pairs is  and  at positions  and  respectively.

 No anagrammatic pairs exist in the second query as no character repeats.

 Sample Input 1

 2
 ifailuhkqq
 kkkk
 Sample Output 1

 3
 10
 Explanation 1

 For the first query, we have anagram pairs  and  at positions  and respectively.

 For the second query: 
 There are 6 anagrams of the form  at positions  and . 
 There are 3 anagrams of the form  at positions  and . 
 There is 1 anagram of the form  at position .

 Sample Input 2

 1
 cdcd
 Sample Output 2

 5
 Explanation 2

 There are two anagrammatic pairs of length :  and . 
 There are three anagrammatic pairs of length :  at positions  respectively.
 */
/**
 * 
 * @author Shrey
 *
 */
public class SherlockAndAnagrams {

	public static void main(String[] args) {
		System.out.println(sherlockAndAnagrams("abba"));// 4
		System.out.println(sherlockAndAnagrams("abcd"));// 0
		//System.out.println(sherlockAndAnagrams("ifailuhkqq"));// 3
		System.out.println(sherlockAndAnagrams("kkkk"));// 10
		System.out.println(sherlockAndAnagrams("cdcd"));// 5
	}

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {
		Map<String, Integer> map = new LinkedHashMap<>();
		for (char c : s.toCharArray())
			map.put(String.valueOf(c),
					map.getOrDefault(String.valueOf(c), 0) + 1);

		for (int i = 0; i < s.length() - 1; i++) {
			StringBuilder sb = new StringBuilder(String.valueOf(s.charAt(i)));
			for (int j = i + 1; j < s.length() - 1; j++) {
				sb.append(String.valueOf(s.charAt(j)));
				map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
			}
		}
		int count = 0;
		for (String key : map.keySet()) {
			if (map.get(key) > 1) {
				count++;
			} else if (key.length() > 1) {
				Set<String> set = new HashSet<>();
				permutation("", key, set);
				System.out.println(set);
				for (String str : set) {
					if (map.containsKey(str))
						count++;
				}
			}
		}
		System.out.println(map);
		return count;
	}

	static void permutation(String prefix, String remaining, Set<String> set) {
		if (remaining.length() == 0) {
			set.add(prefix);
			return;
		}
		for (int i = 0; i < remaining.length(); i++) {
			permutation(prefix + remaining.charAt(i), remaining.substring(0, i)
					+ remaining.substring(i + 1, remaining.length()), set);
		}
	}

}
