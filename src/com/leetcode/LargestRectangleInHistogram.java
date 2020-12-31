package com.leetcode;

/**
 * <a href=
 * "https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3587/">Largest
 * Rectangle in Histogram</a>
 * 
 * @author Shrey
 *
 */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));// 10
		System.out.println(largestRectangleArea(new int[] { 2, 1, 2 }));// 3
		System.out.println(largestRectangleArea(new int[] { 0, 9 }));// 9
	}

	public static int largestRectangleArea(int[] heights) {
		int max = 0;
        for(int i=0; i<heights.length; i++){
        	int minHeight = Integer.MAX_VALUE;
        	for(int j=i; j<heights.length; j++){
        		minHeight = Math.min(minHeight, heights[j]);
        		int distance = j-i+1;
        		int area = distance * minHeight;
        		max = Math.max(max, area);
        	}
        }
        return max;

	}

}
