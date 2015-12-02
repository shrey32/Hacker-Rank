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

	private static int ENDI = 0;
	private static int ENDJ = 0;
	private static int STARTI = 0;
	private static int STARTJ = 0;

	public static class Node {
		public int r, c = 0;
		public Node pre = null;

		public Node(int i, int j) {
			this.r = i;
			this.c = j;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			String line = br.readLine();
			int row = Integer.parseInt(line.trim().split(" ")[0]);
			int col = Integer.parseInt(line.trim().split(" ")[1]);
			char[][] forest = new char[row][col];
			for (int i = 0; i < row; i++) {
				String l = br.readLine().trim();
				forest[i] = l.toCharArray();
				if (l.indexOf("M") >= 0) {
					STARTI = i;
					STARTJ = l.indexOf("M");
				}
				if (l.indexOf("*") >= 0) {
					ENDI = i;
					ENDJ = l.indexOf("*");
				}
			}
			int count = Integer.parseInt(br.readLine().trim());
			boolean[][] seen = new boolean[row][col];
			Node tail = new Node(ENDI, ENDJ);
			Node head = null;
			visit(forest, STARTI, STARTJ, seen, head, tail);
			int counter = 0;
			Node n = tail.pre;
			while (n != null) {
				// System.out.println(n.r + "-" + n.c);
				int option = 0;
				if (n.r - 1 >= 0 && n.r - 1 < row
						&& forest[n.r - 1][n.c] == '.')
					option++;
				if (n.r + 1 >= 0 && n.r + 1 < row
						&& forest[n.r + 1][n.c] == '.')
					option++;
				if (n.c - 1 >= 0 && n.c - 1 < col
						&& forest[n.r][n.c - 1] == '.')
					option++;
				if (n.c + 1 >= 0 && n.c + 1 < col
						&& forest[n.r][n.c + 1] == '.')
					option++;
				if (option > 2
						|| (n == tail.pre && option > 1)
						|| (n.r == STARTI && n.c == STARTJ && option > 1)
						|| (n.pre != null && n.pre.r == STARTI
								&& n.pre.c == STARTJ && option > 1))
					counter++;
				n = n.pre;
			}
			System.out.println(counter == count ? "Impressed" : "Oops!");
			T--;
		}
		br.close();
	}

	public static void visit(char[][] maze, int starti, int startj,
			boolean[][] seen, Node pre, Node tail) {
		if (starti < 0 || startj < 0 || starti >= maze.length
				|| startj >= maze[0].length || seen[starti][startj])
			return;
		if (maze[starti][startj] == 'X')
			return;
		if (maze[starti][startj] == '*') {
			tail.pre = pre;
			return;
		}
		seen[starti][startj] = true;
		Node n = new Node(starti, startj);
		n.pre = pre;
		visit(maze, starti - 1, startj, seen, n, tail);
		visit(maze, starti + 1, startj, seen, n, tail);
		visit(maze, starti, startj - 1, seen, n, tail);
		visit(maze, starti, startj + 1, seen, n, tail);
	}

}
