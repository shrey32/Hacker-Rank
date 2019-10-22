package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are given an array of  integers, , and a positive integer, . Find and print the number of pairs where  and  +  is evenly divisible by .
 * <p>
 * Input Format
 * <p>
 * The first line contains  space-separated integers,  and , respectively.
 * The second line contains  space-separated integers describing the respective values of .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print the number of  pairs where  and  +  is evenly divisible by .
 * <p>
 * Sample Input
 * <p>
 * 6 3
 * 1 3 2 6 1 2
 * Sample Output
 * <p>
 * 5
 * Explanation
 * <p>
 * Here are the  valid pairs:
 * <p>
 * <p>
 * <p>
 * Created by Shrey on 2/10/2017.
 */
public class DivisibleSumPairs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int n = Integer.parseInt(line.split(" ")[0]);
        int k = Integer.parseInt(line.split(" ")[1]);
        String[] arr = br.readLine().trim().split(" ");
        int count = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(arr[i]);
            for (int j = i + 1; j < n; j++) {
                int b = Integer.parseInt(arr[j]);
                if ((a + b) % k == 0)
                    count++;
            }
        }
        System.out.print(count);
        br.close();
    }

}
