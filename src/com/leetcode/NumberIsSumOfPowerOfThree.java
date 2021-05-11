package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class NumberIsSumOfPowerOfThree {

	public static void main(String[] args) {
		System.out.println(checkPowersOfThree(91));
		System.out.println(checkPowersOfThree(21));
		System.out.println(checkPowersOfThree(12));
	}
	
	public static boolean checkPowersOfThree(int n) {
        while(n!=0){
            if(n%3==2)
                return false;
            n = n/3;
        }
        return true;
    }

}
