package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 
 * @author Shrey
 *
 */
public class InsertInterval {

	public int[][] insert(int[][] intervals, int[] newI) {
        if(newI==null || newI.length==0)
            return intervals;
        if(intervals==null || intervals.length==0)
            return new int[][]{newI};
        int len = intervals.length;
        int[][] ar = new int[len+1][2];
        //add new interval
        ar[0] = newI;
        for(int i=1;i<len+1;i++){
            ar[i] = intervals[i-1];
        }
        Arrays.sort(ar,(a1,a2)->a1[0]-a2[0]);
        
		LinkedList<int[]> ans = new LinkedList<>();
       
        for(int[] i : ar){
            if(ans.isEmpty()){
                ans.add(i);
                continue;
            }
            int[] last = ans.getLast();
            if(last[1]>=i[0])
                last[1] = Math.max(last[1],i[1]);
            else {
                ans.add(i);    
            }
        }
        
        int[][] res = new int[ans.size()][2];
        
        return ans.toArray(res);
    }

}
