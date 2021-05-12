package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class RangeQuerySumImmutable {

	private int[] nums;

	public RangeQuerySumImmutable(int[] nums) {
		this.nums = nums;
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i - 1] + nums[i];
		}
	}

	public static void main(String[] args) {
		RangeQuerySumImmutable rq = new RangeQuerySumImmutable(new int[] { -2, 0, 3, -5, 2, -1 });
		int[][] queries = { { 0, 2 }, { 2, 5 }, { 0, 5 } };
		for (int[] query : queries)
			System.out.println(rq.sum(query[0], query[1]));
	}

	public int sum(int start, int end) {
		return nums[end] - (start - 1 >= 0 ? nums[start - 1] : 0);
	}

}
