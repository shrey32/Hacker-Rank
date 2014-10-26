package com.hackerrank.warmup;

import java.util.Scanner;
 
public class GameOfThrones1 {
 
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String in = myScan.nextLine();
        
        String ans;
        // Assign ans a value of s or no, depending on whether or not inputString satisfies the required condition
        if(in.length()==1)
            ans = "YES";
        int[] letters = new int[26];
        for(int i=0;i<in.length();i++){
            letters[in.charAt(i)-'a']++;
        }
        int odd = 0;
        for(int l:letters){
            if(l%2!=0)
                odd++;
        }
        ans = (odd>1)?"NO":"YES";
        System.out.println(ans);
        myScan.close();
    }
}