package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class SimplifyPath {

	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/"));/// home
		System.out.println(simplifyPath("/../"));///
		System.out.println(simplifyPath("/home//foo/"));/// home/foo
		System.out.println(simplifyPath("/a/./b/../../c/"));//c
	}

	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		for (String token : path.split("/")) {
			if (!stack.isEmpty() && "..".equals(token))
				stack.pop();
			else if (!Arrays.asList(".", "", "..").contains(token))
				stack.push(token);
		}

		return "/" + String.join("/", stack);
	}

}
