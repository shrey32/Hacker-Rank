package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class PalindromicSubstrings {

	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
		System.out.println(countSubstrings("aabbaa"));
	}
	
	public static int countSubstrings(String s) {
        if(s==null || s.length()==0)
            return 0;
        int len = s.length();
        int total = 0; 
        for(int i=0;i<len;i++){
            total+= expand(i,i,s);
            total+= expand(i,i+1,s);
        }
        return total;
    }
    
    public static int expand(int start,int end,String s){
        int count = 0;
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            count++;
        }
        return count;
    } 

}
