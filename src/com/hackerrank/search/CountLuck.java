package com.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 Hermione Granger is lost in the Forbidden Forest while collecting some herbs for her magical potion. The forest is magical and has only 1 exit point which magically transports her back to the Hogwarts School of Wizardy and Witch Craft. 
 Forest can be considered as a grid of NxM size. Each cell in the forest is either empty (represented by '.') or has a tree (represented by 'X'). Hermione can move through empty cell, but not through cells with tree on it. She can only travel LEFT, RIGHT, UP, DOWN. Her position in the forest is indicated by the marker 'M' and the location of the exit point is indicated by '*'. Top-left corner is indexed (0, 0).

 .X.X......X
 .X*.X.XXX.X
 .XX.X.XM...
 ......XXXX.
 In the above forest, Hermione is located at index (2, 7) and exit is at (1, 2). Each cell is indexed according to Matrix Convention

 She starts her commute back to the exit and every time she encounters more than one option to move, she waves her wand and the correct path is illuminated and she proceeds in that way. It is guaranteed that there is only one path to each reachable cell from the starting cell. Can you tell us if she waved her wand exactly K times or not? Ron will be impressed if she is able to do so.

 Input Format 
 First line contains an integer T. T test cases follow. 
 Each test case starts with two space separated integer N and M. 
 Then next N lines contain a string each length of M which represents the forest. 
 Last line of each single test case is integer K.

 Output Format 
 For each test case, if she could impress Ron then print "Impressed" otherwise print "Oops!".

 All quotes used for the clarifications.

 Constraints 
 1 <= T <= 10 
 1<=N, M<=100 
 0 <= K <= 10000 
 There is exactly one 'M' and one '*' in the graph. 
 Exactly one path exists between 'M' and '*.'

 Sample Input

 3
 2 3
 *.M
 .X.
 1
 4 11
 .X.X......X
 .X*.X.XXX.X
 .XX.X.XM...
 ......XXXX.
 3
 4 11
 .X.X......X
 .X*.X.XXX.X
 .XX.X.XM...
 ......XXXX.
 4
 Sample Output

 Impressed
 Impressed
 Oops!
 Explanation

 Case1: Hermione waves her wand at (0,2) hence #Wand waved = K = 1. 
 Case2: Hermione waves her wand at (2,9) (0,5) and (3,3) hence #Wand waved = K = 3. 
 Case3: Same as above case. But here K = 4, which doesn't match times Wand is waved.
 */

/**
 * 
 * @author Shrey
 *
 */
public class CountLuck {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			String line = br.readLine();
			int a = Integer.parseInt(line.split(" ")[0]);
			int b = Integer.parseInt(line.split(" ")[1]);
			String[][] arr = new String[a][b];
			int dumI = 0, dumJ = 0;
			for (int i = 0; i < a; i++) {
				String l = br.readLine();
				for (int j = 0; j < b; j++) {
					String s = l.split(" ")[j];
					arr[i][j] = s;
					if (s.equals("M")) {
						dumI = i;
						dumJ = j;
					}
				}
			}
			int c = Integer.parseInt(br.readLine());
			countLuck(arr, dumI, dumJ, a, b, c);
			T--;
		}

		br.close();
	}

	private static void countLuck(String[][] arr, int dumI, int dumJ, int a,
			int b, int c) {
		int count = 0;
		if (count == c) {
			System.out.println("Impressed");
		} else {
			System.out.println("Oops!");
		}
	}
}
