package com.spoj.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://www.spoj.com/problems/SMPSEQ3/">SMPSEQ3 - Fun with
 * Sequences</a>
 * 
 * @author Shrey
 *
 */
public class FunWithTheSequence {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();// n
		Set<Integer> s = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf)
				.collect(Collectors.toCollection(LinkedHashSet::new));
		br.readLine();// m
		Set<Integer> q = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf)
				.collect(Collectors.toCollection(LinkedHashSet::new));

		for (int i : s) {
			if (!q.contains(i))
				System.out.print(i + " ");
		}

		s.retainAll(q);

		System.out.println(s.stream().map(String::valueOf).collect(Collectors.joining(" ")));

		br.close();
	}

}
