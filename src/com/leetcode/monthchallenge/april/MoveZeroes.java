package com.leetcode.monthchallenge.april;

import java.util.Arrays;

/**
 * <p>
 * <b>Move Zeroes</b>
 * <p>
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * </p>
 * 
 * <b>Example:</b>
 * 
 * <p>
 * <b>Input:</b> [0,1,0,3,12]
 * </p>
 * <p>
 * <b>Output:</b> [1,3,12,0,0]
 * </p>
 * 
 * <b>Note:</b>
 * 
 * <p>
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 * </p>
 * <b>Hide Hint #1</b>
 * <p>
 * In-place means we should not be allocating any space for extra array. But we
 * are allowed to modify the existing array. However, as a first step, try
 * coming up with a solution that makes use of additional space. For this
 * problem as well, first apply the idea discussed using an additional array and
 * the in-place solution will pop up eventually.
 * </p>
 * 
 * <b>Hide Hint #2</b>
 * <p>
 * A two-pointer approach could be helpful here. The idea would be to have one
 * pointer for iterating the array and another pointer that just works on the
 * non-zero elements of the array.
 * </p>
 * 
 * @author Shrey
 *
 */
public class MoveZeroes {

	public static void main(String[] args) {
		moveZeroes(new int[] { 0, 1, 0, 3, 12 });
		moveZeroes(new int[] { 1, 1, 0, 0, 5, 0, 9, 3, 12, 0, 0 });
		moveZeroes(new int[] { 0, 0, 0, 3, 12, 4 });
	}

	public static void moveZeroes(int[] ar) {
		int j = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != 0) {
				int temp = ar[i];
				ar[i] = 0;
				ar[j++] = temp;
			}
		}

		System.out.println(Arrays.toString(ar));
	}
}
