package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class RemovePalindromicSubsequences {

	public static void main(String[] args) {
		System.out.println(removePalindromeSub("ababa"));//1
		System.out.println(removePalindromeSub("abb"));//2
		System.out.println(removePalindromeSub("baabb"));//2
		System.out.println(removePalindromeSub(""));//0
	}

	public static int removePalindromeSub(String s) {
        if(s.length() == 0)
			return 0;
        else if(isPalindromic(s))
            return 1;
        return 2;        
    }
    
    public static boolean isPalindromic(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else
                return false;
            }
        return true;
    }
}
