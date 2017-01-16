package com.hackerrank.datastructures.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if left rotations are performed on array , then the array would become .

 Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.

 Input Format

 The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform). 
 The second line contains  space-separated integers describing the respective elements of the array's initial state.

 Constraints

 Output Format

 Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

 Sample Input

 5 4
 1 2 3 4 5
 Sample Output

 5 1 2 3 4
 Explanation

 When we perform  left rotations, the array undergoes the following sequence of changes:

 Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.
 */
/**
 * 
 * @author Shrey
 *
 */
public class LeftRotation {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().trim().split(" ");
		int n = Integer.parseInt(arr[0]);
		int r = Integer.parseInt(arr[1]);
		arr = br.readLine().trim().split(" ");
		int c = 0, d = r;
		while (c < n) {
			System.out.print(arr[d]+" ");
			if (d + 1 < n)
				d++;
			else
				d = 0;
			c++;
		}
	}

}
