package com.hackerrank.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**Given N integers, count the number of pairs of integers whose difference is K.

 Input Format 
 The 1st line contains N & K (integers). 
 The 2nd line contains N numbers of the set. All the N numbers are distinct.

 Output Format 
 An integer that tells the number of pairs of integers whose difference is K.

 Constraints: 
 N <= 105 
 0 < K < 109 
 Each integer will be greater than 0 and at least K smaller than 231-1

 Sample Input #00:

 5 2  
 1 5 3 4 2  
 Sample Output #00:

 3
 Sample Input #01:

 10 1  
 363374326 364147530 61825163 1073065718 1281246024 1399469912 428047635 491595254 879792181 1069262793 
 Sample Output #01:

 0*/
/**
 * @author Shrey
 *
 */
public class Pairs {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String l = br.readLine();
			int n = Integer.parseInt(l.split(" ")[0]);
			int diff = Integer.parseInt(l.split(" ")[1]);
			String line = br.readLine();
			String[] s = line.split(" ");
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(s[i]);
			}
			Arrays.sort(num);
			int count = 0;
	        count=pairsCount(num, diff);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int pairsCount(int[] a, int k) {
		if (null == a || a.length == 0) {
			return 0;
		}
		int result = 0;
		Map<Integer, Integer> map = countOccurrences(a);
		for (int value : a) {
			int target = value + k;
			if (map.containsKey(target)) {
				result += map.get(target);
			}
		}
		return result;
	}

	private static Map<Integer, Integer> countOccurrences(int[] a) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(a.length);
		for (int value : a) {
			if (map.containsKey(value)) {
				map.put(value, map.get(value) + 1);
			} else {
				map.put(value, 1);
			}
		}
		return map;
	}
}
