package com.hackerrank.practice;

/**
 * Keko has  dots in a 2-D coordinate plane. He wants to measure the gap between the most distant two dots. To make the problem easier, Keko decided to change each dot's  or  coordinate to zero.

Help Keko calculate the distance!

Input Format

The first line contains an integer, , the number of dots.
The next  lines each contain the integer coordinates of the dots in  fashion.

Constraints


It is guaranteed that all dots are distinct, and either their  or  coordinate is equal to .

Output Format

Print the distance between the most distant dots with an absolute error of, at most, .

Sample Input

4
-1 0
1 0
0 1
0 -1
Sample Output

2.000000
Explanation

In the sample, the most distant dots are located at  and .
The distance between them is .
 */
/**
 * 
 * @author Shrey
 *
 */
public class MostDistant {

	public static void main(String[] args) {
		System.out.println(maxDistance(new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }));
	}

	static double maxDistance(int[][] coordinates) {

		int maxx = 0, maxy = 0, minx = 0, miny = 0;
		for (int i = 0; i < coordinates.length; i++) {
			int x = coordinates[i][0];
			int y = coordinates[i][1];
			if (x > maxx)
				maxx = x;
			if (x < minx)
				minx = x;
			if (y > maxy)
				maxy = y;
			if (y < miny)
				miny = y;
		}

		Double max = 0.0;

		double minxsq = Math.pow(minx, 2);
		double maxxsq = Math.pow(maxx, 2);
		double minysq = Math.pow(miny, 2);
		double maxysq = Math.pow(maxy, 2);

		max = Math.max(max, maxx - minx);
		max = Math.max(max, maxy - miny);
		max = Math.max(max, Math.sqrt(maxxsq + maxysq));
		max = Math.max(max, Math.sqrt(maxxsq + minysq));
		max = Math.max(max, Math.sqrt(minxsq + maxysq));
		max = Math.max(max, Math.sqrt(minxsq + minysq));

		return max;
	}

	/**
	 * sqrt((x2-x1)^2 + (y2-y1)^2)
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	static double distance(int x1, int y1, int x2, int y2) {
		double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		return distance;
	}

}
