package com.leetcode;

import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class CountBinarySubstrings {

	public static void main(String[] args) {
		System.out.println(countBinarySubstrings("00110011"));
	}

	public int countBinarySubstringsOptimalSpace(String s) {
		int prev = 0, curr = 1, ans = 0;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				ans += Math.min(curr, prev);
				prev = curr;
				curr = 1;
			} else {
				curr++;
			}
		}

		return ans + Math.min(curr, prev);
	}

	public static int countBinarySubstrings(String s) {
		int len = s.length();
		Stack<int[]> st = new Stack<>();
		int count = 0;
		for (int i = 0; i < len; i++) {
			int curr = s.charAt(i);
			if (st.isEmpty()) {
				st.push(new int[] { curr, 1 });
				continue;
			}
			if (!st.isEmpty() && st.peek()[0] == curr) {
				st.peek()[1]++;
			} else {
				st.push(new int[] { curr, 1 });
			}
		}
		int[] prev = null;
		while (!st.isEmpty()) {
			int[] curr = st.pop();
			if (prev == null) {
				prev = curr;
				continue;
			}
			count += Math.min(prev[1], curr[1]);
			prev = curr;
		}
		return count;
	}

}
