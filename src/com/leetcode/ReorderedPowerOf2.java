package com.leetcode;

public class ReorderedPowerOf2 {

	public static void main(String[] args) {
		System.out.println(reorderedPowerOf2(46));
		System.out.println(reorderedPowerOf2(1));
		System.out.println(reorderedPowerOf2(10));
		System.out.println(reorderedPowerOf2(16));
		System.out.println(reorderedPowerOf2(24));
	}

	public static boolean reorderedPowerOf2(int n) {
		int[] freq1 = freq(n);
        for(int i=0;i<31;i++){
            int power = (int) Math.pow(2,i);
            int[] freq2 = freq(power);
            if(compare(freq1,freq2))
                return true;
        }
		return false;
	}

    private static boolean compare(int[] a,int[] b){
        for(int i=0;i<10;i++){
            if(a[i]!=b[i])
              return false;
        }
        return true;
    }
    
	private static int[] freq(int n){
        int[] freq = new int[10];
        while(n>0){
            freq[n%10]++;
            n = n/10;
        }
        return freq;
    }
}
