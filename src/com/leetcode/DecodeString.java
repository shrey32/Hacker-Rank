package com.leetcode;

import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));// aaabcbc
		System.out.println(decodeString("3[a2[c]]"));// accaccacc
		System.out.println(decodeString("2[abc]3[cd]ef"));// abcabccdcdcdef
		System.out.println(decodeString("100[leetcode]"));
	}

	public static String decodeString(String s) {
		if (s == null)
			return null;
		Stack<String> stack = new Stack<>();
		int len = s.length();
		for (int i = len - 1; i >= 0; i--) {
			StringBuilder curr = new StringBuilder(s.charAt(i) + "");
			while (isNumeric(curr.toString()) && i - 1 >= 0 && isNumeric(s.charAt(i - 1) + "")) {
				String next = s.charAt(i - 1) + "";
				curr.insert(0, next);
				i--;
			}

			if (isNumeric(curr.toString())) {
				StringBuilder reserved = new StringBuilder();
				while (!stack.isEmpty()) {
					String c = stack.pop();
					if ("[".equals(c))
						continue;
					if ("]".equals(c) && !"".equals(reserved.toString())) {
						int limit = Integer.parseInt(curr.toString());
						String prepend = reserved.toString();
						reserved = new StringBuilder();
						for (int j = 0; j < limit; j++)
							reserved.append(prepend);
						stack.push(reserved.toString());
						break;
					}
					reserved.append(c + "");
				}
			} else {
				stack.push(curr + "");
			}

		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		return sb.toString();
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null)
			return false;
		try {
			Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
