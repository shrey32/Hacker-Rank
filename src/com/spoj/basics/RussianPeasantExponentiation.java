package com.spoj.basics;

/**
 * We all know how to calculate  using  operations by multiplying  by  a total of  times. The drawback to this method is that  can be large, which makes exponentiation very slow.

There is a well known method called Russian Peasant Multiplication that you can read about here. Now let's use this to raise some complex numbers to powers!

You're given  queries where each query consists of four integers: , , , and . For each query, calculate  (where  is an imaginary unit) and then print the respective values of  and  as two space-separated integers on a new line.

Input Format

The first line contains a single integer, , denoting the number of queries.
Each of the  subsequent lines describes a query in the form of four space-separated integers: , , , and  (respectively).

Constraints

Output Format

For each query, print the two space-separated integers denoting the respective values of  and  on a new line.

Sample Input

3
2 0 9 1000
0 1 5 10
8 2 10 1000000000
Sample Output

512 0
0 1
880332800 927506432
Explanation

In the first query, we have , , , . We calculate the following:


 */
/**
 * 
 * @author Shrey
 *
 */
public class RussianPeasantExponentiation {

	public static void main(String[] args) {
		solve(2, 0, 9, 1000);
		solve(0, 1, 5, 10);
		solve(8, 2, 10, 1000000000);
	}

	static void solve(int a, int b, long k, long m) {
		ComplexNumber result = fastComplexExponentian(new ComplexNumber(a % m, b % m), k, m);
		System.out.print(printModOfValue(result.getRealPart(), m));
		System.out.print(" ");
		System.out.println(printModOfValue(result.getImaginaryPart(), m));
	}

	/**
	 * Russian peasant alogrithm
	 * 
	 * @param n
	 * @param pow
	 * @return
	 */
	static double pow(int n, long pow) {
		int sq = 1;
		double res = n;

		while (sq <= pow) {
			if (sq + sq <= pow) {
				res = res * res;
				sq += sq;
			} else {
				break;
			}
		}

		res = res * Math.pow(n, pow - sq);
		return res;

	}

	private static ComplexNumber fastComplexExponentian(ComplexNumber base, Long exponent, Long modulus) {

		ComplexNumber result = new ComplexNumber(1, 0);
		while (exponent > 0) {
			if (exponent % 2 == 1) {
				result = result.multiply(base, modulus);
			}
			base = base.squareWithMod(modulus);
			exponent >>= 1;
		}
		return result;
	}

	private static long printModOfValue(long a, long modulus) {
		if (a > 0) {
			return a % modulus;
		} else if (a < 0) {
			while (a < 0) {
				a = (((a % modulus) + modulus) % modulus);
				if (a > 0) {
					break;
				}
			}
			return a % modulus;
		} else {
			return 0;
		}
	}

}

class ComplexNumber {

	private final long realPart;
	private final long imaginaryPart;

	public ComplexNumber(long realPart, long imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	public long getRealPart() {
		return realPart;
	}

	public long getImaginaryPart() {
		return imaginaryPart;
	}

	// (a + ib) ^ 2 = (a^2 - b^2) + i (2 * a * b)
	public ComplexNumber squareWithMod(long modulus) {

		long a = this.realPart % modulus;
		long b = this.imaginaryPart % modulus;

		long realPartSquare = ((a * a) % modulus - (b * b) % modulus) % modulus;
		long imaginaryPartSquare = ((2 % modulus) * a * b) % modulus;

		return new ComplexNumber(realPartSquare, imaginaryPartSquare);
	}

	// (a + bi) * (c + di) = (ac - bd) + i (bc + ad)
	public ComplexNumber multiply(ComplexNumber complexNumber, long modulus) {

		long a = this.realPart % modulus;
		long b = this.imaginaryPart % modulus;

		long c = complexNumber.getRealPart() % modulus;
		long d = complexNumber.getImaginaryPart() % modulus;

		long newRealPart = (((a * c) % modulus) - ((b * d) % modulus)) % modulus;
		long newImaginaryPart = (((a * d) % modulus) + ((b * c) % modulus)) % modulus;

		return new ComplexNumber(newRealPart, newImaginaryPart);
	}

}
