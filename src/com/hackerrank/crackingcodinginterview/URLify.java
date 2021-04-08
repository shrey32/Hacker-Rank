package com.hackerrank.crackingcodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class URLify {

	public static void main(String[] args) {
		System.out.println(urlify("           "));
		System.out.println(urlify("         Mr John Smith  "));
		System.out.println(urlify("Mr John Smith"));
	}

	private static String urlify(String s) {
		if (s == null || s.length() == 0)
			return "";
		int spaceCount = 0;
		s = trim(s);
		for (char c : s.toCharArray())
			if (c == ' ')
				spaceCount += 3;
		int newLen = s.length() + spaceCount;
		char[] chars = new char[newLen + spaceCount];
		for (int i = 0, j = 0; i < s.length(); i++, j++) {
			char curr = s.charAt(i);
			if (curr == ' ') {
				chars[j++] = '%';
				chars[j++] = '2';
				chars[j] = '0';
			} else
				chars[j] = curr;
		}
		return String.valueOf(chars);
	}

	public static String trim(String s) {
		// left trim
		int i = 0;
		int len = s.length();
		while (i < len && s.charAt(i) == ' ') {
			i++;
		}
		s = s.substring(i);
		// right trim
		i = s.length() - 1;
		while (i >= 0 && s.charAt(i) == ' ') {
			i--;
		}
		return s.substring(0, i + 1);
	}

}
