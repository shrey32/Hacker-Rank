package com.crackingthecodinginterview;

/**
 * 
 * : A majority element is an element that makes up more than half of the items
 * in an array. Given a positive integers array, find the majority element. If
 * there is no majority element, return-1. Do this inO(N) time and 0(1) space.
 * 
 * @author Shrey
 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		System.out.println(majority(new int[] { 1, 2, 5, 9, 5, 9, 5, 5, 5 }));
		System.out.println(majority(new int[] { 1, 2, 5, 9, 5, 9 }));
	}

	public static int majority(int[] a) {
		int elem = majorityElement(a);
		if (majority(elem, a))
			return elem;
		return -1;
	}

	public static int majorityElement(int[] a) {
		int count = 0;
		int element = -1;
		for (int i = 0; i < a.length; i++) {
			if (count == 0) {
				element = a[i];
			}
			count += element == a[i] ? 1 : -1;
		}
		return element;
	}

	public static boolean majority(int elem, int[] a) {
		int count = 0;
		for (int i : a) {
			if (i == elem)
				count++;
			if (count > a.length / 2)
				return true;
		}
		return false;
	}

}
