package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 The professor is conducting a course on Discrete Mathematics to a class of N students. He is angry at the lack of their discipline, and he decides to cancel the class if there are less than K students present after the class starts.

 Given the arrival time of each student, your task is to find out if the class gets cancelled or not.

 Input Format

 The first line of the input contains T, the number of test cases. Each test case contains two lines. 
 The first line of each test case contains two space-separated integers, N and K. 
 The next line contains N space-separated integers, a1,a2,…,aN, representing the arrival time of each student.

 If the arrival time of a given student is a non-positive integer (ai≤0), then the student enters before the class starts. If the arrival time of a given student is a positive integer (ai>0), the student enters after the class has started.

 Output Format

 For each testcase, print "YES" (without quotes) if the class gets cancelled and "NO" (without quotes) otherwise.

 Constraints

 1≤T≤10
 1≤N≤1000
 1≤K≤N
 −100≤ai≤100,where i∈[1,N]
 Note 
 If a student enters the class exactly when it starts (ai=0), the student is considered to have entered before the class has started.

 Sample Input

 2
 4 3
 -1 -3 4 2
 4 2
 0 -1 2 1
 Sample Output

 YES
 NO
 Explanation

 For the first test case, K=3, i.e., the professor wants at least 3 students to be in class but there are only 2 who have arrived on time (−3 and −1), hence the class gets cancelled.

 For the second test case, K=2, i.e, the professor wants at least 2 students to be in class and there are 2 who have arrived on time (0 and −1), hence the class does not get cancelled.
 */
/**
 * 
 * @author Shrey
 *
 */
public class AngryProfessor {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			String l = br.readLine();
			int N = Integer.parseInt(l.split(" ")[0]);
			int K = Integer.parseInt(l.split(" ")[1]);
			String line = br.readLine();
			String[] s = line.split(" ");
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (Integer.parseInt(s[i]) <= 0) {
					count++;
				}
			}
			if (K <= count) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
			T--;
		}
	}
}
