package com.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		String line = br.readLine();
		long[] nums = new long[l];
		String[] numArray = line.split(" ");
		for (int i = 0; i < numArray.length; i++) {
			nums[i] = Integer.parseInt(numArray[i]);
		}
		List<Triplet> list = new ArrayList<Triplet>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] < nums[j]
							&& nums[j] < nums[k]
							&& !list.contains(new Triplet(nums[i], nums[j],
									nums[k]))) {
						list.add(new Triplet(nums[i], nums[j], nums[k]));
					}
				}
			}
		}
		System.out.println(list.size());
	}

	public static class Triplet {
		long a, b, c;

		public Triplet(long a, long b, long c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			long result = 1;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
			return (int) result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Triplet other = (Triplet) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}
	}
}
