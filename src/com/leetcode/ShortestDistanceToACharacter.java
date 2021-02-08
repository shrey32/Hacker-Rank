package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class ShortestDistanceToACharacter {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(shortestToChar("loveleetcode",'e')));
		System.out.println(Arrays.toString(shortestToChar("aaab",'b')));
	}

	public static int[] shortestToChar(String s, char c) {
		int len = s.length();

		List<Integer> pos = new ArrayList<>(len / 2);

		//collect all the positions of given character
		for (int i = 0; i < len; i++) {
			char curr = s.charAt(i);
			if (curr == c)
				pos.add(i);
		}

		int[] arr = new int[len];
		int currIndex = 0;
		int prevIndex = -1;
		for (int i = 0; i < len; i++) {
			char curr = s.charAt(i);
			if (curr == c) {
				arr[i] = 0;
			} else {
				if (currIndex >= pos.size())
					currIndex = prevIndex;
				int currPos = pos.get(currIndex);
				if (prevIndex >= 0)
					arr[i] = Math.min(Math.abs(currPos - i), Math.abs(pos.get(prevIndex) - i));
				else
					arr[i] = Math.abs(currPos - i);
			}

			if (i > pos.get(currIndex)) {
				prevIndex = currIndex;
				currIndex++;
			}
		}
		return arr;
	}

}
