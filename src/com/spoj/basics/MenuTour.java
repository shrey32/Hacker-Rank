package com.spoj.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <a href="https://www.spoj.com/problems/MENUTOUR/">MENUTOUR - Menu Tour</a>
 * 
 * @author Shrey
 *
 */
public class MenuTour {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		int r = scan.nextInt();
		int b = scan.nextInt();
		List<Restaurant> restaurants = new ArrayList<>();
		Restaurant start = null;
		int prevPrice = Integer.MAX_VALUE;
		for (int i = 0; i < r; i++) {
			Location loc = new Location(scan.nextInt(), scan.nextInt());
			List<Integer> courses = new ArrayList<>();
			for (int j = 0; j < c; j++)
				courses.add(scan.nextInt());

			if (courses.get(0) != 0 && courses.get(0) < prevPrice) {
				prevPrice = Math.min(prevPrice, courses.get(0));
				start = new Restaurant(loc, courses);
			}

			restaurants.add(new Restaurant(loc, courses));
		}
		System.out.println(tour(restaurants, start, c, b));
		scan.close();
	}

	private static final int tour(List<Restaurant> restaurants, Restaurant start, int c, int b) {
		int minTime = 0;
		int courseNum = 1;
		int totalSpent = start.courses.get(0);
		// look for the min price next course

		while (courseNum < c) {
			final int currCourse = courseNum;
			List<Restaurant> offerNextCourses = restaurants.stream().filter(res -> res.courses.get(currCourse) != 0)
					.collect(Collectors.toList());
			// min price next course
			Restaurant next = offerNextCourses.stream()
					.min((res1, res2) -> res1.courses.get(currCourse).compareTo(res2.courses.get(currCourse))).get();

			totalSpent += next.courses.get(courseNum);

			minTime += (Math.abs(start.location.i - next.location.i) + Math.abs(start.location.j - next.location.j));

			start = next;
			courseNum++;

			if (totalSpent >= b && courseNum < (c - 1))// courses not finished but budget is finished
				return -1;
		}

		return minTime;
	}

	private static class Restaurant {
		private final Location location;
		private final List<Integer> courses = new ArrayList<>();

		public Restaurant(Location location, List<Integer> courses) {
			this.location = location;
			this.courses.addAll(courses);
		}

		@Override
		public String toString() {
			return "Restaurant [(" + location + "), courses=" + courses + "]";
		}

	}

	private static class Location {
		final private int i, j;

		public Location(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return i + "," + j;
		}
	}

}
