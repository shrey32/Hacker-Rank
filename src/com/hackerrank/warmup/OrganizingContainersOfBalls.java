package com.hackerrank.warmup;

import java.util.Arrays;

public class OrganizingContainersOfBalls {

	public static void main(String[] args) {
		System.out.println(organizingContainers(new int[][] { { 1, 1 },	{ 1, 1 } }));//Possible
		System.out.println(organizingContainers(new int[][] { { 0, 2 },	{ 1, 1 } }));//Impossible
		System.out.println(organizingContainers(new int[][] { { 1, 3, 1 },	{ 2, 1, 2 },{3, 3, 3}}));//Impossible
		System.out.println(organizingContainers(new int[][] { { 0, 2, 1 },	{ 1, 1, 1 }, {2, 0, 0} }));//Possible
	}

	/**
	 * Complete the organizingContainers function below.
	 * 
	 * @param container
	 * @return
	 */
	static String organizingContainers(int[][] container) {
		int n = container.length;
		int a[] = new int[n]; //total balls in a container
		int b[] = new int[n]; //total of each type of balls

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i] += container[i][j];
				b[i] += container[j][i];
			}
		}
		Arrays.sort(a);
		Arrays.sort(b);
		return Arrays.equals(a, b) ? "Possible" : "Impossible";
	}

}
