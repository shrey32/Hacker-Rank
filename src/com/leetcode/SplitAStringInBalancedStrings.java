package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class SplitAStringInBalancedStrings {

	public static void main(String[] args) {
		System.out.println(balancedStringSplit("RLRRLLRLRL"));
		System.out.println(balancedStringSplit("RLLLLRRRLR"));
		System.out.println(balancedStringSplit("LLLLRRRR"));
		System.out.println(balancedStringSplit("RLRRRLLRLL"));
	}

	public static int balancedStringSplit(String s) {
        int count=0,x=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            x += c=='L'?1:-1;
            if(x==0)
                count++;
        }
        return count;
    }
	
}
