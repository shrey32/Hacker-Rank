package com.leetcode;

import java.util.PriorityQueue;

/**
 * 
 * Design an algorithm to find the kth number such that the only prime factors
 * are 3, 5, and 7. Note that 3, 5, and 7 do not have to be factors, but it
 * should not have any other prime factors. For example, the first several
 * multiples would be (in order) 1, 3, 5, 7, 9, 15, 21.
 * 
 * @author Shrey
 *
 */
public class KthMultiple {

	public static void main(String[] args) {
		System.out.println(kthMultiple(5));
		System.out.println(kthMultiple(6));
		System.out.println(kthMultiple(7));
	}

	public static int kthMultiple(int k) {
		PriorityQueue<Integer> q = new NoDuplicatesPriorityQueue<>();
		q.offer(1);
		int i = 0;
		int number = 1;
		while (i < k) {
			number = q.poll();
			q.offer(number * 3);
			q.offer(number * 5);
			q.offer(number * 7);
			i++;
		}
		System.out.println(q);
		return number;
	}

}
