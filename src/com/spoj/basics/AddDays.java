package com.spoj.basics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/SHADDAYS/">SHADDAYS - Add Days</a>
 * 
 * @author Shrey
 *
 */
public class AddDays {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			String dateStr = scan.next();
			int days = scan.nextInt();
			newDate(dateStr, days);
		}
		scan.close();
	}

	private final static void newDate(String dateStr, int days) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse(dateStr);
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		localDate = localDate.plusDays(days);
		System.out.println(localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
	}

}
