package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KClosestPoints {

	public static void main(String[] args) {
		print(kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1));
		print(kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2));
	}

	private static void print(int[][] ar) {
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i][0] + "," + ar[i][1]);
		}
	}

	public static int[][] kClosest(int[][] points, int k) {

		List<Point> distances = new ArrayList<>();
		for (int i = 0; i < points.length; i++) {
			int x = points[i][0];
			int y = points[i][1];
			double dist = distance(x, y);
			distances.add(new Point(x, y, dist));
		}

		distances.sort((a, b) -> {
			return a.dist.compareTo(b.dist);
		});

		int[][] result = new int[k][2];

		for (int i = 0; i < k; i++) {
			if (i < distances.size()) {
				result[i][0] = distances.get(i).x;
				result[i][1] = distances.get(i).y;
			}
		}

		return result;
	}

	private static class Point {

		int x, y;
		Double dist;

		public Point(int x, int y, Double dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dist == null) ? 0 : dist.hashCode());
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (dist == null) {
				if (other.dist != null)
					return false;
			} else if (!dist.equals(other.dist))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

	private static double distance(int x, int y) {
		double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return distance;
	}

}
