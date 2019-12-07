package com.spoj.basics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GordonAndGallery {

	public static void main (String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(n/3);
		}
		br.close();
	}

}
