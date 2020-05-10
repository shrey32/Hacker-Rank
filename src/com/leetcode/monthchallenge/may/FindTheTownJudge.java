package com.leetcode.monthchallenge.may;

/**
 * <b>Find the Town Judge</b>
 * <p>
 * In a town, there are N people labelled from 1 to N. There is a rumor that one
 * of these people is secretly the town judge.
 * </p>
 * 
 * <p>
 * If the town judge exists, then:
 * </p>
 * 
 * <li>The town judge trusts nobody.</li>
 * <li>Everybody (except for the town judge) trusts the town judge.</li>
 * <li>There is exactly one person that satisfies properties 1 and 2.</li>
 * 
 * <p>
 * You are given trust, an array of pairs trust[i] = [a, b] representing that
 * the person labelled a trusts the person labelled b.
 * </p>
 * 
 * <p>
 * If the town judge exists and can be identified, return the label of the town
 * judge. Otherwise, return -1.
 * </p>
 * 
 * 
 * 
 * <b>Example 1:</b>
 * 
 * <p>
 * <b>Input:</b> N = 2, trust = [[1,2]]
 * </p>
 * <p>
 * <b>Output:</b> 2
 * </p>
 * 
 * <b>Example 2:</b>
 * 
 * <p>
 * <b>Input:</b> N = 3, trust = [[1,3],[2,3]]
 * </p>
 * <p>
 * <b>Output:</b> 3
 * </p>
 * 
 * <b>Example 3:</b>
 * 
 * <p>
 * <b>Input:</b> N = 3, trust = [[1,3],[2,3],[3,1]]
 * </p>
 * <p>
 * <b>Output:</b> -1
 * </p>
 * 
 * <b>Example 4:</b>
 * 
 * <p>
 * <b>Input:</b> N = 3, trust = [[1,2],[2,3]]
 * </p>
 * <p>
 * <b>Output:</b> -1
 * </p>
 * <b>Example 5:</b>
 * 
 * <p>
 * <b>Input:</b> N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * </p>
 * <p>
 * <b>Output:</b> 3
 * </p>
 * 
 * 
 * <b>Note:</b>
 * 
 * <li>1 <= N <= 1000</li>
 * <li>trust.length <= 10000</li>
 * <li>trust[i] are all different</li>
 * <li>trust[i][0] != trust[i][1]</li>
 * <li>1 <= trust[i][0], trust[i][1] <= N</li>
 * 
 * @author Shrey
 *
 */
public class FindTheTownJudge {

	public static void main(String[] args) {
		System.out.println(findJudge(2, new int[][] { { 1, 2 } }));// 2
		System.out.println(findJudge(3, new int[][] { { 1, 3 }, { 2, 3 } }));// 3
		System.out.println(findJudge(3, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } }));// -1
		System.out.println(findJudge(3, new int[][] { { 1, 2 }, { 2, 3 } }));// -1
		System.out.println(findJudge(4, new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } }));// 3
	}

	public static int findJudge(int n, int[][] trust) {

		int[] trusted = new int[n + 1];

		for (int[] person : trust) {
			trusted[person[0]]--;
			trusted[person[1]]++;
		}

		for (int i = 1; i < trusted.length; i++) {
			if (trusted[i] == n - 1)
				return i;
		}

		return -1;
	}

}
