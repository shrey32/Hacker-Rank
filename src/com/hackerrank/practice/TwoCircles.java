package com.hackerrank.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.spoj.com/problems/SMPCIRC/">SMPCIRC - Two Circles</a>
 * 
 * @author Shrey
 *
 */
public class TwoCircles {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String inpLine = br.readLine();
			String[] inputs = inpLine.split(" ");
			solve(new Circle(inputs[0], inputs[1], inputs[2]), new Circle(inputs[3], inputs[4], inputs[5]));
		}
		br.close();
	}

	/**
	 * 
	 * @param p1
	 * @param p2
	 */
	private static final void solve(Circle p1, Circle p2) {
		/** check if distance from center of the circle */
		double distSq = Math.sqrt(((p1.x - p2.x) * (p1.x - p2.x)) + ((p1.y - p2.y) * (p1.y - p2.y)));

		if (distSq == Math.abs(p2.r - p1.r))// distance equal to the diff of radius
			System.out.println("E");
		else if (distSq < Math.abs(p2.r - p1.r))// distance smaller than the diff of radius
			System.out.println("I");
		else
			System.out.println("O");
	}

	/**
	 * 
	 * @author Shrey
	 *
	 */
	static class Circle {
		int x, y, r;

		public Circle(String x, String y, String r) {
			this.x = Integer.parseInt(x);
			this.y = Integer.parseInt(y);
			this.r = Integer.parseInt(r);
		}
	}

}
