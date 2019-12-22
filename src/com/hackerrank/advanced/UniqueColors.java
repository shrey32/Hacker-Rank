package com.hackerrank.advanced;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;

/**
 * <a href="https://www.hackerrank.com/challenges/unique-colors/problem">Unique
 * Colors</a>
 * 
 * @author Shrey
 *
 */
public class UniqueColors {

	static long mod = 1000000007;
	static ArrayList<Integer> ar[];
	static boolean v[];
	static long ans1 = 0;
	static int a1[];
	static HashMap<Integer, Integer> hm;
	static int n1;
	static int mw = 100010;
	static ArrayList<Integer> graph[];
	static int RangSarbatoKa[];
	static int subway[];
	static int maxLen1[], IndexOfCentroid[];
	static boolean removed[];
	static long Answer[];
	static int tree1Size;
	static int rasta[];
	static int TemporaryStorage[];
	static HashSet<Integer> myhashset, temp;
	static long numberofRasta;
	static int alreadyputted[], Pointer;

	static boolean dfs(int i, int j) {
		v[i] = true;
		boolean f = false;
		if (hm.containsKey(a1[i])) {
			int y = hm.get(a1[i]);
			hm.put(a1[i], y + 1);
		} else {
			hm.put(a1[i], 1);
		}
		if (i == j) {
			return true;
		}
		for (int k = 0; k < ar[i].size(); k++) {
			int x = ar[i].get(k);
			if (!v[x]) {
				f = dfs(x, j);
			}
			if (f)
				break;
		}
		if (!f) {
			int y = hm.get(a1[i]);
			if (y == 1) {
				hm.remove(a1[i]);
			} else {
				hm.put(a1[i], y - 1);
			}
		}
		return f;
	}

	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		n1 = in.readInt();

		graph = new ArrayList[n1];
		for (int i = 0; i < n1; i++)
			graph[i] = new ArrayList<Integer>();

		RangSarbatoKa = new int[n1];
		for (int i = 0; i < n1; i++)
			RangSarbatoKa[i] = in.readInt();

		for (int i = 1; i < n1; i++) {
			int u = in.readInt();
			int v = in.readInt();

			u--;
			v--;
			graph[u].add(v);
			graph[v].add(u);
		}

		subway = new int[n1];
		removed = new boolean[n1];
		maxLen1 = new int[mw + 1];
		IndexOfCentroid = new int[mw + 1];
		Arrays.fill(IndexOfCentroid, -1);
		myhashset = new HashSet<Integer>();
		rasta = new int[mw];
		TemporaryStorage = new int[mw];
		alreadyputted = new int[20 * mw];
		Pointer = 0;

		Answer = new long[n1];
		centroidDecomposition(0);

