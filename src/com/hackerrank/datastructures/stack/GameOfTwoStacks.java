package com.hackerrank.datastructures.stack;

import java.util.Stack;

/**
 * 
 */
/**
 * 
 * @author Shrey
 *
 */
public class GameOfTwoStacks {

	public static void main(String[] args) {
		int[] a = new int[] { 4, 2, 4, 6, 1 };
		int[] b = new int[] { 2, 1, 8, 5 };
		System.out.println(twoStacks(10, a, b));
	}

	static int twoStacks(int x, int[] a, int[] b) {
		Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int sum1=0,sum2=0;
        int count1=0,count2=0;
        for (int i = a.length - 1; i >= 0; i--){
            stack1.push(a[i]);
            if((sum1+a[i])<=x){
              sum1+=a[i];
              count1++;
            }
        }
        for (int i = b.length - 1; i >= 0; i--){
            stack2.push(b[i]);
             if(sum2<=x){
              sum2+=a[i];
              count2++;
            }
        }
        int max = Math.max(count1,count2);
        int sum = 0;
        int count = 0;
        while (sum <= x) {
            if (stack1.peek() <= stack2.peek()) {
                if (sum + stack1.peek() <= x) {
                    sum += stack1.pop();
                    count++;
                } else
                    sum += stack1.peek();
            } else if (stack2.peek() < stack1.peek()) {
                if (sum + stack2.peek() <= x) {
                    sum += stack2.pop();
                    count++;
                } else
                    sum += stack2.peek();
            }
        }
        return Math.max(max,count);
	}

}
