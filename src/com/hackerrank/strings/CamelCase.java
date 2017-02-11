package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Alice wrote a sequence of words in CamelCase as a string of letters, , having the following properties:
 * <p>
 * It is a concatenation of one or more words consisting of English letters.
 * All letters in the first word are lowercase.
 * For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
 * Given , print the number of words in  on a new line.
 * <p>
 * Input Format
 * <p>
 * A single line containing string .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print the number of words in string .
 * <p>
 * Sample Input
 * <p>
 * saveChangesInTheEditor
 * Sample Output
 * <p>
 * 5
 * Explanation
 * <p>
 * String  contains five words:
 * <p>
 * save
 * Changes
 * In
 * The
 * Editor
 * Thus, we print  on a new line.
 * Created by Shrey on 2/11/2017.
 */
public class CamelCase {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String[] arr = s.split("[A-Z]");
        System.out.println(arr.length);
        br.close();
    }

}