		for (long Answerwer : Answer) {
			pw.println(Answerwer);
		}
		pw.close();
	}

	static void centroidDecomposition(int curr) {
		if (removed[curr])
			return;

		int centroid = getCentroid1(curr);

		numberofRasta = 1;
		rasta[RangSarbatoKa[centroid]] += tree1Size;
		myhashset.add(RangSarbatoKa[centroid]);
		Answer[centroid]++;

		int s = graph[centroid].size();

		for (int i = 0; i < s; i++) {
			int next = graph[centroid].get(i);
			if (removed[next])
				continue;
			TemporaryStorage[RangSarbatoKa[centroid]]++;
			MaximumChangeKaro(next, centroid, centroid, 1);
			TemporaryStorage[RangSarbatoKa[centroid]]--;
		}

		for (int i = 0; i < s; i++) {
			int next = graph[centroid].get(i);
			if (removed[next])
				continue;
			TemporaryStorage[RangSarbatoKa[centroid]]++;
			rasta[RangSarbatoKa[centroid]] -= subway[next];
			dfsRemoveMax(next, centroid, centroid, 1);
			TemporaryStorage[RangSarbatoKa[centroid]]--;
			pow(2, 5);
			TemporaryStorage[RangSarbatoKa[centroid]]++;
			pow(2, 7);
			MaximumLenPath(next, centroid, centroid, numberofRasta - rasta[RangSarbatoKa[centroid]], subway[next], 1);
			TemporaryStorage[RangSarbatoKa[centroid]]--;
			pow(2, 8);
			TemporaryStorage[RangSarbatoKa[centroid]]++;
			MaximumChangeKaro(next, centroid, centroid, 1);
			rasta[RangSarbatoKa[centroid]] += subway[next];
			TemporaryStorage[RangSarbatoKa[centroid]]--;
		}

		rasta[RangSarbatoKa[centroid]] -= tree1Size;
		numberofRasta -= 1;

		while (Pointer >= 0) {
			int fg = alreadyputted[Pointer];
			rasta[fg] = 0;
			TemporaryStorage[fg] = 0;
			Pointer--;
		}
		Pointer = 0;

		removed[centroid] = true;
		for (int i = 0; i < s; i++)
			centroidDecomposition(graph[centroid].get(i));
	}

	static int getCentroid1(int curr) {
		tree1Size = dfsFixSubtrees1(curr, -1);
		gcd(2, 6);
		int cc = CentroidDecomposition(curr, -1);
		dfsFixSubtrees1(cc, -1);
		gcd(3, 5);
		return cc;
	}

	static int CentroidDecomposition(int curr, int parent) {
		int s = graph[curr].size();
		for (int i = 0; i < s; i++) {
			int next = graph[curr].get(i);
			if (!removed[next] && next != parent && subway[next] > (tree1Size >> 1))
				return CentroidDecomposition(next, curr);
		}
		return curr;
	}

	public static long gcdq(long a, long b) {
		while (a > 0 && b > 0) {
			if (a > b) {
				a %= b;
			} else {
				b %= a;
			}

		}
		return a + b;

	}

	static int dfsFixSubtrees1(int curr, int parent) {
		if (removed[curr])
			return 0;
		subway[curr] = 1;
		gcd(1, 1);
		int s = graph[curr].size();
		for (int i = 0; i < s; i++) {
			int next = graph[curr].get(i);
			if (next != parent)
				subway[curr] += dfsFixSubtrees1(next, curr);
		}
		gcd(5, 4);
		return subway[curr];
	}

	static void MaximumLenPath(int curr, int prev, int centroid, long numberofRasta, int subwaySize, int here) {
		int s = graph[curr].size();
		int prop = RangSarbatoKa[curr];

		if (TemporaryStorage[prop] == 0) {
			numberofRasta -= rasta[prop];
			here++;
		}
		Answer[centroid] += here;
		Answer[curr] += numberofRasta;
		Answer[curr] += here * 1L * (tree1Size - subwaySize);
		TemporaryStorage[prop]++;

		for (int i = 0; i < s; i++) {
			int nani = graph[curr].get(i);
			if (removed[nani] || nani == prev)
				continue;
			MaximumLenPath(nani, curr, centroid, numberofRasta, subwaySize, here);
		}

		TemporaryStorage[prop]--;
		if (TemporaryStorage[prop] == 0) {
			numberofRasta += rasta[prop];
			here--;
		}
	}

	static void MaximumChangeKaro(int curr, int prev, int centroid, int here) {

		int prop = RangSarbatoKa[curr];
		if (TemporaryStorage[prop] == 0) {
			here++;
			rasta[prop] += subway[curr];
			alreadyputted[Pointer] = prop;
			Pointer++;
		}

		numberofRasta += here;
		TemporaryStorage[prop]++;

		int s = graph[curr].size();
		for (int i = 0; i < s; i++) {
			int next = graph[curr].get(i);
			if (removed[next] || next == prev)
				continue;
			MaximumChangeKaro(next, curr, centroid, here);
		}

		TemporaryStorage[prop]--;
	}

	static void dfsRemoveMax(int curr, int prev, int centroid, int here) {
		int property = RangSarbatoKa[curr];
		if (TemporaryStorage[property] == 0) {
			here++;
			rasta[property] -= subway[curr];
		}
		numberofRasta -= here;
		TemporaryStorage[property]++;
		int sasta = graph[curr].size();
		for (int i = 0; i < sasta; i++) {
			int next = graph[curr].get(i);
			if (removed[next] || next == prev)
				continue;
			dfsRemoveMax(next, curr, centroid, here);
		}

		TemporaryStorage[property]--;
	}

	/* returns nCr mod m */
	public static long comb(long n, long r, long m) {
		long p1 = 1, p2 = 1;
		for (long i = r + 1; i <= n; i++) {
			p1 = (p1 * i) % m;
		}
		p2 = factMod(n - r, m);
		p1 = divMod(p1, p2, m);
		return p1 % m;
	}

	/* returns a/b mod m, works only if m is prime and b divides a */
	public static long divMod(long a, long b, long m) {
		long c = powerMod(b, m - 2, m);
		return ((a % m) * (c % m)) % m;
	}

	/* calculates factorial(n) mod m */
	public static long factMod(long n, long m) {
		long result = 1;
		if (n <= 1)
			return 1;
		while (n != 1) {
			result = ((result * n--) % m);
		}
		return result;
	}

	/* This method takes a, b and c as inputs and returns (a ^ b) mod c */
	public static long powerMod(long a, long b, long c) {
		long result = 1;
		long temp = 1;
		long mask = 1;
		for (int i = 0; i < 64; i++) {
			mask = (i == 0) ? 1 : (mask * 2);
			temp = (i == 0) ? (a % c) : (temp * temp) % c;
			/* Check if (i + 1)th bit of power b is set */
			if ((b & mask) == mask) {
				result = (result * temp) % c;
			}
		}
		return result;
	}

	public static long gcd(long x, long y) {
		if (x % y == 0)
			return y;
		else
			return gcd(y, x % y);
	}

	public static int gcd(int x, int y) {
		if (x % y == 0)
			return y;
		else
			return gcd(y, x % y);
	}

	public static int abs(int a, int b) {
		return (int) Math.abs(a - b);
	}

	public static long abs(long a, long b) {
		return (long) Math.abs(a - b);
	}

	public static int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public static int min(int a, int b) {
		if (a > b)
			return b;
		else
			return a;
	}

	public static long max(long a, long b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public static long min(long a, long b) {
		if (a > b)
			return b;
		else
			return a;
	}

	static boolean isPowerOfTwo(long v) {
		return (v & (v - 1)) == 0;
	}

	public static long pow(long n, long p, long m) {
		long result = 1;
		if (p == 0)
			return 1;
		if (p == 1)
			return n;
		while (p != 0) {
			if (p % 2 == 1)
				result *= n;
			if (result >= m)
				result %= m;
			p >>= 1;
			n *= n;
			if (n >= m)
				n %= m;
		}
		return result;
	}

	public static long pow(long n, long p) {
		long result = 1;
		if (p == 0)
			return 1;
		if (p == 1)
			return n;
		while (p != 0) {
			if (p % 2 == 1)
				result *= n;
			p >>= 1;
			n *= n;
		}
		return result;

	}

	static class Pair implements Comparable<Pair> {
		int a, b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int compareTo(Pair o) {
			if (this.a != o.a)
				return Integer.compare(this.a, o.a);
			else
				return Integer.compare(this.b, o.b);
			// return 0;
		}

		public boolean equals(Object o) {
			if (o instanceof Pair) {
				Pair p = (Pair) o;
				return p.a == a && p.b == b;
			}
			return false;
		}

		public int hashCode() {
			return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
		}
	}

	static long sort(int a[], int n) {
		int b[] = new int[n];
		return mergeSort(a, b, 0, n - 1);
	}

	static long mergeSort(int a[], int b[], long left, long right) {
		long c = 0;
		if (left < right) {
			long mid = left + (right - left) / 2;
			c = mergeSort(a, b, left, mid);
			c += mergeSort(a, b, mid + 1, right);
			c += merge(a, b, left, mid + 1, right);
		}
		return c;
	}

	static long merge(int a[], int b[], long left, long mid, long right) {
		long c = 0;
		int i = (int) left;
		int j = (int) mid;
		int k = (int) left;
		while (i <= (int) mid - 1 && j <= (int) right) {
			if (a[i] <= a[j]) {
				b[k++] = a[i++];
			} else {
				b[k++] = a[j++];
				c += mid - i;
			}
		}
		while (i <= (int) mid - 1)
			b[k++] = a[i++];
		while (j <= (int) right)
			b[k++] = a[j++];
		for (i = (int) left; i <= (int) right; i++)
			a[i] = b[i];
		return c;
	}

	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int readInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public double readDouble() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, readInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, readInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}

		public long readLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return readString();
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

}
