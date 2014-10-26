package com.hackerrank.warmup;

import java.util.Scanner;

/**Watson gives two integers A & B to Sherlock and asks if he can count the number of square integers between A and B (both inclusive).

 A square integer is an integer which is the square of any integer. For example, 1, 4, 9, 16 are some of the square integers as they are squares of 1, 2, 3, 4 respectively.

 Input Format 
 First line contains T, the number of testcases. T test cases follow, each in a newline. 
 Each testcase contains two space separated integers denoting A and B.

 Output Format 
 For each testcase, print the required answer in a new line.

 Constraints 
 1 ≤ T ≤ 100 
 1 ≤ A ≤ B ≤ 109

 Sample Input

 2
 3 9
 17 24
 Sample output

 2
 0
 Explanation 
 In the first testcase, 4 and 9 are the square numbers. 
 In second testcase no square numbers exist between 17 and 24 (both inclusive).*/

/**
 * @author Shrey
 *
 */
public class SherlockAndSquares {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int i = 0; i < T; i++) {

			long A = scan.nextLong();
			long B = scan.nextLong();

			int C = (int) (Math.floor(Math.sqrt(B)) - Math.ceil(Math.sqrt(A)) + 1);

			System.out.println(C);
		}
		scan.close();
	}
	
	
	public static int getInt(double num) {

		double i = 1;
		int num2 = 0;
		while (i <= num) {

			double count = i * i;
			if (count == num) {
				num2 = 1;
				break;
			}
			i++;
		}
		return num2;
	}

}
