package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Erica wrote an increasing sequence of  numbers () in her notebook. She considers a triplet  to be beautiful if:
 * <p>
 * Given the sequence and the value of , can you help Erica count the number of beautiful triplets in the sequence?
 * <p>
 * Input Format
 * <p>
 * The first line contains  space-separated integers,  (the length of the sequence) and  (the beautiful difference), respectively.
 * The second line contains  space-separated integers describing Erica's increasing sequence, .
 * <p>
 * Constraints
 * <p>
 * for
 * Output Format
 * <p>
 * Print a single line denoting the number of beautiful triplets in the sequence.
 * <p>
 * Sample Input
 * <p>
 * 7 3
 * 1 2 4 5 7 8 10
 * Sample Output
 * <p>
 * 3
 * Explanation
 * <p>
 * Our input sequence is , and our beautiful difference . There are many possible triplets , but our only beautiful triplets are  ,  and . Please see the equations below:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Recall that a beautiful triplet satisfies the following equivalence relation:  where .
 * <p>
 * Created by Shrey on 2/10/2017.
 */
public class BeautifulTriplets {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int d = Integer.parseInt(line.split(" ")[1]);
        String[] arr = br.readLine().trim().split(" ");
        beautifulTriplets(d, arr);
        br.close();
    }

    public static void beautifulTriplets(int d, String... arr) {
        int count = 0;
        Arrays.sort(arr);
        for (String s : arr) {
            int num = Integer.parseInt(s);
            int val = num + d;
            int ind = Arrays.binarySearch(arr, val + "");
            if (ind >= 0) {
                ind = Arrays.binarySearch(arr, (val + d) + "");
                if (ind >= 0)
                    count++;
            }
        }
        System.out.println(count);
    }

}
