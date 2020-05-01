package com.leetcode.monthchallenge.may;

/**
 * <b>First Bad Version</b>
 * 
 * <p>
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * </p>
 * 
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * </p>
 * 
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 * </p>
 * 
 * <b>Example:</b>
 * 
 * <p>
 * Given n = 5, and version = 4 is the first bad version.
 * </p>
 * 
 * <p>
 * call isBadVersion(3) -> false
 * </p>
 * <p>
 * call isBadVersion(5) -> true
 * </p>
 * <p>
 * call isBadVersion(4) -> true
 * </p>
 * 
 * <p>
 * Then 4 is the first bad version.
 * </p>
 * 
 * 
 * @author Shrey
 *
 */
public class FirstBadVersion {

	public static void main(String[] args) {
		System.out.println(firstBadVersion(5));
	}

	public static int firstBadVersion(int n) {
		int val = bSearch(1, n);
		return val;
	}

	public static int bSearch(int i, int j) {
		int ans = 0;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (isBadVersion(mid)) {
				j = mid - 1;
				ans = mid;
			} else {
				i = mid + 1;
			}
		}
		return ans;
	}

	public static boolean isBadVersion(int n) {
		return false;
	}

}
