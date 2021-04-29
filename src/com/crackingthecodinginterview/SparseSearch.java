package com.crackingthecodinginterview;

/**
 * 
 * <p>
 * Given a sorted array of strings that is interspersed with empty strings,
 * write a method to find the location of a given string. EXAMPLE Input:
 * ball,{"at", "", "" , "" , "ball", "" , "" , "car", "" , "" , "dad", "",""}
 * output:4
 * </p>
 * 
 * @author Shrey
 *
 */
public class SparseSearch {

	public static void main(String[] args) {
		String[] ar = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
		System.out.println(sparseSearch(ar, "ball"));
		System.out.println("count ==>" + count);
		count = 0;
		System.out.println(sparseSearch(ar, "dad"));
		System.out.println("count ==>" + count);
		count = 0;
		System.out.println(sparseSearch(ar, "at"));
		System.out.println("count ==>" + count);
		count = 0;
		System.out.println(sparseSearch(ar, "the"));
		System.out.println("count ==>" + count);
		count = 0;
		System.out.println(sparseSearch(ar, "a"));
		System.out.println("count ==>" + count);
		count = 0;
		System.out.println(sparseSearch(ar, "bb"));
		System.out.println("count ==>" + count);
		count = 0;
	}

	static int count = 0;

	public static int sparseSearch(String[] ar, String key) {
		int lo = 0;
		int hi = ar.length;
		while (lo <= hi) {
			count++;
			int mid = (lo + hi) / 2;
			if ("".equals(ar[mid])) {
				// get to the closest non empty word to the right/left
				int left = mid;
				int right = mid;
				while ((left >= 0 && "".equals(ar[left])) && (right < ar.length && "".equals(ar[right]))) {
					left--;
					right++;
					count++;
				}
				if (right == ar.length || left < 0)
					return -1;

				if (right < ar.length && !"".equals(ar[right])) {
					mid = right;
				} else if (left >= 0) {
					mid = left;
				}
			}

			if (ar[mid].compareTo(key) == 0) {
				return mid;
			} else if (ar[mid].compareTo(key) < 0) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}

}
