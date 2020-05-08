package com.leetcode.monthchallenge.may;

/**
 * <b>Check If It Is a Straight Line</b>
 * <p>
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 * represents the coordinate of a point. Check if these points make a straight
 * line in the XY plane.
 * </p>
 * 
 * <b>Example 1:</b>
 * <p>
 * <b>Input:</b> coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * </p>
 * <p>
 * <b>Output:</b> true
 * </p>
 * 
 * <b>Example 2:</b>
 * <p>
 * <b>Input:</b> coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * </p>
 * <p>
 * <b>Output:</b> false
 * </p>
 * 
 * 
 * <b>Constraints:</b>
 * 
 * <li>2 <= coordinates.length <= 1000</li>
 * <li>coordinates[i].length == 2</li>
 * <li>-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4</li>
 * <li>coordinates contains no duplicate point.</li>
 * 
 * @author Shrey
 *
 */
public class CheckStraightLine {

	public static void main(String[] args) {
		System.out
				.println(checkStraightLine(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } }));// true
		System.out
				.println(checkStraightLine(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } }));// false
	}

	public static boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length == 2)
			return true;

		for (int i = 1; i < coordinates.length - 1; i++) {
			int x1 = coordinates[i - 1][0], y1 = coordinates[i - 1][1];
			int x2 = coordinates[i][0], y2 = coordinates[i][1];
			int x3 = coordinates[i + 1][0], y3 = coordinates[i + 1][1];
			if ((y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1))
				return false;
		}
		return true;
	}

}
