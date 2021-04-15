package com.crackingthecodinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Check out the resources on the page's right side to learn more about arrays. The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.
 A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if left rotations are performed on array , then the array would become .

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
/***
 * 
 * @author Shrey
 *
 */
public class ArrayLeftRotation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		int r = Integer.parseInt(line.split(" ")[1]);
		String[] arr = br.readLine().trim().split(" ");
		br.close();
		arr = leftRotation(r, arr);
		for (String s : arr)
			System.out.print(s + " ");
	}

	private static String[] leftRotation(int k, String... arr) {
		String[] rotated = new String[arr.length];
		System.arraycopy(arr, k, rotated, 0, arr.length - k);
		System.arraycopy(arr, 0, rotated, arr.length - k, k);
		return rotated;
	}

}
