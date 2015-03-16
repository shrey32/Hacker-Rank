package com.hackerrank.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 Adam is standing at point (a,b) in an infinite 2D grid. He wants to know if he can reach point (x,y) or not. The only operation he can do is to move to point (a+b,b), (a,a+b), (a-b,b), or (a,a-b) from some point (a,b). It is given that he can move to any point on this 2D grid,i.e., the points having positive or negative X(or Y) co-ordinates.

 Tell Adam whether he can reach (x,y) or not.

 Input Format 
 The first line contains an integer, T, followed by T lines, each containing 4 space separated integers i.e. a b x y

 Output Format 
 For each test case, display YES or NO that indicates if Adam can reach (x,y) or not.

 Constraints 
 0 ≤ T ≤ 1000 
 0 ≤ a,b,x,y ≤ 1018

 Sample Input

 3
 1 1 2 3
 2 1 2 3
 3 3 1 1
 Sample Output

 YES
 YES
 NO
 Explanation

 (1,1) -> (2,1) -> (2,3).
 */

/**
 * 
 * @author Shrey
 *
 */
public class PossiblePath {

	public static void main(String[] args)throws NumberFormatException,
	IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			String line=br.readLine();
			int a=Integer.parseInt(line.split(" ")[0]);
			int b=Integer.parseInt(line.split(" ")[1]);
			int x=Integer.parseInt(line.split(" ")[2]);
			int y=Integer.parseInt(line.split(" ")[3]);
			if(gcd(a,b)==gcd(x,y)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			T--;
		}
	}
	public static int gcd(int a, int b) {
		int c;
		while (a != 0) {
			c = a;
			a = b % a;
			b = c;
		}
		return b;
	}
	
}
