package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(4));
	}

	public static String countAndSay(int n) {
		String output = "1";
		for (int i = 1; i < n; i++) {
			output = process(output);
		}
		return output;
	}

	private static String process(String input) {
		char[] ica = input.toCharArray();
		char lastIc = ica[0];
		int count = 0;
		StringBuilder output = new StringBuilder();
		for (char ic : ica) {
			if (ic == lastIc) {
				count++;
			} else {
				output.append(count).append(lastIc);
				count = 1;
				lastIc = ic;
			}
		}
		output.append(count).append(lastIc);
		return output.toString();
	}

}
