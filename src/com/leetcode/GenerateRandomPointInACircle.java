package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class GenerateRandomPointInACircle {

	private double radius, x_center, y_center;

	public GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
		this.radius = radius;
		this.x_center = x_center;
		this.y_center = y_center;
	}

	public double[] randPoint() {
		double x1 = random(radius, x_center);
		double y1 = random(radius, y_center);
		while (getDistance(x1, y1) > radius * radius) {
			x1 = random(radius, x_center);
			y1 = random(radius, y_center);
		}

		return new double[] { x1, y1 };
	}

	private double random(double radius, double c) {
		return c - radius + Math.random() * (2 * radius);
	}

	private double getDistance(double x, double y) {
		return (x - x_center) * (x - x_center) + (y - y_center) * (y - y_center);
	}

}
