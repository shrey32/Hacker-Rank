package com.hackerrank.arraysorting;

import java.util.ArrayList;
import java.util.Scanner;

/**Alice recently started learning about cryptography and found that anagrams are very useful. Two strings are anagrams of each other if they have same character set. For example strings "bacdc" and "dcbac" are anagrams, while strings "bacdc" and "dcbad" are not.

 Alice decides on an encryption scheme involving 2 large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. She need your help in finding out this number.

 Given two strings (they can be of same or different length) help her in finding out the minimum number of character deletions required to make two strings anagrams. Any characters can be deleted from any of the strings.

 Input Format 
 Two lines each containing a string.

 Constraints 
 1 <= Length of A,B <= 10000 
 A and B will only consist of lowercase latin letter.

 Output Format 
 A single integer which is the number of character deletions.

 Sample Input #00:

 cde
 abc
 Sample Output #00:

 4
 Explanation #00: 
 We need to delete 4 characters to make both strings anagram i.e. 'd' and 'e' from first string and 'b' and 'a' from second string.*/

/**
 * @author Shrey
 *
 */
public class MakeItAnagram {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine();
		String b = scan.nextLine();

		makeItAnagram(a, b);
		scan.close();

	}

	public static void makeItAnagram(String a, String b) {
		ArrayList<Character> cList = new ArrayList<Character>();
		ArrayList<Character> cListB = new ArrayList<Character>();

		for (int i = 0; i < a.length(); i++) {
			cList.add(a.charAt(i));
		}
		for (int i = 0; i < b.length(); i++) {
			cListB.add(b.charAt(i));
		}

		ArrayList<Character> d = new ArrayList<Character>(cListB);
		ArrayList<Character> e = new ArrayList<Character>(cList);

		for (int i = 0; i < cList.size(); i++) {

			if (cListB.contains(cList.get(i))) {

				if(d.contains(cList.get(i)))
				d.remove(d.indexOf(cList.get(i)));

			}
		}

		for (int i = 0; i < cListB.size(); i++) {

			if (cList.contains(cListB.get(i))) {
				if(e.contains(cListB.get(i)))
				e.remove(e.indexOf(cListB.get(i)));
		}
		}

		System.out.println(d.size() + e.size());
	}
}
