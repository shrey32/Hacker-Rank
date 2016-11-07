package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * John's clothing store has a pile of  loose socks where each sock  is labeled with an integer, , denoting its color. He wants to sell as many socks as possible, but his customers will only buy them in matching pairs. Two socks,  and , are a single matching pair if .

 Given  and the color of each sock, how many pairs of socks can John sell?

 Input Format

 The first line contains an integer, , denoting the number of socks. 
 The second line contains  space-separated integers describing the respective values of .

 Constraints

 Output Format

 Print the total number of matching pairs of socks that John can sell.

 Sample Input

 9
 10 20 20 10 10 30 50 10 20
 Sample Output

 3
 Explanation

 sock.png

 As you can see from the figure above, we can match three pairs of socks. Thus, we print  on a new line.
 */
/**
 * 
 * @author Shrey
 *
 */
public class SockMerchant {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String[] line = br.readLine().trim().split(" ");
		br.close();
		Map<String, Integer> map = new HashMap<>();
		int socks = 0;
		for (String s : line) {
			map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
			if (map.get(s) == 2) {
				socks++;
				map.put(s, 0);
			}
		}
		System.out.println(socks);
	}

}
