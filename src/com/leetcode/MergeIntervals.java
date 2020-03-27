package com.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class MergeIntervals {

	public static void main(String[] args) {
		// 1
		List<Interval> intervals = new LinkedList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		System.out.println(mergeIntervals(intervals));
		// 2
		intervals = new LinkedList<>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(4, 5));
		System.out.println(mergeIntervals(intervals));
		//3
		intervals = new LinkedList<>();
		intervals.add(new Interval(5, 7));
		intervals.add(new Interval(6, 8));
		System.out.println(mergeIntervals(intervals));
		
	}

	/**
	 * <p>
	 * <b>1.</b>Sort the intervals based on increasing order of starting time.
	 * </p>
	 * <p>
	 * <b>2.</b>Push the first interval on to a stack.
	 * </p>
	 * <p>
	 * <b>3.</b> For each interval do the following a. If the current interval does
	 * not overlap with the stack top, push it. b. If the current interval overlaps
	 * with stack top and ending time of current interval is more than that of stack
	 * top, update stack top with the ending time of current interval.
	 * </p>
	 * <p>
	 * <b>4.</b> At the end stack contains the merged intervals.
	 * </p>
	 * 
	 * @param intervals
	 * @return mergedIntervals
	 */
	public static List<Interval> mergeIntervals(List<Interval> intervals) {

		Collections.sort(intervals, (a, b) -> {
			return a.start - b.start;
		});

		Stack<Interval> intervalStack = new Stack<>();
		intervalStack.push(intervals.get(0));

		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			Interval top = intervalStack.peek();
			if (top.end < curr.start) {
				intervalStack.push(curr);
			} else {
				top.end = curr.end;
			}
		}

		return new LinkedList<>(intervalStack);
	}

	private static class Interval {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "[" + this.start + "," + this.end + "]";
		}
	}

}
