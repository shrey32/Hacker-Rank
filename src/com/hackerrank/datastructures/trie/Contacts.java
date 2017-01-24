package com.hackerrank.datastructures.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * We're going to make our own Contacts application! The application must perform two types of operations:

 add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
 find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
 Given  sequential add and find operations, perform each operation in order.

 Input Format

 The first line contains a single integer, , denoting the number of operations to perform. 
 Each line  of the  subsequent lines contains an operation in one of the two forms defined above.

 Constraints

 It is guaranteed that  and  contain lowercase English letters only.
 The input doesn't have any duplicate  for the  operation.
 Output Format

 For each find partial operation, print the number of contact names starting with  on a new line.

 Sample Input

 4
 add hack
 add hackerrank
 find hac
 find hak
 Sample Output

 2
 0
 Explanation

 We perform the following sequence of operations:

 Add a contact named hack.
 Add a contact named hackerrank.
 Find and print the number of contact names beginning with hac. There are currently two contact names in the application and both of them start with hac, so we print  on a new line.
 Find and print the number of contact names beginning with hak. There are currently two contact names in the application but neither of them start with hak, so we print  on a new line.
 */
/**
 * 
 * @author Shrey
 *
 */
public class Contacts {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		Map<String, Integer> contacts = new HashMap<String, Integer>();
		while (n-- > 0) {
			String[] arr = br.readLine().trim().split(" ");
			if ("add".equals(arr[0])) {
				String sub = "";
				for (int i = 1; i <= arr[1].length(); i++) {
					sub = arr[1].substring(0, i);
					contacts.put(sub,
							contacts.containsKey(sub) ? contacts.get(sub) + 1
									: 1);
				}
			} else if ("find".equals(arr[0])) {
				System.out.println(contacts.containsKey(arr[1]) ? contacts
						.get(arr[1]) : 0);
			}
		}
		br.close();
	}
}
