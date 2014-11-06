package com.hackerrank.search;

import java.util.HashMap;
import java.util.Scanner;

/**There are N integers in an array A. All but one integer occur in pairs. Your task is to find out the number that occurs only once.

 Input Format

 The first line of the input contains an integer N indicating number of integers. 
 The next line contains N space separated integers that form the array A.

 Constraints

 1 <= N < 100 
 N % 2 = 1 ( N is an odd number ) 
 0 <= A[i] <= 100, ∀ i ∈ [1, N]

 Output Format

 Output S, the number that occurs only once.

 Sample Input:1

 1
 1
 Sample Output:1

 1
 Sample Input:2

 3
 1 1 2
 Sample Output:2

 2
 Sample Input:3

 5
 0 0 1 2 1
 Sample Output:3

 2
 Explanation

 In the first input, we see only 1 element and that element is the answer (1). 
 In the second input, we see 3 elements, 1 is repeated twice. The element that occurs only once is 2. 
 In the third input, we see 5 elements, 1 and 0 are repeated twice. And the element that occurs only once is 2.*/

/**
 * @author Shrey
 *
 */
public class LonelyInteger {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < N; i++) {
			int a = scan.nextInt();
			if (!map.containsKey(a)) {
				map.put(a, 1);
			} else {
				int val = map.get(a);
				map.put(a, val + 1);
			}

		}
		int i = 0;
		while (true) {
			if (map.containsKey(i)) {
				if (map.get(i) == 1) {
					System.out.println(i);
					break;
				}
			}
			i++;
		}

		scan.close();
	}
}
