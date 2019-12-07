package com.spoj.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://www.spoj.com/problems/SMPDIV/">SMPDIV - Divisibility</a>
 * 
 * @author Shrey
 *
 */
public class Divisibility {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String inpLine = br.readLine();
			String[] inps = inpLine.split(" ");
			int n = Integer.parseInt(inps[0]);
			int x = Integer.parseInt(inps[1]);
			int y = Integer.parseInt(inps[2]);
			System.out.println(solve(n, x, y));
		}
		br.close();
	}

	final static String solve(int n, int x, int y) {
		List<String> list = new ArrayList<>();

		for (int i = 1; (i * x) < n; i++) {
			if ((i * x) % y != 0)
				list.add((i * x) + " ");
		}

		return list.stream().collect(Collectors.joining(""));
	}

}
