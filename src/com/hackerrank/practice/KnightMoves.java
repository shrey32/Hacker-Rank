package com.hackerrank.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/G11_2/">G11_2 - KNIGHT MOVES</a>
 * 
 * @author Shrey
 *
 */
public class KnightMoves {

	private static final boolean[][] visited = { { false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false } };
	private static final String rows = "abcdefgh";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		System.out.println(bfs(a, b));
		scan.close();
	}

	private final static int bfs(String a, String b) {
		int istart = rows.indexOf(a.split("")[0] + "");
		int jstart = Integer.parseInt(a.split("")[1]) - 1;
		int iend = rows.indexOf(b.split("")[0] + "");
		int jend = Integer.parseInt(b.split("")[1]) - 1;

		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(istart, jstart, 0));
		visited[istart][jstart] = true;
		while (!queue.isEmpty()) {

			Pair temp = queue.poll();

			if (temp.i == iend && temp.j == jend)
				return temp.dist;
			else if (temp.i == iend && Math.abs(jend - temp.j) < 3)
				return temp.dist + Math.abs(jend - temp.j);
			else if (temp.j == jend && Math.abs(iend - temp.i) < 3)
				return temp.dist + Math.abs(iend - temp.i);

			if (temp.j + 2 < 8 && temp.i - 1 >= 0 && !visited[temp.i - 1][temp.j + 2]) {// left up -> ^
				queue.add(new Pair(temp.i - 1, temp.j + 2, temp.dist + 1));
				visited[temp.i - 1][temp.j + 2] = true;
			}

			if (temp.i - 2 >= 0 && temp.j + 1 < 8 && !visited[temp.i - 2][temp.j + 1]) {// up left ^ ->
				queue.add(new Pair(temp.i - 2, temp.j + 1, temp.dist + 1));
				visited[temp.i - 2][temp.j + 1] = true;
			}

			if (temp.j - 2 >= 0 && temp.i - 1 >= 0 && !visited[temp.i - 1][temp.j - 2]) {// back up <- ^
				queue.add(new Pair(temp.i - 1, temp.j - 2, temp.dist + 1));
				visited[temp.i - 1][temp.j - 2] = true;
			}

			if (temp.i - 2 >= 0 && temp.j - 1 >= 0 && !visited[temp.i - 2][temp.j - 1]) {// up back ^ <-
				queue.add(new Pair(temp.i - 2, temp.j - 1, temp.dist + 1));
				visited[temp.i - 2][temp.j - 1] = true;
			}

			if (temp.j + 2 < 8 && temp.i + 1 < 8 && !visited[temp.i + 1][temp.j + 2]) {// right down -> v
				queue.add(new Pair(temp.i + 1, temp.j + 2, temp.dist + 1));
				visited[temp.i + 1][temp.j + 2] = true;
			}

			if (temp.i + 2 < 8 && temp.j + 1 < 8 && !visited[temp.i + 2][temp.j + 1]) {// down right v ->
				queue.add(new Pair(temp.i + 2, temp.j + 1, temp.dist + 1));
				visited[temp.i + 2][temp.j + 1] = true;
			}

			if (temp.j - 2 >= 0 && temp.i + 1 < 8 && !visited[temp.i + 1][temp.j - 2]) {// left down <- v
				queue.add(new Pair(temp.i + 1, temp.j - 2, temp.dist + 1));
				visited[temp.i + 1][temp.j - 2] = true;
			}

			if (temp.i + 2 < 8 && temp.j + 1 < 8 && !visited[temp.i + 2][temp.j + 1]) {// down left v <-
				queue.add(new Pair(temp.i + 2, temp.j + 1, temp.dist + 1));
				visited[temp.i + 2][temp.j + 1] = true;
			}

		}
		return -1;

	}

	private static final int bfs(String a, String b, boolean[][] visited) {
		int istart = rows.indexOf(a.split("")[0] + "");
		int jstart = Integer.parseInt(a.split("")[1]) - 1;
		int iend = rows.indexOf(b.split("")[0] + "");
		int jend = Integer.parseInt(b.split("")[1]) - 1;

		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(istart, jstart, 0));
		visited[istart][jstart] = true;
		return bfs(iend, jend, queue, visited);
	}

	private final static int bfs(int iend, int jend, Queue<Pair> queue, boolean[][] visited) {
		if (queue.isEmpty())
			return -1;
		Pair temp = queue.poll();
		if (temp.i == iend && temp.j == jend)
			return temp.dist;
		if (temp.j + 1 < 8 && !visited[temp.i][temp.j + 1]) {// right
			queue.add(new Pair(temp.i, temp.j + 1, temp.dist + 1));
			visited[temp.i][temp.j + 1] = true;
		}

		if (temp.j - 1 >= 0 && !visited[temp.i][temp.j - 1]) {// left
			queue.add(new Pair(temp.i, temp.j - 1, temp.dist + 1));
			visited[temp.i][temp.j - 1] = true;
		}

		if (temp.i - 1 >= 0 && !visited[temp.i - 1][temp.j]) {// up
			queue.add(new Pair(temp.i - 1, temp.j, temp.dist + 1));
			visited[temp.i - 1][temp.j] = true;
		}

		if (temp.i + 1 < 8 && !visited[temp.i + 1][temp.j]) {// down
			queue.add(new Pair(temp.i + 1, temp.j, temp.dist + 1));
			visited[temp.i + 1][temp.j] = true;
		}

		return bfs(iend, jend, queue, visited);
	}

	static class Pair {
		int i, j, dist;

		public Pair(int i, int j, int dist) {
			this.i = i;
			this.j = j;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "(" + i + "," + j + "," + dist + ")";
		}
	}

}
