package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.List;

public class ValidParenthesis {

	public static void main(String[] args) {
		System.out.println(parenthesis(3));
	}

	public static List<String> parenthesis(int n) {
		List<String> list = new ArrayList<>();
		helper(list, new char[n * 2], n, 0, 0, 0, 0);
		return list;
	}

	public static void helper(List<String> list, char[] c, int n, int idx, int usedLeft, int usedRight, int leftBr) {
		if (idx == (n * 2)) {
			list.add(new String(c));
			return;
		}
		if (usedLeft < n) {
			c[idx] = '(';
			helper(list, c, n, idx + 1, usedLeft + 1, usedRight, leftBr + 1);
		}
		if (usedRight < n && leftBr > 0) {
			c[idx] = ')';
			helper(list, c, n, idx + 1, usedLeft, usedRight + 1, leftBr - 1);
		}

	}

}
