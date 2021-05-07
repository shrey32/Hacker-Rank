package com.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * @author Shrey
 *
 * @param <E>
 */
public class NoDuplicatesPriorityQueue<E> extends PriorityQueue<E> {

	private static final long serialVersionUID = 1L;
	private Set<E> set;

	public NoDuplicatesPriorityQueue() {
		this.set = new HashSet<>();
	}

	@Override
	public boolean offer(E e) {
		if (set.contains(e))
			return true;
		set.add(e);
		return super.offer(e);
	}

	@Override
	public E poll() {
		E e = super.poll();
		set.remove(e);
		return e;
	}

}
