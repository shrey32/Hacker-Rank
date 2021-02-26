package com.leetcode;

import java.util.Stack;

/**
 * 
 * @author Shrey
 *
 */
public class ValidateStackSequences {

	public static void main(String[] args) {
		System.out.println(validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 }));
		System.out.println(validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 3, 5, 1, 2 }));
	}

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
        int ind = 0;
        for(int i=0;i<pushed.length;i++){
            int elem = pushed[i];
            stack.push(elem);
            while(!stack.isEmpty() && popped[ind]==stack.peek()){
                stack.pop();
                ind++;
            }
        }
       return stack.isEmpty();
	}

}
