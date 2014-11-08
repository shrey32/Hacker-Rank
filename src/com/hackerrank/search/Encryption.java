package com.hackerrank.search;

import java.util.Scanner;

/**One classic method for composing secret messages is called a square code.  The spaces are removed from the english text and the characters are written into a square (or rectangle). The width and height of the rectangle have the constraint,

 floor(sqrt( len(word) )) <= width, height <= ceil(sqrt( len(word) ))

 Among the possible squares, choose the one with the minimum area.

 In case of a rectangle, the number of rows will always be smaller than the number of columns. For example, the sentence "if man was meant to stay on the ground god would have given us roots" is 54 characters long, so it is written in the form of a rectangle with 7 rows and 8 columns. Many more rectangles can accomodate these characters; choose the one with minimum area such that: length * width >= len(word)

 ifmanwas 
 meanttos         
 tayonthe 
 groundgo 
 dwouldha 
 vegivenu 
 sroots

 The coded message is obtained by reading the characters in a column, inserting a space, and then moving on to the next column towards the right. For example, the message above is coded as:

 imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau

 You will be given a message in English with no spaces between the words.The maximum message length can be 81 characters. Print the encoded message.

 Here are some more examples:

 Sample Input:

 haveaniceday

 Sample Output:

 hae and via ecy

 Sample Input:

 feedthedog    

 Sample Output:

 fto ehg ee dd

 Sample Input:

 chillout

 Sample Output:

 clu hlt io*/

/**
 * @author Shrey
 *
 */
public class Encryption {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int width = (int) Math.sqrt(1.0 * s.length());
		int height = (int) Math.ceil(Math.sqrt(s.length()));

		String[] sar = new String[s.length()];

		for (int i = 0; i < sar.length; i++) {
			Character c = new Character(s.charAt(i));
			sar[i] = c.toString();
		}

		int r = 0, c = 0;
		for (int i = width; i <= height; i++) {
			for (int j = i + 1; j <= height; j++) {
				if (i * j == s.length()) {
					r = i;
					c = j;
					break;
				} else if (i * j >= s.length()) {
					r = i;
					c = j;
				}
			}
		}
		int l = 0, i = 0;
		int m = c;
		String[] sr = new String[r];

		while (i < sr.length) {
			if (m <= s.length()) {
				String sb = getSt(sar, l, m);
				sr[i] = sb;
				i++;
				l += c;
				m += c;
			}
		}

		for (int p = 0; p <= sr.length; p++) {
			String sl = "";
			String s1 = sr[p];
			if (p < sr.length) {
				for (int q = 0; q <= s1.length(); q++) {
					
					sl += s1.charAt(p);
				}
				System.out.print(sl + " ");
			}
		}

		scan.close();
	}

	public static String getSt(String[] sar, int a, int b) {
		String s = "";
		for (int i = a; i < b; i++) {
			s += sar[i];
		}
		return s;
	}
}
