package com.hackerrank.warmup;

public class SqrtOfANumber {

	public static void main(String[] args) {
		System.out.println(sqrt(25));
		
		System.out.println("Math function=>"+Math.sqrt(7)+", my function=>"+sqrt2(7));
	}

	static int sqrt(int x) {
		if (x == 0 || x == 1)
			return x;
		int i = 1, result = 1;
		while (result <= x) {
			i++;
			result = i * i;
		}
		return i - 1;
	}

	static double sqrt2(double x) {
		if (x == 0 || x == 1)
			return x;
		double start = 0;
		double end = x;
		double inc = 0.001;
		double result = 0;
		while (start <= end) {
			double mid = (start + end) / 2;
			if (mid * mid == x)
				return mid;
			if (mid * mid < x) {
				start = mid + inc;
				result = mid;
			} else
				end = mid - inc;
		}
		return result;
	}

}
