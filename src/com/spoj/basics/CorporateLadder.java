package com.spoj.basics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Corporate Ladder Programming challenge description: A company wants to track
 * change in their organization by knowing how many levels exist between any two
 * employees. This number will help them know who is being promoted and who is
 * not.
 * 
 * For example: If Susan reports to John and John reports to Amy. Then, there
 * are 2 level between Susan and Amy.
 * 
 * Write a program that will count how many levels exist between any two names
 * in a hierarchy of employees. The program must read a list of name pairs that
 * represent an employee and their manager.
 * 
 * HINT: The two names to compare may be in different parts of the
 * organizational tree and not have a direct managerial line.
 * 
 * Input: The first line of input will be a pair of names to compare.
 * 
 * All subsequent lines will be employee/manager pairs. The company's complete
 * hierarchy will be included so no incomplete trees will exist.
 * 
 * For example:
 * 
 * Susan/Amy<br>
 * Susan/John<br>
 * John/Amy<br>
 * #<br>
 * Output:2
 * 
 * Scott/David<br>
 * Terry/David<br>
 * Kyle/David<br>
 * Ben/Kyle<br>
 * Scott/Jon<br>
 * Chris/Scott<br>
 * Jon/Kenny<br>
 * Kenny/David<br>
 * David/Mike<br>
 * #<br>
 * Output:3
 * 
 * Ben/Jon<br>
 * Terry/David<br>
 * Kyle/David<br>
 * Ben/Kyle<br>
 * Scott/Jon<br>
 * Chris/Scott<br>
 * Jon/Kenny<br>
 * Kenny/David<br>
 * #<br>
 * Output:0
 * 
 * Christy/Susan<br>
 * Aimee/Melissa<br>
 * Melissa/Susan<br>
 * Stacy/Corinne<br>
 * Gabrielle/Melissa<br>
 * Corinne/Melissa<br>
 * Christy/Stacy<br>
 * Pat/Christy<br>
 * #<br>
 * Output:4
 * 
 * @author Shrey
 *
 */
public class CorporateLadder {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String pair = in.next();
		String firstEmp = pair.split("/")[0];
		String lastEmp = pair.split("/")[1];
		List<String> input = new ArrayList<>();
		String start = "";
		while (true) {
			String line = in.next();
			if (line == null || "".equals(line) || "#".equals(line))
				break;
			if (firstEmp.equals(line.split("/")[0])) {
				start = line.split("/")[1];
			}
			input.add(line);
		}

		System.out.println(corporateLadder(start, lastEmp, input));
		in.close();
	}

	private static final int corporateLadder(String search, String lastEmp, List<String> input) {
		int count = 1;
		while (!search.equals(lastEmp)) {
			String pre = search;
			for (String s : input) {
				String[] ar = s.split("/");
				if (search.equals(ar[0])) {
					search = ar[1];
					count++;
					break;
				}
			}
			if (pre.equals(search)) {
				return 0;
			}
		}
		return count;
	}

}
