package com.hackerrank.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.spoj.com/problems/HS12MBR/">HS12MBR - Minimum Bounding
 * Rectangle</a>
 * 
 * @author Shrey
 *
 */
public class MinimumBoundingRectangle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			while (n-- > 0) {
				String line = br.readLine();
				String[] inputs = line.split(" ");
				switch (inputs[0]) {
				case "p":
					solveForPoints(inputs[1], inputs[2]);
					break;
				case "c":
					solveForCircle(inputs[1], inputs[2], inputs[3]);
					break;
				case "l":
					solveForLineSegment(inputs[1], inputs[2], inputs[3], inputs[4]);
					break;
				default:
					break;
				}

			}
			br.readLine();
		}
		br.close();
	}

	final static void solveForPoints(String x, String y) {
		int x1 = Integer.parseInt(x);
		int y1 = Integer.parseInt(y);
		solveForPoints(x1, y1);
	}

	final static void solveForPoints(int x, int y) {
		System.out.println(x + " " + y + " " + x + " " + y);
	}

	final static void solveForCircle(String x, String y, String r) {
		int xx = Integer.parseInt(x);
		int yy = Integer.parseInt(y);
		int rr = Integer.parseInt(r);
		solveForCircle(xx, yy, rr);
	}

	final static void solveForCircle(int x, int y, int r) {
		int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
		int xd = x - r;
		int yd = y - r;

		maxX = Math.max(xd, maxX);
		minX = Math.min(xd, minX);
		maxY = Math.max(yd, maxY);
		minY = Math.min(yd, minY);

		maxX = Math.max(x, maxX);
		minX = Math.min(x, minX);
		maxY = Math.max(y, maxY);
		minY = Math.min(y, minY);

		System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
	}

	final static void solveForLineSegment(String x1, String y1, String x2, String y2) {
		int xx1 = Integer.parseInt(x1);
		int yy1 = Integer.parseInt(y1);
		int xx2 = Integer.parseInt(x2);
		int yy2 = Integer.parseInt(y2);
		solveForLineSegment(xx1, yy1, xx2, yy2);
	}

	final static void solveForLineSegment(int x1, int y1, int x2, int y2) {
		int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;

		maxX = Math.max(x2, maxX);
		minX = Math.min(x2, minX);
		maxY = Math.max(y2, maxY);
		minY = Math.min(y2, minY);

		maxX = Math.max(x1, maxX);
		minX = Math.min(x1, minX);
		maxY = Math.max(y1, maxY);
		minY = Math.min(y1, minY);
		System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
	}

}
