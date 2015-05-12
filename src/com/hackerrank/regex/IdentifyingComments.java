package com.hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Problem Statement

 Jack wants to build an IDE on his own. Help him build a feature which identifies the comments, in the source code of computer programs. Assume, that the programs are written either in C, C++ or Java. The commenting conventions are displayed here, for your convenience. At this point of time you only need to handle simple and common kinds of comments. You don't need to handle nested comments, or multi-line comments inside single comments or single-comments inside multi-line comments.

 Your task is to write a program, which accepts as input, a C or C++ or Java program and outputs only the comments from those programs. Your program will be tested on source codes of not more than 200 lines.

 Comments in C, C++ and Java programs

 Single Line Comments:

 // this is a single line comment
 x = 1; // a single line comment after code
 Please note that in the real world, some C compilers do not necessarily support the above kind of comment(s) but for the purpose of this problem let's just assume that the compiler which will be used here will accept these kind of comments.
 */
/**
 * 
 * @author Shrey
 *
 */
public class IdentifyingComments {

	public static void main(String[] args) throws IOException {
        //Get code
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(String line; (line = br.readLine()) != null; sb.append(line + "\n")){}
        String code = sb.toString();

        //Run the regex
        Matcher m = Pattern.compile(
            "\\/\\/.*?(?=\\n)|\\/\\*.*?\\*\\/", 
            Pattern.DOTALL | Pattern.MULTILINE
        ).matcher(code);

        //Print out matches
        sb = new StringBuffer();
        while (m.find()){
            sb.append(m.group() + "\n");
        }
        System.out.print(sb);
    }

}
