package com.hackerrank.warmup;

/**
 * Lily likes to play games with integers and their reversals. For some integer , we define  to be the reversal of all digits in . For example, , , and .
 * <p>
 * Logan wants to go to the movies with Lily on some day  satisfying , but he knows she only goes to the movies on days she considers to be beautiful. Lily considers a day to be beautiful if the absolute value of the difference between  and  is evenly divisible by .
 * <p>
 * Given , , and , count and print the number of beautiful days when Logan and Lily can go to the movies.
 * <p>
 * Input Format
 * <p>
 * A single line of three space-separated integers describing the respective values of , , and .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print the number of beautiful days in the inclusive range between  and .
 * <p>
 * Sample Input
 * <p>
 * 20 23 6
 * Sample Output
 * <p>
 * 2
 * Explanation
 * <p>
 * Logan wants to go to the movies on days , , , and . We perform the following calculations to determine which days are beautiful:
 * <p>
 * Day  is beautiful because the following evaluates to a whole number:
 * Day  is not beautiful because the following doesn't evaluate to a whole number:
 * Day  is beautiful because the following evaluates to a whole number:
 * Day  is not beautiful because the following doesn't evaluate to a whole number:
 * Only two days,  and , in this interval are beautiful. Thus, we print  as our answer.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shrey on 2/4/2017.
 */
public class BeautifulDaysAtTheMovies {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().trim().split(" ");
        int i = Integer.parseInt(arr[0]);
        int j = Integer.parseInt(arr[1]);
        int k = Integer.parseInt(arr[2]);
        int count = 0;
        for (int m = i; m <= j; m++) {
            int rev = Integer.parseInt(new StringBuilder("" + m).reverse().toString());
            int mod = Math.abs(m - rev) % k;
            if (mod == 0) {
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }

}
