package com.hackerrank.dynamicprogramming;

import java.util.Arrays;

public class SamAndSubstrings {

	public static void main(String[] args) {
		System.out.println(substrings("123"));
	}

	static long substrings(String n) {
		int[] s = Arrays.stream(n.split("")).mapToInt(Integer::parseInt).toArray();
		long sum=0;
        int length = s.length;
        long ones = 1;
        int mod = 1000000007;
        for(int i=0;i<length;i++){
            sum = (sum + s[length-i-1]*(length-i)*ones ) % mod;
            ones = (ones*10 +1) % mod;
        }
         return sum;
	}

}
