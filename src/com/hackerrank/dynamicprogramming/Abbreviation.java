package com.hackerrank.dynamicprogramming;

public class Abbreviation {

	public static void main(String[] args) {
		System.out.println(abbreviation("AbCdE", "AFE"));//NO
		System.out.println(abbreviation("beFgH", "EFG"));// NO
		System.out.println(abbreviation("beFgH", "EFH"));//YES
		System.out.println(abbreviation("aBbdD", "BBD"));// YES
		System.out.println(abbreviation("BBBbb", "BB"));// YES
		System.out.println(abbreviation("LLZOSYAMQRMBTZXTQMQcKGLR",
				"LLZOSYAMBTZXMQKLR"));// NO
		System.out.println(abbreviation("SRTRING", "STRING"));// YES
	}

	static String abbreviation(String a, String b) {
		int lena = a.length();
		int lenb = b.length();

		if (lena < lenb) {
			int temp = lenb;
			lenb = lena;
			lena = temp;
			String tempStr = b;
			b = a;
			a = tempStr;
		}

		int j = lenb - 1;
		int i = lena - 1;
		if(Character.toUpperCase(a.charAt(i)) != Character.toUpperCase(b.charAt(j)))
		   return "NO";
		
		for (; i >= 0; i--) {
			char first = a.charAt(i);
			if (j >= 0) {
				char second = b.charAt(j);
				if (first == second) {
					j--;
				} else if (Character.toUpperCase(second) == Character
						.toUpperCase(first)) {
					j--;
				}
			} 
		}
		return j >= 0 ? "NO" : "YES";
	}

}
