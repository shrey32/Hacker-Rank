package com.leetcode;

import java.util.Set;
import java.util.HashSet;

/**
 * 
 * @author Shrey
 *
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 1, -1, 0 }));
	}

	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);
        int max = 0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(set.contains(num-1))
                continue;
            int count=0;
            while(set.contains(num)){
                num++;
                count++;
            }
            max = Math.max(count, max);    
        }
        return max;
	}

}
