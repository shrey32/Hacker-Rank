package com.spoj.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.spoj.com/problems/HMRO/">HMRO - Help the Military
 * Recruitment Office!</>
 * 
 * @author Shrey
 *
 */
public class HelpTheMilitaryRecruitmentOffice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			Map<String, String> peselMRO = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String pesel = scan.next();
				String mro = scan.next();
				peselMRO.put(pesel, mro);
			}
			int z = scan.nextInt();
			Map<String, String> mappings = new HashMap<>();
			for (int i = 0; i < z; i++) {
				String oldCode = scan.next();
				String newCode = scan.next();
				mappings.put(oldCode, newCode);
			}
			int p = scan.nextInt();
			StringBuilder result = new StringBuilder("\n");
			for (int i = 0; i < p; i++) {
				String pesel = scan.next();
				String code = peselMRO.get(pesel);
				while (mappings.containsKey(code)) {
					code = mappings.get(code);
				}
				result.append(pesel + " " + code + "\n");
			}
			System.out.println(result);
		}
		scan.close();
	}

}
