package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Problem Statement

 You are given time in AM/PM format. Convert this into a 24 hour format.

 Note Midnight is 12:00:00AM or 00:00:00 and 12 Noon is 12:00:00.

 Input Format

 Input consists of time in the AM/PM format i.e. hh:mm:ssAM or hh:mm:ssPM 
 where 
 01≤hh≤12 
 00≤mm≤59 
 00≤ss≤59

 Output Format

 You need to print the time in 24 hour format i.e. hh:mm:ss 
 where 
 00≤hh≤23 
 00≤mm≤59 
 00≤ss≤59

 Sample Input

 07:05:45PM
 Sample Output

 19:05:45
 */
/**
 * 
 * @author Shrey
 *
 */
public class TimeConversion {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ssa");
		Date date = sdf.parse(line);
		String hours = date.getHours() < 10 ? "0" + date.getHours() : ""
				+ date.getHours();
		String mins = date.getMinutes() < 10 ? "0" + date.getMinutes() : ""
				+ date.getMinutes();
		String seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : ""
				+ date.getSeconds();
		System.out.println(hours + ":" + mins + ":" + seconds);
	}

}
