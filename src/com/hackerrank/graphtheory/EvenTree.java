package com.hackerrank.graphtheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 */
/**
 * 
 * @author Shrey
 *
 */
public class EvenTree {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line.split(" ")[0]);
		int M = Integer.parseInt(line.split(" ")[1]);
		int[][] edges = new int[M][2];

		for (int i = 0; i < M; i++) {
			String l = br.readLine();
			int a = Integer.parseInt(l.split(" ")[0]);
			int b = Integer.parseInt(l.split(" ")[1]);
			edges[i][0] = b;
			edges[i][1] = a;
		}
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] int1, int[] int2) {
				Integer v1 = int1[0];
				Integer v2 = int2[0];
				return v1.compareTo(v2);
			}
		});
		int[] count = new int[N];
		count[0] = N;
		for (int i = 1; i < N; i++) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(i + 1);
			int j = 0;
			while (j < list.size()) {
				for (int k = j; k < M; k++) {
					if (edges[k][0] == list.get(j)) {
						if (!list.contains(edges[k][1])) {
							list.add(edges[k][1]);
						}
					}
				}
				j++;
			}
			count[i] = list.size();
		}
		int remove = 0;
		for (int c : count) {
			if (c % 2 == 0)
				remove++;
		}
		System.out.println(remove - 1);

		br.close();
	}
}
