package com.spoj.basics;

/**
 * <p>
 * <p>
 * <b>ARITH - Simple Arithmetics</b>
 * </p>
 * One part of the new WAP portal is also a calculator computing expressions
 * with very long numbers. To make the output look better, the result is
 * formated the same way as is it usually used with manual calculations.
 * 
 * Your task is to write the core part of this calculator. Given two numbers and
 * the requested operation, you are to compute the result and print it in the
 * form specified below. With addition and subtraction, the numbers are written
 * below each other. Multiplication is a little bit more complex: first of all,
 * we make a partial result for every digit of one of the numbers, and then sum
 * the results together.
 * </p>
 * <p>
 * <p>
 * <b>Input</b>
 * </p>
 * There is a single positive integer T on the first line of input (equal to
 * about 1000). It stands for the number of expressions to follow. Each
 * expression consists of a single line containing a positive integer number, an
 * operator (one of +, - and *) and the second positive integer number. Every
 * number has at most 500 digits. There are no spaces on the line. If the
 * operation is subtraction, the second number is always lower than the first
 * one. No number will begin with zero.
 * </p>
 * 
 * <p>
 * <p>
 * <b>Output</b>
 * </p>
 * For each expression, print two lines with two given numbers, the second
 * number below the first one, last digits (representing unities) must be
 * aligned in the same column. Put the operator right in front of the first
 * digit of the second number. After the second number, there must be a
 * horizontal line made of dashes (-).
 * 
 * For each addition or subtraction, put the result right below the horizontal
 * line, with last digit aligned to the last digit of both operands.
 * 
 * For each multiplication, multiply the first number by each digit of the
 * second number. Put the partial results one below the other, starting with the
 * product of the last digit of the second number. Each partial result should be
 * aligned with the corresponding digit. That means the last digit of the
 * partial product must be in the same column as the digit of the second number.
 * No product may begin with any additional zeros. If a particular digit is
 * zero, the product has exactly one digit -- zero. If the second number has
 * more than one digit, print another horizontal line under the partial results,
 * and then print the sum of them.
 * 
 * There must be minimal number of spaces on the beginning of lines, with
 * respect to other constraints. The horizontal line is always as long as
 * necessary to reach the left and right end of both numbers (and operators)
 * directly below and above it. That means it begins in the same column where
 * the leftmost digit or operator of that two lines (one below and one above)
 * is. It ends in the column where is the rightmost digit of that two numbers.
 * The line can be neither longer nor shorter than specified.
 * 
 * Print one blank line after each test case, including the last one.
 * </p>
 * 
 * <p>
 * <b>Example</b>
 * </p>
 * <p>
 * <b>Sample Input:</b>
 * </p>
 * <p>
 * 4
 * <li>12345+67890</li>
 * <li>324-111</li>
 * <li>325*4405</li>
 * <li>1234*4</li>
 * </p>
 * 
 * <p>
 * <b>Sample Input:</b>
 * </p>
 * <p>
 * <p>
 * &nbsp;&nbsp;12345<br>
 * +67890<br>
 * &nbsp;&nbsp;&nbsp;------<br>
 * &nbsp;&nbsp;&nbsp;80235
 * </p>
 * 
 * <p>
 * &nbsp;&nbsp;324<br>
 * &nbsp;-111<br>
 * &nbsp;&nbsp; ---- <br>
 * &nbsp;&nbsp;&nbsp;213
 * </p>
 * 
 * <p>
 * 325<br>
 * *4405<br>
 * ----- 1625 0 1300 1300 ------- 1431625
 * <p>
 * 
 * 1234 4 ---- 4936
 * </p>
 * 
 * @author Shrey
 *
 */
public class SimpleArithmetics {

	private final static String ADD = "+";
	private final static String SUB = "-";
	private final static String MULTI = "*";

	public static void main(String[] args) {
		simpleArithmetic("12345+67890");
		simpleArithmetic("12345-67890");
		simpleArithmetic("324-111");
		simpleArithmetic("325*4405");
		simpleArithmetic("1234*4");
		simpleArithmetic("34*34");
	}

	static void simpleArithmetic(String exp) {
		String ops = "+*-";
		String operator = "";

		for (int i = 0; i < ops.length(); i++) {
			operator = ops.charAt(i) + "";
			if (exp.indexOf(operator) > 0)
				break;
		}

		String[] nums = exp.split("\\" + operator);
		Long a = Long.parseLong(nums[0]);
		Long b = Long.parseLong(nums[1]);

		switch (operator) {
		case ADD:
			addSub(a, b, operator);
			break;
		case SUB:
			addSub(a, b, operator);
			break;
		case MULTI:
			multi(a, b, operator);
			break;
		}
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param operator
	 */
	private static void addSub(Long a, Long b, String operator) {
		StringBuilder result = new StringBuilder();
		Long c = a + b;
		if (SUB.equals(operator)) {
			c = Math.abs(a - b);
		}
		result.append(" " + a + "\n");
		result.append(operator);
		result.append(b + "\n");
		for (int i = 0; i <= c.toString().length(); i++)
			result.append("-");
		result.append("\n");
		result.append(" " + c + "\n");
		System.out.println(result.toString());
	}

	private static void multi(Long a, Long b, String operator) {
		StringBuilder result = new StringBuilder();
		result.append(" " + a + "\n");
		result.append(operator);
		result.append(b + "\n");
		int len = Long.valueOf(Math.max(a, b)).toString().length();
		for (int i = 0; i <= len; i++)
			result.append("-");
		result.append("\n");
		long c = b;
		int space = 0;
		while (c > 0) {
			long rem = c % 10;
			Long prod = a * rem;
			result.append(prod);
			for (int i = 0; i < space; i++)
				result.append(" ");
			result.append("\n");
			space++;
			c = c / 10;
		}
		if (b.toString().length() > 1) {
			Long multi = a * b;
			for (int i = 0; i <= multi.toString().length(); i++)
				result.append("-");
			result.append("\n");
			result.append(multi + "\n");
		}
		System.out.println(result.toString());
	}

}
