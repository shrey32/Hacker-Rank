package com.leetcode.monthchallenge.july;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class PrisonCellAfterNDays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(prisonAfterNDays(new int[] { 0, 1, 0, 1, 1, 0, 0, 1 }, 7)));
	}

	public static int[] prisonAfterNDays(int[] cells, int n) {

		int cycle = 1;

		int[] first = processedCell(cells);

		n--;

		for (int i = 0; i < 8; i++)
			cells[i] = first[i];

		while (n-- > 0) {

			int[] temp = new int[8];
			temp = processedCell(cells);

			if (Arrays.equals(temp, first))
				n = n % cycle;

			for (int i = 0; i < 8; i++)
				cells[i] = temp[i];

			cycle++;
		}
		return cells;
	}

	private static int[] processedCell(int[] cells) {
		int[] temp = new int[8];
		for (int i = 1; i < 7; i++) {
			temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
		}
		return temp;
	}

}
