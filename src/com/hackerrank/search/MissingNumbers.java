package com.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**Problem Statement

 Numeros, The Artist, had two lists A and B, such that, B was a permutation of A. Numeros was very proud of these lists. Unfortunately, while transporting them from one exhibition to another, some numbers from List A got left out. Can you find out the numbers missing from A?

 Notes

 If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both the lists is the same. If that is not the case, then it is also a missing number.
 You have to print all the missing numbers in ascending order.
 Print each missing number once, even if it is missing multiple times.
 The difference between maximum and minimum number in the list B is less than or equal to 100.
 Input Format 
 There will be four lines of input:

 n - the size of the first list 
 This is followed by n space separated integers that make up the first list. 
 m - the size of the second list 
 This is followed by m space separated integers that make up the second list.

 Output Format 
 Output the missing numbers in ascending order

 Constraints 
 1<= n,m <= 1000010 
 1 <= x <= 10000 , x ∈ B 
 Xmax - Xmin < 101

 Sample Input

 10
 203 204 205 206 207 208 203 204 205 206
 13
 203 204 204 205 206 207 205 208 203 206 205 206 204
 Sample Output

 204 205 206
 Explanation 
 204 is present in both the arrays. Its frequency in A is 2, while its frequency in B is 3. Similarly, 205 and 206 occur twice in A, but thrice in B. So, these three numbers are our output. Rest of the numbers have same frequency in both the lists.

 */

/**
 * @author Shrey
 *
 */
public class MissingNumbers {
	private static int MAX1 = Integer.MIN_VALUE;
	private static int MAX2 = Integer.MIN_VALUE;
	private static int MIN1 = Integer.MAX_VALUE;
	private static int MIN2 = Integer.MAX_VALUE;

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int A = Integer.parseInt(br.readLine());
			Map<Integer, Integer> map1 = getValues(A, br, 1);
			int B = Integer.parseInt(br.readLine());
			Map<Integer, Integer> map2 = getValues(B, br, 2);
			List<Integer> list = getMissingNumbers(map1, map2);
			for (int i : list) {
				System.out.print(i + " ");
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static List<Integer> getMissingNumbers(Map<Integer, Integer> map1,
			Map<Integer, Integer> map2) {
		List<Integer> list = new ArrayList<Integer>();

		int i = (MIN1 < MIN2 ? MIN1 : MIN2) - 1;
		int j = (MAX1 > MAX2 ? MAX1 : MAX2) + 1;
		while (i <= j) {
			if (map1.containsKey(i) && map2.containsKey(i)) {
				int a = map1.get(i);
				int b = map2.get(i);
				if (a != b) {
					list.add(i);
				}
			}
			i++;
		}
		return list;
	}

	private static Map<Integer, Integer> getValues(int A, BufferedReader br,
			int a) throws IOException {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		String line = br.readLine();
		String[] array = line.split(" ");
		for (int i = 0; i < array.length; i++) {
			int key = Integer.parseInt(array[i]);

			if (a == 2) {
				if (key < MIN2) {
					MIN2 = key;
				}
				if (key > MAX2) {
					MAX2 = key;
				}
			}
			if (a == 1) {
				if (key < MIN1) {
					MIN1 = key;
				}
				if (key > MAX1) {
					MAX1 = key;
				}
			}
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				int val = map.get(key);
				map.put(key, val + 1);
			}
		}
		return map;
	}
}
