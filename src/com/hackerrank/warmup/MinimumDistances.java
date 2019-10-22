package com.hackerrank.warmup;


import java.util.Scanner;

/**
 * Consider an array of  integers, . The distance between two indices,  and , is denoted by .
 * <p>
 * Given , find the minimum  such that  and . In other words, find the minimum distance between any pair of equal elements in the array. If no such value exists, print .
 * <p>
 * Note:  denotes the absolute value of .
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, , denoting the size of array .
 * The second line contains  space-separated integers describing the respective elements in array .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print a single integer denoting the minimum  in ; if no such value exists, print .
 * <p>
 * Sample Input
 * <p>
 * 6
 * 7 1 3 4 1 7
 * Sample Output
 * <p>
 * 3
 * Explanation
 * Here, we have two options:
 * <p>
 * and  are both , so .
 * and  are both , so .
 * The answer is .
 * <p>
 * Created by Shrey on 1/29/2017.
 */
public class MinimumDistances {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    int tmp = Math.abs(i - j);
                    min = Math.min(min, tmp);
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
        in.close();
    }

}
