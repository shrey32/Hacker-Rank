package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement

 A Smith number is a composite number, the sum of whose digits is the sum of the digits of its prime factors obtained as a result of prime factorization (excluding 1). The first few such numbers are 4, 22, 27, 58, 85, 94, and 121.

 Example: 
 378=2󫢫󫢯 
 So, its prime factors are 2, 3, 3, 3, and 7. 
 The sum of its digits is (3+7+8)=18. 
 The sum of the digits of its factors is (2+3+3+3+7)=18.

 Similarly, 4937775 is a Smith number. 
 4937775=3󬊅�65837, and the sum of its digits is the same as the sum of the digits of its prime factors: 4+9+3+7+7+7+5=3+5+5+6+5+8+3+7=42.

 Task: 
 Write a program to check whether a given integer is a Smith number.

 Input Format

 There will be only one line of input: N, the number which needs to be checked.

 Constraints: 
 0<N<2,147,483,647 (max value of an integer of the size of 4 bytes)

 Output Format

 1 if the number is a Smith number. 
 0 if the number is a not Smith number.

 Sample Input

 378

 Sample Output

 1

 Explanation

 Its prime factors are 2, 3, 3, 3, and 7. 
 The sum of its digits is (3+7+8)=18. 
 The sum of the digits of its factors is (2+3+3+3+7)=18.
 */
/**
 * 
 * @author Shrey
 *
 */
public class IdentifySmithNumbers {

	public static void main(String[] args) throws IOException,
			NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		identifySmithNumbers(number);
		br.close();
	}

	public static void identifySmithNumbers(int number) {
		int n = Integer.valueOf(number);
		int j = 2;
		List<Integer> list = new ArrayList<Integer>();
		while (n != 1) {
			if (n % j == 0) {
				n = n / j;
				list.add(j);
			} else {
				j++;
			}
		}
		int sum = 0;
		for (int i : list) {
			while (i > 0) {
				sum += i % 10;
				i = i / 10;
			}
		}
		int sum2 = 0;
		while (number > 0) {
			sum2 += number % 10;
			number = number / 10;
		}
		if (sum == sum2) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
