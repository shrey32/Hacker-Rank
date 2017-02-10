package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Karl has an array of  integers defined as . In one operation, he can delete any element from the array.
 * <p>
 * Karl wants all the elements of the array to be equal to one another. To do this, he must delete zero or more elements from the array. Find and print the minimum number of deletion operations Karl must perform so that all the array's elements are equal.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, , denoting the number of elements in array .
 * The next line contains  space-separated integers where element  corresponds to array element  (.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print a single integer denoting the minimum number of elements Karl must delete for all elements in the array to be equal.
 * <p>
 * Sample Input
 * <p>
 * 5
 * 3 3 2 1 3
 * Sample Output
 * <p>
 * 2
 * Explanation
 * <p>
 * Array . If we delete  and , all of the elements in the resulting array, , will be equal. Deleting these  elements is minimal because our only other options would be to delete  elements to get an array of either  or . Thus, we print  on a new line, as that is the minimum number of deletions resulting in an array where all elements are equal.
 * <p>
 * Created by Shrey on 2/10/2017.
 */
public class EqualizeTheArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine().trim();
        String[] arr = br.readLine().trim().split(" ");
        Map<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (String s : arr) {
            map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
            max = Math.max(max, map.get(s));
        }
        System.out.println(arr.length - max);
        br.close();
    }

}
