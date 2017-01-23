package com.hackerrank.datastructures.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
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
