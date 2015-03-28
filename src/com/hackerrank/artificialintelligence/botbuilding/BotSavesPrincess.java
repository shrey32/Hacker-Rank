package com.hackerrank.artificialintelligence.botbuilding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 Princess Peach is trapped in one of the four corners of a square grid. You are in the center of the grid and can move one step at a time in any of the four directions. Can you rescue the princess?

 Input format

 The first line contains an odd integer N (3 <= N < 100) denoting the size of the grid. This is followed by an NxN grid. Each cell is denoted by '-' (ascii value: 45). The bot position is denoted by 'm' and the princess position is denoted by 'p'.

 Grid is indexed using Matrix Convention

 Output format

 Print out the moves you will take to rescue the princess in one go. The moves must be separated by '\n', a newline. The valid moves are LEFT or RIGHT or UP or DOWN.

 Sample input

 3
 ---
 -m-
 p--
 Sample output

 DOWN
 LEFT
 Task

 Complete the function displayPathtoPrincess which takes in two parameters - the integer N and the character array grid. The grid will be formatted exactly as you see it in the input, so for the sample input the princess is at grid[2][0]. The function shall output moves (LEFT, RIGHT, UP or DOWN) on consecutive lines to rescue/reach the princess. The goal is to reach the princess in as few moves as possible.

 The above sample input is just to help you understand the format. The princess ('p') can be in any one of the four corners.

 Scoring 
 Your score is calculated as follows : (NxN - number of moves made to rescue the princess)/10, where N is the size of the grid (3x3 in the sample testcase).
 */
/**
 * 
 * @author Shrey
 *
 */
public class BotSavesPrincess {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] grid = new char[N][N];
		String[] line = new String[N];
		int m1 = 0, m2 = 0;
		int p1 = 0, p2 = 0;
		for (int i = 0; i < N; i++) {
			line[i] = br.readLine();
		}
		for (int i = 0; i < line.length; i++) {
			for (int j = 0; j < line.length; j++) {
				char c = line[i].charAt(j);
				grid[i][j] = c;
				if (c == 'm') {
					m1 = i;
					m2 = j;
				}
				if (c == 'p') {
					p1 = i;
					p2 = j;
				}
			}
		}
		int diffM = Math.abs(m1 - p1);
		int diffP = Math.abs(m2 - p2);
		if (p1 > m1) {
			// move down
			move(diffM, "DOWN");
		} else {
			// move up
			move(diffM, "UP");
		}
		if (p2 > m1) {
			// move left
			move(diffP, "RIGHT");
		} else {
			// move right
			move(diffP, "LEFT");
		}
	}

	private static void move(int walk, String msg) {
		for (int i = 0; i < walk; i++) {
			System.out.println(msg);
		}
	}

}
