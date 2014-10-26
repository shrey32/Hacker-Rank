package com.hackerrank.warmup;

import java.util.Scanner;

/**Sherlock is stuck. He has an array A1,A2,⋯,AN. He wants to know if there exists a subset, B={Ai1,Ai2,…,Aik} where 1≤i1<i2<…<ik≤N, of this array which follows the property

 B is non-empty subset.
 There exists no integer x(x>1) which divides all elements of B. Note that x may or may not be an element of A.
 Input Format 
 First line contains T, the number of testcases. Each testcase consists of N in one line. The next line contains N integers denoting the array A.

 Output 
 Print YES or NO, if there exists any such subset or not, respectively.

 Constraints 
 1≤T≤10 
 1≤N≤100 
 1≤Ai≤105 ∀1≤i≤N

 Sample input

 2
 3
 1 2 3
 2
 2 4
 Sample output

 YES
 NO
 Explanation 
 In first testcase, S={1},S={1,2},S={1,3},S={2,3} and S={1,2,3} are all the possible subsets which satisfy the given condition. 
 In second testcase, no non-empty subset exists which satisfies the given condition.
 */

/**
 * @author Shrey
 *
 */
public class SherlockAndGCD {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int i = 0; i < T; i++) {

			int size = scan.nextInt();
			int[] arr = new int[size];
			int gcd=0;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = scan.nextInt();
				gcd=getValue(gcd, arr[j]);
			}
			if(gcd==1){
			System.out.println("YES");	
			}else{
				System.out.println("NO");
			}
		}
		scan.close();
	}

	public static int getValue(int m,int n) {
		
		while(n!=0){
			int temp=n;
			n=m%n;
			m=temp;
		}
	 return m;
	}
}
