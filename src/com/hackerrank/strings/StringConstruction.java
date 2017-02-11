package com.hackerrank.strings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Amanda has a string, , of  lowercase letters that she wants to copy into a new string, . She can perform the following operations any number of times to construct string :
 * <p>
 * Append a character to the end of string  at a cost of  dollar.
 * Choose any substring of  and append it to the end of  at no charge.
 * Given  strings (i.e., ), find and print the minimum cost of copying each  to  on a new line.
 * <p>
 * Input Format
 * <p>
 * The first line contains a single integer, , denoting the number of strings.
 * Each line  of the  subsequent lines contains a single string, .
 * <p>
 * Constraints
 * <p>
 * Subtasks
 * <p>
 * for  of the maximum score.
 * Output Format
 * <p>
 * For each string  (where ), print the minimum cost of constructing string  on a new line.
 * <p>
 * Sample Input
 * <p>
 * 2
 * abcd
 * abab
 * Sample Output
 * <p>
 * 4
 * 2
 * Explanation
 * <p>
 * Query 0: We start with  and .
 * <p>
 * Append character '' to  at a cost of  dollar, .
 * Append character '' to  at a cost of  dollar, .
 * Append character '' to  at a cost of  dollar, .
 * Append character '' to  at a cost of  dollar, .
 * Because the total cost of all operations is  dollars, we print  on a new line.
 * <p>
 * Query 1: We start with  and .
 * <p>
 * Append character '' to  at a cost of  dollar, .
 * Append character '' to  at a cost of  dollar, .
 * Append substring  to  at no cost, .
 * Because the total cost of all operations is  dollars, we print  on a new line.
 * <p>
 * Note
 * <p>
 * A substring of a string  is another string  that occurs "in"  (Wikipedia). For example, the substrings of the string "" are "", "" ,"", "", "", and "".
 */

/**
 * Created by Shrey on 2/11/2017.
 */
public class StringConstruction {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String s;
        while (n-- > 0) {
            s = br.readLine().trim();
            List<String> list = new ArrayList<>(Arrays.asList(s.split("")));
            Set<String> set = new HashSet<>(list);
            System.out.println(set.size());
        }
        br.close();
    }

}
