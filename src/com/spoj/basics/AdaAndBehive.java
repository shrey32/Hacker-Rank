package com.spoj.basics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/ADABEHIVE/">ADABEHIVE - Ada and
 * Behives</a>
 * 
 * @author Shrey
 *
 */
public class AdaAndBehive {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int q = scan.nextInt();
		int[][] mesh = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				mesh[i][j] = scan.nextInt();
			}
		}
		Map<Pair, BigDecimal> calculated = new HashMap<>();
		List<Position> positions = new LinkedList<>();
		for (int i = 0; i < q; i++) {
			int kind = scan.nextInt();
			if (kind == 1) {
				int iPos = scan.nextInt();
				int jPos = scan.nextInt();
				int newBornBees = scan.nextInt();
				mesh[iPos][jPos] += newBornBees;
				positions.add(new Position(iPos, jPos, newBornBees));
			} else {
				Pair pair = new Pair(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
				BigDecimal bees = BigDecimal.ZERO;
				if (!calculated.containsKey(pair)) {
					bees = calculate(pair, mesh);
					calculated.put(pair, bees);
				} else {
					bees = calculated.get(pair);
					bees = bees.add(newBornBeesCount(pair, positions));
				}
				System.out.println(bees);
			}
		}
		scan.close();
	}

	private static BigDecimal newBornBeesCount(Pair p, List<Position> positions) {
		BigDecimal count = BigDecimal.ZERO;
		for (Position pos : positions) {
			if (p.iStart <= pos.i && pos.j >= p.jStart && p.iEnd >= pos.i && pos.j <= p.jEnd)
				count = count.add(BigDecimal.valueOf(pos.newBorns));
		}
		return count;
	}

	private static final BigDecimal calculate(Pair p, int[][] mesh) {
		BigDecimal sum = BigDecimal.ZERO;
		for (int i = p.iStart; i <= p.iEnd; i++) {
			for (int j = p.jStart; j <= p.jEnd; j++) {
				sum = sum.add(BigDecimal.valueOf(mesh[i][j]));
			}
		}
		return sum;
	}

	private final static class Position {
		public final int i, j, newBorns;

		public Position(int i, int j, int newBorns) {
			this.i = i;
			this.j = j;
			this.newBorns = newBorns;
		}

		@Override
		public String toString() {
			return "Position [" + i + ", " + j + "]";
		}

	}

	private final static class Pair {
		public final int iStart, jStart, iEnd, jEnd;

		public Pair(int iStart, int jStart, int iEnd, int jEnd) {
			this.iStart = iStart;
			this.jStart = jStart;
			this.iEnd = iEnd;
			this.jEnd = jEnd;
		}

		@Override
		public String toString() {
			return "Pair [(" + iStart + "," + jStart + "), (" + iEnd + "," + jEnd + ")]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + iStart;
			result = prime * result + jStart;
			result = prime * result + iEnd;
			result = prime * result + jEnd;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			Pair other = (Pair) obj;
			if (iStart == other.iStart && jStart == other.jStart && iEnd == other.iEnd && jEnd == other.jEnd)
				return true;
			return false;
		}

	}
}
