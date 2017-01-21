package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaArrayList {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < n; i++) {
			List<String> list = new ArrayList<String>(Arrays.asList(br
					.readLine().trim().split(" ")));
			map.put(i + 1 + "", list);
		}
		int q = Integer.parseInt(br.readLine().trim());
		String[] query = null;
		for (int i = 0; i < q; i++) {
			query = br.readLine().trim().split(" ");
			int ind = Integer.parseInt(query[1]);
			if (map.containsKey(query[0]) && ind < map.get(query[0]).size()) {
				System.out.println(map.get(query[0]).get(ind));
			} else {
				System.out.println("ERROR!");
			}
		}
		br.close();
	}

}
