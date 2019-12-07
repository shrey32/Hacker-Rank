package com.spoj.basics;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://www.spoj.com/problems/PG10181/">PG10181 - Grade 10
 * Scholarship</a>
 * 
 * @author Shrey
 *
 */
public class Scholarship {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		Set<Integer> knowledge = new HashSet<>();
		while (n-- > 0)
			knowledge.add(scan.nextInt());
		int m = scan.nextInt();
		
		Set<Integer> english = new HashSet<>();
		while (m-- > 0)
			english.add(scan.nextInt());
		
		knowledge.retainAll(english);
		
		System.out.println(knowledge.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
		scan.close();
	}

}
