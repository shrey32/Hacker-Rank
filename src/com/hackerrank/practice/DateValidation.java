package com.hackerrank.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 
 * <a href="https://www.spoj.com/problems/FUCT_IF_CHKDATE/">FUCT_IF_CHKDATE -
 * Date validation</a>
 * 
 * @author Shrey
 *
 */
public class DateValidation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int mm = scan.nextInt();
			int dd = scan.nextInt();
			int yyyy = scan.nextInt();
			System.out.println(validate(mm, dd, yyyy) ? "VALID" : "INVALID");
		}
		scan.close();
	}

	private static final boolean validate(int mm, int dd, int yyyy) {
		try {
			String dateStr = dd + "/" + mm + "/" + yyyy;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			sdf.parse(dateStr);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

}
