package com.hackerrank.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * <a href=
 * "https://www.hackerrank.com/challenges/jim-and-the-skyscrapers/problem">Jim
 * and the Skyscrapers</a>
 * 
 * @author Shrey
 *
 */
public class JimAndSkyScrappers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[] a = new int[n];
		String[] inputs = br.readLine().trim().split(" ");
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(inputs[i]);
		}

		long result = solve(a);
		System.out.println(result);
		br.close();
	}

	public static long solve( int[] skyScrappers ) {
        long routesCount = 0;
        Stack<Integer> stack = new Stack<>();

        for( int i = 0; i < skyScrappers.length; i++ ) {
            int s = skyScrappers[i];
            if( stack.isEmpty() ) {
                stack.add( s );
            }
            else if( stack.peek() > s ) {
                stack.add( s );
            }
            else if( stack.peek() < s ) {
                while( !stack.isEmpty() && stack.peek() < s ) {
                    long sameS, cnt = 0;
                    do {
                        sameS = stack.pop();
                        cnt++;
                    } while( !stack.isEmpty() &&  stack.peek() == sameS );
                    if( cnt >= 2 ) {
                        routesCount += ((cnt-1)*cnt);
                    }
                }
                stack.add( s );
            }
            else if( stack.peek() == s ) {
                stack.add( s );
            }
        }

        if( !stack.isEmpty() ) {
            long cnt = 1;
            boolean same;
            int s1 = stack.pop();
            while( !stack.isEmpty() ) {
                same = (s1 == stack.peek());
                if( same ) {
                    stack.pop();
                    cnt++;
                    if( stack.isEmpty() ) {
                        if( cnt > 1 ) {
                            routesCount += ((cnt-1)*cnt);
                        }
                    }
                }
                else {
                    if( cnt > 1 ) {
                        routesCount += ((cnt-1)*cnt);
                    }
                    cnt = 1;
                    s1 = stack.pop();
                }
             }
        }
        return routesCount;
    }

}
