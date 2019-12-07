package com.spoj.basics;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/SIMPLFYIT/">SIMPLFYIT - Simplify
 * IT</a>
 * 
 * @author Shrey
 *
 */
public class SimplifyIT {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			Map<String, Integer> expressions = new LinkedHashMap<>();
			List<String> ops = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String cond = scan.next();
				if ("3".equals(cond) && expressions.isEmpty()) {
					System.out.println("0");
					continue;
				} else if ("3".equals(cond)) {
					print(expressions, ops);
					continue;
				}
				String exp = scan.next();
				simplify(cond, exp, expressions, ops);
			}
		}
		scan.close();
	}

	private final static void simplify(String cond, String exp, Map<String, Integer> expressions, List<String> ops) {
		char[] chars = exp.toCharArray();
		int c = chars[0] - '0';
		String a = String.valueOf(chars[1]);
		int p = chars[2] - '0';
		String b = String.valueOf(chars[3]);
		int q = chars[4] - '0';
		StringBuilder simplified = new StringBuilder();

		if (p > 0)
			simplified.append(a);
		if (p > 1)
			simplified.append(p);
		if (q > 0)
			simplified.append(b);
		if (q > 1)
			simplified.append(q);

		int state = (c > 1 ? c : 1);
		if ("1".equals(cond)) {
			state = expressions.getOrDefault(simplified.toString(), 0) + state;
			ops.add("+");
		} else if ("2".equals(cond)) {
			state = expressions.getOrDefault(simplified.toString(), 0) - state;
			ops.add("-");
		}

		expressions.put(simplified.toString(), state);
	}

	private final static void print(Map<String, Integer> expressions, List<String> ops) {
		int i = 1;
		for (String key : expressions.keySet()) {
			int val = expressions.get(key);
			if (val > 1)
				System.out.print(val);
			System.out.print(key);
			if (i < expressions.size()) {
				System.out.print(ops.get(i));
				i++;
			}
		}
		System.out.println();
	}

}
