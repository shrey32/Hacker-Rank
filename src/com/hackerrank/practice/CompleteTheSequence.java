package com.hackerrank.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class CompleteTheSequence {

	public static void main(String[] args) {
		completeTheSequence(new int[] { 1, 2, 3, 4, 5, 6 }, 3);// 7 8 9
		completeTheSequence(new int[] { 1, 2, 4, 7, 11, 16, 22, 29 }, 2);// 37 46
		completeTheSequence(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 2 }, 2);// 11 56
		completeTheSequence(new int[] { 3 }, 10);// 3 3 3 3 3 3 3 3 3 3
	}

	/**
	 * <p>
	 * Method Of Differences is used to solve this problem
	 * </p>
	 * 
	 * @param ar
	 * @param next
	 */
	static void completeTheSequence(int[] ar, int next) {
		int len = ar.length;

		List<List<Integer>> d = new ArrayList<>();

		d.add(new ArrayList<>());

		// initialize resultant D
		for (int i = 0; i < len; i++) {
			d.get(0).add(ar[i]);
		}

		// prepare D1, D2...Dn until we get list of constants
		int i = 0;
		while (!check(d.get(i))) {
			List<Integer> d1 = new ArrayList<>();
			len = d.get(i).size();
			for (int j = 0; j < len - 1; j++) {
				d1.add(d.get(i).get(j + 1) - d.get(i).get(j));
			}
			d.add(d1);
			i++;
		}

		// fill constants for next n sequence
		int lastSize = d.get(i).size();
		int constVal = d.get(i).get(0);
		for (int j = lastSize; j < lastSize + next; j++)
			d.get(i).add(constVal);

		// prepare Dn-1 sequence values
		int dSize = d.size();
		for (int k = dSize - 2; k >= 0; k--) {
			List<Integer> dn = d.get(k);
			List<Integer> dprev = d.get(k + 1);
			int dnSize = dn.size();
			for (int l = dnSize; l < dnSize + next; l++) {
				int elem = dn.get(l - 1) + dprev.get(l - 1);
				dn.add(elem);
			}
		}

		// print the next n sequence generated
		List<Integer> progression = d.get(0);
		int progSize = progression.size();
		for (int j = progSize - next; j < progSize; j++)
			System.out.print(progression.get(j) + " ");
		System.out.println();
	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	static boolean check(List<Integer> a) {
		for (int i = 1; i < a.size(); i++)
			if (a.get(i - 1) != a.get(i))
				return false;
		return true;
	}

}
