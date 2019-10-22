package com.hackerrank.datastructures.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a grid with both sides equal to . Rows and columns are numbered from  to . There is a castle on the intersection of the th row and the th column.

 Your task is to calculate the minimum number of steps it would take to move the castle from its initial position to the goal position ().

 It is guaranteed that it is possible to reach the goal position from the initial position.

 Note: You can move the castle from cell  to any  in a single step if there is a straight line between and  that does not contain any forbidden cell. Here, "X" denotes a forbidden cell.

 Input Format

 The first line contains an integer , the size of the grid.

 The following  lines contains a string of length  that consists of one of the following characters: "X" or ".". Here, "X" denotes a forbidden cell, and "." denotes an allowed cell.

 The last line contains , , denoting the initial position of the castle, and , , denoting the goal position. Here,  and  are space separated.

 Constraints




 Output Format

 Output a single line: The integer denoting the minimum number of steps required to move the castle to the goal position.

 Sample Input

 3
 .X.
 .X.
 ...
 0 0 0 2
 Sample Output

 3
 Explanation

 Here is a path that one could follow in order to reach the destination in  steps:

 .
 */
/**
 * 
 * @author Shrey
 *
 */
public class CastleOnTheGrid {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String[] grid = new String[n];
		for (int i = 0; i < n; i++) {
			grid[i] = br.readLine().trim();
		}
		String[] params = br.readLine().trim().split(" ");
		int a = Integer.parseInt(params[0]);
		int b = Integer.parseInt(params[1]);
		int c = Integer.parseInt(params[2]);
		int d = Integer.parseInt(params[3]);
		int count = 0;
		boolean pathFound = false;
		while (!pathFound) {
			int ind = grid[a].indexOf('X');
			if (ind > -1) {
              a++;
              continue;
			}
			count++;
			

		}
		System.out.println(count);
		br.close();
	}
}
