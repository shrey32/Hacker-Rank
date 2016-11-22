package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Happy Ladybugs is a board game having the following properties:

 The board is represented by a string, , of length . The  character of the string, , denotes the  cell of the board.
 If  is an underscore (i.e., _), it means the  cell of the board is empty.
 If  is an uppercase English alphabetic letter (i.e., A through Z), it means the  cell contains a ladybug of color .
 String  will not contain any other characters.
 A ladybug is happy only when its left or right adjacent cell (i.e., ) is occupied by another ladybug having the same color.
 In a single move, you can move a ladybug from its current position to any empty cell.
 Given the values of  and  for  games of Happy Ladybugs, determine if it's possible to make all the ladybugs happy. For each game, print YES on a new line if all the ladybugs can be made happy through some number of moves; otherwise, print NO to indicate that no number of moves will result in all the ladybugs being happy.

 Input Format

 The first line contains an integer, , denoting the number of games. The  subsequent lines describes a Happy Ladybugs game in the following format:

 The first line contains an integer, , denoting the number of cells on the board.
 The second line contains a string, , describing the  cells of the board.
 Constraints

 It is guaranteed that string  consists of underscores and/or uppercase English alphabetic letters (i.e., _ and A through Z).
 Output Format

 For each game, print YES on a new line if it is possible to make all the ladybugs happy; otherwise, print NO.

 Sample Input 0

 4
 7
 RBY_YBR
 6
 X_Y__X
 2
 __
 6
 B_RRBR
 Sample Output 0

 YES
 NO
 YES
 YES
 Explanation 0

 The first three games of Happy Ladybugs are explained below:

 Initial board: 
 lady.png
 After the first move: 
 lady(1).png
 After the second move: 
 lady(2).png
 After the third move: 
 lady(3).png
 Now all the ladybugs are happy, so we print YES on a new line.
 There is no way to make the ladybug having color Y happy, so we print NO on a new line.
 There are no unhappy ladybugs, so we print YES on a new line.
 */
/**
 * 
 * @author Shrey
 *
 */
public class HappyLadyBugs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine().trim());
		String arr[] = null;
		String val = "";
		String line = "";
		while (g-- > 0) {
			int space = 0;
			int n = Integer.parseInt(br.readLine().trim());
			arr = new String[n];
			Map<String, Integer> map = new HashMap<>();
			line = br.readLine().trim();
			arr = line.split("");
			for (String s : arr) {
				if (!"_".equals(s))
					map.put(s, !map.containsKey(s) ? 1 : map.get(s) + 1);
				else
					space++;
			}
			if (map.size() == 0) {
				System.out.println("YES");
				continue;
			}
			Set<String> set = map.keySet();
			Iterator<String> itr = set.iterator();
			boolean noPair = false;
			boolean allSame = false;
			while (itr.hasNext()) {
				val = itr.next();
				if (map.get(val) == 1) {
					noPair = true;
					break;
				} else if (map.get(val) == arr.length && space == 0) {
					allSame = true;
					break;
				}
			}
			if (noPair)
				System.out.println("NO");
			else if (allSame) {
				System.out.println("YES");
			} else {
				if (space == 0 && !noPair && !allSame) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			}
		}
	}
}
