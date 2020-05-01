package com.leetcode.monthchallenge.april;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * <b>First Unique Number</b>
 * 
 * <p>
 * You have a queue of integers, you need to retrieve the first unique integer
 * in the queue.
 * </p>
 * 
 * <b>Implement the FirstUnique class:</b>
 * 
 * <li>FirstUnique(int[] nums) Initializes the object with the numbers in the
 * queue.</li>
 * <li>int showFirstUnique() returns the value of the first unique integer of
 * the queue, and returns -1 if there is no such integer.</li>
 * <li>void add(int value) insert value to the queue.</li>
 * 
 * @author Shrey
 *
 */
public class FirstUnique {

	List<Integer> lst;
	LinkedHashSet<Integer> uniq;
	HashSet<Integer> dup;

	public FirstUnique(int[] nums) {
		lst = new ArrayList<Integer>();
		dup = new HashSet<Integer>();
		uniq = new LinkedHashSet<Integer>();

		for (int num : nums) {

			if (!uniq.contains(num) && !dup.contains(num)) {
				uniq.add(num);
			} else {
				if (uniq.contains(num)) {
					uniq.remove(num);
					dup.add(num);
				}

			}
		}
	}

	public int showFirstUnique() {
		if (uniq.size() == 0)
			return -1;
		for (int num : uniq) {
			return num;
		}
		return -1;
	}

	public void add(int num) {
		if (!uniq.contains(num) && !dup.contains(num)) {
			uniq.add(num);
		} else {
			if (uniq.contains(num)) {
				uniq.remove(num);
				dup.add(num);
			}

		}
	}

}
