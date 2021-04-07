package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class StringCompression {

	public static void main(String[] args) {
		System.out.println(compress(new char[] { 'a', 'a', 'b', 'b', 'c' }));
	}

	public static int compress(char[] chars) {
		if (chars == null || 0 == chars.length)
			return 0;
		int tempCount = 1;
		int j = 1;
		for (int i = 1; i < chars.length; i++) {
			char curr = chars[i];
			if (curr == chars[i - 1])
				tempCount++;
			else {
				j = update(chars, j, tempCount);
				tempCount = 1;
				chars[j++] = curr;
			}
		}
		return update(chars, j, tempCount);
	}

	public static int update(char[] chars, int index, int count) {
		if (count <= 1)
			return index;
		char[] tempAr = Integer.toString(count).toCharArray();
		for (int i = 0; i < tempAr.length; i++) {
			chars[index++] = tempAr[i];
		}
		return index;
	}

}
