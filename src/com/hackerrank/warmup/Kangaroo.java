package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * There are two kangaroos on an x-axis ready to jump in the positive direction (i.e, toward positive infinity). The first kangaroo starts at location  and moves at a rate of  meters per jump. The second kangaroo starts at location  and moves at a rate of  meters per jump. Given the starting locations and movement rates for each kangaroo, can you determine if they'll ever land at the same location at the same time?

 Input Format

 A single line of four space-separated integers denoting the respective values of , , , and .

 Constraints

 Output Format

 Print YES if they can land on the same location at the same time; otherwise, print NO.

 Note: The two kangaroos must land at the same location after making the same number of jumps.

 Sample Input 0

 0 3 4 2
 Sample Output 0

 YES
 Explanation 0

 The two kangaroos jump through the following sequence of locations:

 Thus, the kangaroos meet after  jumps and we print YES.

 Sample Input 1

 0 2 5 3
 Sample Output 1

 NO
 Explanation 1

 The second kangaroo has a starting location that is ahead (further to the right) of the first kangaroo's starting location (i.e., ). Because the second kangaroo moves at a faster rate (meaning ) and is already ahead of the first kangaroo, the first kangaroo will never be able to catch up. Thus, we print NO.
 */
/**
 * 
 * @author Shrey
 *
 */
public class Kangaroo {

	/**
	 * Solution:<br>
	 * <p>
	 * We just need to check if a solution exists for the following equation:
	 * <b>x1+t*v1==x2+t*v2</b><br> where "t" is jump
	 * <p>
	 * <p>
	 * This is equivalent to checking if: <b>(x2 - x1) % (v1 - v2) == 0</b>
	 * <p>
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		br.close();
		int x1 = Integer.parseInt(line[0]);
		int v1 = Integer.parseInt(line[1]);
		int x2 = Integer.parseInt(line[2]);
		int v2 = Integer.parseInt(line[3]);
		if (v1 > v2 && (x2 - x1) % (v1 - v2) == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
