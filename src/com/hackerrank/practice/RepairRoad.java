package com.hackerrank.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.spoj.com/problems/REPROAD/">REPROAD - Repair road</a>
 * 
 * @author Shrey
 *
 */
public class RepairRoad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] inputs = br.readLine().split(" ");
			int units = Integer.parseInt(inputs[1]);
			String[] roadBlocks = br.readLine().split(" ");
			System.out.println(nConsecutiveBlocks(units, roadBlocks));
		}
		br.close();
	}

	static final int nConsecutiveBlocks(int units, String[] roadBlocks) {
		int max = nConsecutiveBlocks(units, roadBlocks.length, roadBlocks);
		reverse(roadBlocks);
		max = Math.max(max, nConsecutiveBlocks(units, roadBlocks.length, roadBlocks));
		return max;
	}

	static final void reverse(String[] ar) {
		for (int i = 0, j = ar.length - 1; i < ar.length / 2; i++, j--) {
			String temp = ar[i];
			ar[i] = ar[j];
			ar[j] = temp;
		}
	}

	static final int nConsecutiveBlocks(int units, int n, String[] roadBlocks) {

		int max = Integer.MIN_VALUE;
		int tempMax = 0;
		int onesCount = 0;
		int unitsConsumed = 0;

		for (int i = 0; i < n; i++) {

			if (unitsConsumed == units && "0".equals(roadBlocks[i])) {
				unitsConsumed = 1;
				max = Math.max(tempMax, max);
				tempMax = onesCount + 1;
			} else if (unitsConsumed < units && "0".equals(roadBlocks[i])) {
				unitsConsumed++;
				tempMax++;
			} else {
				tempMax++;
			}

			if ("0".equals(roadBlocks[i]))
				onesCount = 0;
			else
				onesCount++;
		}

		max = Math.max(tempMax, max);

		return max;
	}

}
