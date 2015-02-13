package com.hackerrank.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem Statement

 There is an integer array d which does not contain more than two elements of the same value. How many distinct ascending triples (d[i] < d[j] < d[k], i < j < k) are present? 

 Input format 
 The first line contains an integer N denoting the number of elements in the array. This is followed by a single line containing N space separated integers. Please note that there are no leading spaces before the first number, and there are no trailing spaces after the last number.

 Output format: 
 A single integer that denotes the number of distinct ascending triplets present in the array

 Constraints: 
 N <= 10^5 
 Every element of the array is present at most twice 
 Every element of the array is a 32-bit non-negative integer

 Sample input: 
 6 
 1 1 2 2 3 4

 Sample output: 
 4

 Explanation: 
 The distinct triplets are 
 (1,2,3) 
 (1,2,4) 
 (1,3,4) 
 (2,3,4)

 The elements of the array might not be sorted. Make no assumptions of the same.
 */
/**
 * 
 * @author Shrey
 *
 */
public class Triplets {

	int[] lSmaller, rLarger, treeArray, dscArray, lFlags, rFlags;

	int size, count = 0;

	Triplets(int aSize, int[] inputArray) {
		size = aSize;
		lSmaller = new int[size];
		rLarger = new int[size];
		dscArray = new int[size];
		int[] tmpArray = Arrays.copyOf(inputArray, inputArray.length);
		Arrays.sort(tmpArray);
		HashMap<Integer, Integer> tmpMap = new HashMap<Integer, Integer>(size);
		for (int i = 0; i < size; i++) {
			if (!tmpMap.containsKey(tmpArray[i])) {
				count++;
				tmpMap.put(tmpArray[i], count);
			}
		}
		count++;
		treeArray = new int[count];
		lFlags = new int[count];
		rFlags = new int[count];
		for (int i = 0; i < size; i++) {
			dscArray[i] = tmpMap.get(inputArray[i]);
		}

	}

	void update(int idx) {
		while (idx < count) {
			treeArray[idx]++;

			idx += (idx & -idx);
		}
	}

	int read(int index) {
		int sum = 0;
		while (index > 0) {
			sum += treeArray[index];
			index -= (index & -index);
		}
		return sum;
	}

	void countLeftSmaller() {
		Arrays.fill(treeArray, 0);
		Arrays.fill(lSmaller, 0);
		Arrays.fill(lFlags, 0);
		for (int i = 0; i < size; i++) {
			int val = dscArray[i];
			lSmaller[i] = read(val - 1);
			if (lFlags[val] == 0) {
				update(val);
				lFlags[val] = i + 1;
			} else {
				lSmaller[i] -= lSmaller[lFlags[val] - 1];
			}
		}
	}

	void countRightLarger() {

		Arrays.fill(treeArray, 0);
		Arrays.fill(rLarger, 0);
		Arrays.fill(rFlags, 0);
		for (int i = size - 1; i >= 0; i--) {
			int val = dscArray[i];
			rLarger[i] = read(count - 1) - read(val);
			if (rFlags[val] == 0) {
				update(val);
				rFlags[val] = i + 1;
			}
		}
	}

	long countTriplets() {
		long sum = 0;
		for (int i = 0; i < size; i++) {
			sum += lSmaller[i] * rLarger[i];
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		String[] strs = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(strs[i]);
		Triplets sol = new Triplets(N, a);
		sol.countLeftSmaller();
		sol.countRightLarger();
		System.out.println(sol.countTriplets());
	}
}
