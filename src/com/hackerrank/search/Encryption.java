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
		String S = scan.next();
		scan.close();
		int length = S.length();
		int row = (int) Math.floor(Math.sqrt(1.0 * length));
		int col = (int) Math.ceil(Math.sqrt(1.0 * length));
		int r = 0;
		int c = 0;

		if (row < col) {
			int num = col - row;
			row = row + num;
			r = row;
			c = col;
		} else {
			r = row;
			c = col;
		}
		String[] s = new String[length];
		for (int k = 0; k < s.length; k++) {
			Character ch = S.charAt(k);
			s[k] = ch.toString();
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (j * c + i < length) {
					System.out.print(s[j * c + i]);
				}
			}
			System.out.print(" ");
		}
	}
}