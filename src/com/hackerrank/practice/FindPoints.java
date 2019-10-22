package com.hackerrank.practice;

/**
 * 
 * Consider two points, and . We consider the inversion or point reflection, ,
 * of point across point to be a rotation of point around .
 * 
 * Given sets of points and , find for each pair of points and print two
 * space-separated integers denoting the respective values of and on a new line.
 * 
 * Input Format
 * 
 * The first line contains an integer, , denoting the number of sets of points.
 * Each of the subsequent lines contains four space-separated integers
 * describing the respective values of , , , and defining points and .
 * 
 * Constraints
 * 
 * Output Format
 * 
 * For each pair of points and , print the corresponding respective values of
 * and as two space-separated integers on a new line.
 * 
 * Sample Input
 * 
 * 2 0 0 1 1 1 1 2 2 Sample Output
 * 
 * 2 2 3 3 Explanation
 * 
 * The graphs below depict points , , and for the points given as Sample Input:
 * 
 * find-point-0011.png Thus, we print and as 2 2 on a new line.
 * find-point-1122.png Thus, we print and as 3 3 on a new line.
 * 
 * @author Shrey
 *
 */
class Point {

	private final int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

}

public class FindPoints {

	public static void main(String[] args) {
		System.out.println(pointReflection(new Point(0, 0), new Point(1, 1)));
		System.out.println(pointReflection(new Point(1, 1), new Point(2, 2)));
	}

	private final static Point pointReflection(Point p, Point q) {

		int diffX = q.getX() - p.getX();
		int diffY = q.getY() - p.getY();

		int rx = (q.getX() + diffX);
		int ry = (q.getY() + diffY);

		return new Point(rx, ry);
	}

}
