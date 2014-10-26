package com.hackerrank.warmup;

import java.util.Scanner;

public class SherlockAndBeast {

	 public static void main(String[] args) {
		         Scanner in = new Scanner(System.in);
		         int t = in.nextInt();
		         for(int i =0;i<t;i++){
		             int n = in.nextInt();
		             StringBuffer answer = new StringBuffer();
		             for(int j = 0;j <= n/5;j++){
		                 if((n-5*j)%3 == 0){
		                     for(int k = 0;k< n-5*j;k++)
		                         answer.append("5");
		                     for(int k = 0;k < 5*j;k++)
		                         answer.append("3");
		                     System.out.println(answer.toString());
		                     break;
		                 }
		           }
		             if(answer.toString().equals(""))
		                 System.out.println(-1);
		         }  
		         in.close();
		  }
	
}
