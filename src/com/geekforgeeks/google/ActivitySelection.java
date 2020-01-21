package com.geekforgeeks.google;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Shrey
 *
 */
public class ActivitySelection {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			Activity[] activities = new Activity[n];

			for (int i = 0; i < n; i++)
				activities[i] = new Activity(scan.nextInt(), -1);

			for (int i = 0; i < n; i++)
				activities[i].f = scan.nextInt();

			System.out.println(maxActivitySelection(activities, n));

		}
		scan.close();
	}

	private static final int maxActivitySelection(Activity[] activities, int n) {
		Arrays.sort(activities);
		int count = 1;
		int[] start = new int[n];
		int[] finish = new int[n];
		for (int i = 0; i < n; i++) {
			start[i] = activities[i].s;
			finish[i] = activities[i].f;
		}

		int i = 0;
		for (int j = 1; j < n; j++) {
			if (start[j] >= finish[i]) {
				i = j;
				count++;
			}
		}

		return count;
	}

	private static final class Activity implements Comparable<Activity> {
		int s, f;

		public Activity(int s, int f) {
			this.s = s;
			this.f = f;
		}

		@Override
		public int compareTo(Activity o) {
			return ((Integer) this.f).compareTo(o.f);
		}
	}

}
