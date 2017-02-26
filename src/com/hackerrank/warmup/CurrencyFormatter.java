package com.hackerrank.warmup;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Given a double-precision number, , denoting an amount of money, use the NumberFormat class' getCurrencyInstance method to convert  into the US, Indian, Chinese, and French currency formats. Then print the formatted values as follows:
 * <p>
 * US: formattedPayment
 * India: formattedPayment
 * China: formattedPayment
 * France: formattedPayment
 * where  is  formatted according to the appropriate Locale's currency.
 * <p>
 * Note: India does not have a built-in Locale, so you must construct one where the language is en (i.e., English).
 * <p>
 * Input Format
 * <p>
 * A single double-precision number denoting .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * On the first line, print US: u where  is  formatted for US currency.
 * On the second line, print India: i where  is  formatted for Indian currency.
 * On the third line, print China: c where  is  formatted for Chinese currency.
 * On the fourth line, print France: f, where  is  formatted for French currency.
 * <p>
 * Sample Input
 * <p>
 * 12324.134
 * Sample Output
 * <p>
 * US: $12,324.13
 * India: Rs.12,324.13
 * China: ￥12,324.13
 * France: 12 324,13 €
 * Explanation
 * <p>
 * Each line contains the value of  formatted according to the four countries' respective currencies.
 * <p>
 * Created by Shrey on 2/26/2017.
 */
public class CurrencyFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        Locale.setDefault(new Locale("en", "IN"));
        String india = NumberFormat.getCurrencyInstance().format(payment);

        Locale uslocale = new Locale.Builder().setLanguage("en").setRegion("US").build();
        NumberFormat usformat = NumberFormat.getCurrencyInstance(uslocale);
        System.out.println("US: " + usformat.format(payment));

        System.out.println("India: " + india);

        Locale.setDefault(Locale.CHINA);
        String china = NumberFormat.getCurrencyInstance().format(payment);
        System.out.println("China: " + china);

        Locale.setDefault(Locale.FRANCE);
        String france = NumberFormat.getCurrencyInstance().format(payment);
        System.out.println("France: " + france);
    }

}
