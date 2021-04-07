package com.hackerrank.crackingcodinginterview;

/**
 * 
 * <p>
 * String Compression: Implement a method to perform basic string compression
 * using the counts of repeated characters. For example, the string aabcccccaaa
 * would become a2blc5a3. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string. You
 * can assume the string has only uppercase and lowercase letters (a - z).
 * </p>
 * 
 * @author Shrey
 *
 */
public class StringCompression {

	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));// a2blc5a3
	}

	public static String compress(String s) {
		if (s == null || "".equals(s))
			return "";
		char[] chars = s.toCharArray();
		int len = chars.length;
		StringBuilder sb = new StringBuilder();
		int tempCount = 1;
		sb.append(s.charAt(0) + "");
		for (int i = 1; i < len; i++) {
			char curr = s.charAt(i);
			if (curr == s.charAt(i - 1))
				tempCount++;
			else {
				sb.append(tempCount);
				tempCount = 1;
				sb.append(curr + "");
			}
		}
		sb.append(tempCount);
		System.out.println(sb.toString());
		return sb.length() > s.length() ? s : sb.toString();
	}

}
