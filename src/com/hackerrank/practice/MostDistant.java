package com.hackerrank.practice;

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

		Double max = Double.MIN_VALUE;

		max = Math.max(max, maxx - minx);
		max = Math.max(max, maxy - miny);
		max = Math.max(max, Math.sqrt(Math.pow(maxx, 2) + Math.pow(maxy, 2)));
		max = Math.max(max, Math.sqrt(Math.pow(maxx, 2) + Math.pow(miny, 2)));
		max = Math.max(max, Math.sqrt(Math.pow(minx, 2) + Math.pow(maxy, 2)));
		max = Math.max(max, Math.sqrt(Math.pow(minx, 2) + Math.pow(miny, 2)));

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
