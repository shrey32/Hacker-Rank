package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**

 * When you select a contiguous block of text in a PDF viewer, the selection is highlighted with a blue rectangle. In a new kind of PDF viewer, the selection of each word is independent of the other words; this means that each rectangular selection area forms independently around each highlighted word. For example:
 * <p>
 * PDF-highighting.png
 * <p>
 * In this type of PDF viewer, the width of the rectangular selection area is equal to the number of letters in the word times the width of a letter, and the height is the maximum height of any letter in the word.
 * <p>
 * Consider a word consisting of lowercase English alphabetic letters, where each letter is  wide. Given the height of each letter in millimeters (), find the total area that will be highlighted by blue rectangle in  when the given word is selected in our new PDF viewer.
 * <p>
 * Input Format
 * <p>
 * The first line contains  space-separated integers describing the respective heights of each consecutive lowercase English letter (i.e., ).
 * The second line contains a single word, consisting of lowercase English alphabetic letters.
 * <p>
 * Constraints
 * <p>
 * , where  is an English lowercase letter.
 * Word contains no more than  letters.
 * Output Format
 * <p>
 * Print a single integer denoting the area of highlighted rectangle when the given word is selected. The unit of measurement for this is square millimeters (), but you must only print the integer.
 * <p>
 * Sample Input
 * <p>
 * 1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
 * abc
 * Sample Output
 * <p>
 * 9
 * Explanation
 * <p>
 * We are highlighting the word abc:
 * <p>
 * The tallest letter in abc is b, and . The selection area for this word is .
 * Note: Recall that the width of each character is .
 */

/**
 * 
 * @author Shrey
 *
 */
public class DesignerPDFViewer {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().trim().split(" ");
		String word = br.readLine().trim();
		br.close();
		String index = "abcdefghijklmnopqrstuvwxyz";
		int length = word.length();
		int height = Integer.MIN_VALUE;
		for (char c : word.toCharArray()) {
			int ind = index.indexOf(c);
			int h = Integer.parseInt(arr[ind]);
			height = Math.max(height, h);
		}
		System.out.println(height * length);
	}
}
