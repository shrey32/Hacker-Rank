package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given a list of N people who are attending ACM-ICPC World Finals.
 * Each of them are either well versed in a topic or they are not. Find out the
 * maximum number of topics a 2-person team can know. And also find out how many
 * teams can know that maximum number of topics.
 * 
 * Input Format
 * 
 * The first line contains two integers N and M separated by a single space,
 * where N represents the number of people, and M represents the number of
 * topics. N lines follow. Each line contains a binary string of length M. In
 * this string, 1 indicates that the ith person knows a particular topic, and 0
 * indicates that the ith person does not know the topic. Here, 1 ≤ i ≤ 2, and
 * it denotes one of the persons in the team.
 * 
 * Output Format
 * 
 * On the first line, print the maximum number of topics a 2-people team can
 * know. On the second line, print the number of 2-person teams that can know
 * the maximum number of topics.
 * 
 * Constraints
 * 
 * 2 ≤ N ≤ 500
 * 
 * 1 ≤ M ≤ 500 Sample Input
 * 
 * 4 5 10101 11100 11010 00101 Sample Output
 * 
 * 5 2 Explanation (1, 3) and (3, 4) know all the 5 topics. So the maximal
 * topics a 2-people team knows is 5, and only 2 teams can achieve this.
 */

/**
 * @author Shrey
 *
 */
public class ACM_ICPC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l = br.readLine();
		int N = Integer.parseInt(l.split(" ")[0]);
		int M = Integer.parseInt(l.split(" ")[1]);
		String[] teams = new String[N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			teams[i] = line;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxTopic = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			String team1 = teams[i];
			for (int j = i + 1; j < N; j++) {
				int count = 0;
				String team2 = teams[j];
				for (int k = 0; k < M; k++) {
					String s = String.valueOf(team1.charAt(k));
					String s2 = String.valueOf(team2.charAt(k));
					if (s.equals("1") || s2.equals("1")) {
						count++;
					}
				}
				if (count > maxTopic || count == maxTopic) {
					maxTopic = count;
					if (!map.containsKey(maxTopic)) {
						map.put(maxTopic, 1);
					} else {
						map.put(maxTopic, map.get(maxTopic) + 1);
					}
				}
			}
		}
		System.out.println(maxTopic);
		System.out.println(map.get(maxTopic));
		br.close();
	}
}
