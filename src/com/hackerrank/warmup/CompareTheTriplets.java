package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from  to  for three categories: problem clarity, originality, and difficulty.

 We define the rating for Alice's challenge to be the triplet , and the rating for Bob's challenge to be the triplet .

 Your task is to find their comparison scores by comparing  with ,  with , and  with .

 If , then Alice is awarded  point.
 If , then Bob is awarded  point.
 If , then neither person receives a point.
 Given  and , can you compare the two challenges and print their respective comparison points?

 Input Format

 The first line contains  space-separated integers, , , and , describing the respective values in triplet . 
 The second line contains  space-separated integers, , , and , describing the respective values in triplet .

 Constraints

 Output Format

 Print two space-separated integers denoting the respective comparison scores earned by Alice and Bob.

 Sample Input

 5 6 7
 3 6 10
 Sample Output

 1 1 
 Explanation

 In this example:

 Now, let's compare each individual score:

 , so Alice receives 1 point.
 , so nobody receives a point.
 , so Bob receives 1 point.
 Alice's comparison score is , and Bob's comparison score is . Thus, we print 1 1 (Alice's comparison score followed by Bob's comparison score) on a single line.
 */
/**
 * 
 * @author Shrey
 *
 */
public class CompareTheTriplets {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line1 = br.readLine().trim().split(" ");
		String[] line2 = br.readLine().trim().split(" ");
		int count1 = 0, count2 = 0;
		for (int i = 0; i < 3; i++) {
			int a = Integer.parseInt(line1[i]);
			int b = Integer.parseInt(line2[i]);
			if (a > b) {
				count1++;
			} else if (a < b) {
				count2++;
			}
		}
		System.out.println(count1 + " " + count2);
		br.close();
	}

}
