package com.leetcode;
/**
 * 
 * @author Shrey
 *
 */
public class MinimumOperationsToMakeArrayEqual {

	public static void main(String[] args) {
		System.out.println(minOperations(5));
		System.out.println(minOperations(8989));
		System.out.println(minOperations(374));
	}

	public static int minOperations(int n) {
        int prod = (n/2)*(n/2);
        return (n%2==0)?prod:prod+n/2;
   }
	
}
