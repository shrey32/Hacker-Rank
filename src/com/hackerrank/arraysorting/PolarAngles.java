package com.hackerrank.arraysorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**A point (x,y), on the cartesian plane, makes an angle theta with the positive direction of the x-axis. Theta varies in the interval [0 ,2PI) radians, i.e, greater than or equal to zero; but less than 2*PI radians.

 For example, the polar angle of the point (1,2) as marked in this plane below, is (approximately) 63.4 degrees (multiply by PI/180 to convert to radians)

 Ref http://eldar.mathstat.uoguelph.ca/dashlock/Outreach/Articles/images/PRfig1.jpg

 The Task

 Given a list of points in the 2D plane, sort them in ascending order of their polar angle. In case multiple points share exactly the same polar angle, the one with lesser distance from the origin (0,0) should occur earlier in the sorted list.

 Input Format 
 The first line contains an integer N. 
 This is followed by N lines containing pairs of space separated integers, x and y which represent the coordinates of the points in the cartesian plane.

 Constraints 
 1 <= N <= 1000 
 -100 <= x,y <= 100 
 The point (0,0) will not be present in the list of points.

 Output Format 
 The output should contain N lines. Each line should contain two integers x and y, corresponding to a point in the original list. Display the points in ascending order of their polar angle.

 Sample Input

 4  
 1 0  
 0 -1  
 -1 0  
 0 1  
 Sample Output

 1 0    
 0 1    
 -1 0    
 0 -1    
 Explanation

 The point (0,1) has a polar angle of 90 degrees. The point (1,0) has a polar angle of 0 degrees. (-1,0) has a polar angle of 180 degrees and (0,-1) has a polar angle of 270 degrees.*/

/**
 * @author Shrey
 *
 */
public class PolarAngles {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			int N = Integer.parseInt(br.readLine());
			List<Model> modelList = new ArrayList<Model>();
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				if (s.contains(" ")) {
					String[] arr = s.split(" ");
					int x = Integer.parseInt(arr[0]);
					int y = Integer.parseInt(arr[1]);
					Point p = new Point(x, y);
					modelList.add(new Model(getAngle(p), p));
				}
			}
			Collections.sort(modelList);
			for (int i = 0; i < modelList.size(); i++) {
				System.out.println(modelList.get(i).getP().getX() + " "
						+ modelList.get(i).getP().getY());
			}
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static class Point {
		private int a, b;

		public Point(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int getX() {
			return a;
		}

		public void setX(int a) {
			this.a = a;
		}

		public int getY() {
			return b;
		}

		public void setY(int b) {
			this.b = b;
		}
	}

	
	public static class Model implements Comparable<Model>, Comparator<Model> {
		private double theta;
		private Point p;

		public Model(double theta, Point p) {
			this.theta = theta;
			this.p = p;
		}

		public double getTheta() {
			return theta;
		}

		public void setTheta(double theta) {
			this.theta = theta;
		}

		public Point getP() {
			return p;
		}

		public void setP(Point p) {
			this.p = p;
		}

		@Override
		public int compareTo(Model o) {
			return ((int) this.theta) - ((int) o.getTheta());
		}

		@Override
		public int compare(Model o1, Model o2) {
			return o1.compareTo(o2);
		}
	}

	/**
	 * 
	 * @param screenPoint
	 * @return
	 */
	public static double getAngle(Point screenPoint) {
		double dx = screenPoint.getX();
		double dy = screenPoint.getY();
		double t = Math.atan2(dy, dx);
		if (t < 0) {
			return t + 2 * Math.PI;
		} else {
			return t;
		}
	}

}
