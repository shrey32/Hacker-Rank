package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class MaximumPointsYouCanObtainFromCards {

	public static void main(String[] args) {
		System.out.println(maxScore(new int[] { 1, 2, 3, 4, 5, 6, 1 }, 3));
	}

	/**
	 * 
	 * @param cardPoints
	 * @param k
	 * @return
	 */
	public static int maxScore(int[] cardPoints, int k) {
		int n = cardPoints.length;
		int sum = 0;

		for (int i = 0; i < k; i++) {
			sum += cardPoints[i];
		}

		int windowsum = sum;
		for (int i = 0, j = n - 1; i < k; j--, i++) {
			windowsum += cardPoints[j] - cardPoints[k - 1 - i];
			sum = Math.max(sum, windowsum);
		}

		return sum;
	}

}
