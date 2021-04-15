package com.crackingthecodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class StringRotation {

	public static void main(String[] args) {
		System.out.println(isSubstring("waterbottle", "erbottlewat"));
		System.out.println(isSubstring("brilliant", "brilliard"));
		System.out.println(isSubstring("", ""));
	}

	public static boolean isSubstring(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		return (s1 + s1).indexOf(s2) >= 0;
	}

}
