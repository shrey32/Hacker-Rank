package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Steve has a string, , consisting of  lowercase English alphabetic letters. In one operation, he can delete any pair of adjacent letters with same value. For example, string "aabcc" would become either "aab" or "bcc" after operation.
 * <p>
 * Steve wants to reduce  as much as possible. To do this, he will repeat the above operation as many times as it can be performed. Help Steve out by finding and printing 's non-reducible form!
 * <p>
 * Note: If the final string is empty, print Empty String .
 * <p>
 * Input Format
 * <p>
 * A single string, .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * If the final string is empty, print Empty String; otherwise, print the final non-reducible string.
 * <p>
 * Sample Input 0
 * <p>
 * aaabccddd
 * Sample Output 0
 * <p>
 * abd
 * Sample Case 0
 * <p>
 * Steve can perform the following sequence of operations to get the final string:
 * <p>
 * aaabccddd → abccddd
 * abccddd → abddd
 * abddd → abd
 * Thus, we print abd.
 * <p>
 * Sample Input 1
 * <p>
 * baab
 * Sample Output 1
 * <p>
 * Empty String
 * Explanation 1
 * <p>
 * Steve can perform the following sequence of operations to get the final string:
 * <p>
 * baab → bb
 * bb → Empty String
 * Thus, we print Empty String.
 * <p>
 * Sample Input 2
 * <p>
 * aa
 * Sample Output 2
 * <p>
 * Empty String
 * Explanation 2
 * <p>
 * Steve can perform the following sequence of operations to get the final string:
 * <p>
 * aa → Empty String
 * Thus, we print Empty String.
 * <p>
 * Created by Shrey on 2/11/2017.
 */
public class SuperReducedString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                s = s.substring(0, i-1) + s.substring(i+1);;
                i = 0;
            }
        }
        if (s.length() > 0)
            System.out.println(s);
        else
            System.out.println("Empty String");
        br.close();
    }

}
