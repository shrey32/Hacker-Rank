package com.hackerrank.goldmansachs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are going to receive  payments in the upcoming month. The payments are numbered from  to and  denotes the amount of money in dollars that will be paid in connection with the -th payment. Before receiving the payments, you have two banking options to consider:

 You can receive all the payments on your current bank account remembering that the bank charges you for each payment  , where  and  are given.
 You can pay the bank  dollars upfront to open a new special account for which the bank doesn't charge you for any of the upcoming transactions.
 Your task is to decide which of the above two options is more profitable to you. If both ways are equally profitable, then you prefer to be charged for each transaction.

 Input Format

 In the first line, there is a single integer  denoting the number of scenarios to handle. After that, descriptions of all these scenarios follow. In the first line of a single scenario, there are  space-separated integers . In the second line, there are  space separated integers .

 Constraints

 Output Format

 Print exactly  lines. In the -th of them, print the answer to the -th scenario. More specifically, print feeif it's more profitable to use the current account and let the bank charge for each transaction, or print upfront if it's better to pay the bank up front for opening the new special account.

 Sample Input 0

 3
 3 20 10 60
 100 200 300
 3 20 15 120
 200 250 300
 1 1 10 100
 1000
 Sample Output 0

 upfront
 fee
 fee
 Explanation 0

 There are  scenarios in the sample.

 In the first one, there are  payments with amounts: . In the first option, for each transaction with amount , the bank charges . In the second option, you can pay upfront . It turns out that it's better to choose the second option, i.e. pay up front, because in the first option the bank would charge  across all the payments.

 In the second scenario, it's better to be charged for each transaction because the bank will charge across all payments, which is strictly less than the cost of paying upfront.

 In the third scenario, each banking option costs . In the statement, it's written than in such a case we prefer to pay a fee.
 */
/**
 * 
 * @author Shrey
 *
 */
public class BankAccounts {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine().trim());
		for (int a0 = 0; a0 < q; a0++) {
			String[] line = br.readLine().trim().split(" ");
			int n = Integer.parseInt(line[0]);
			int k = Integer.parseInt(line[1]);
			int x = Integer.parseInt(line[2]);
			int d = Integer.parseInt(line[3]);
			// amounts
			line = br.readLine().trim().split(" ");
			String result = feeOrUpfront(n, k, x, d, line);
			System.out.println(result);
		}
		br.close();
	}

	private static String feeOrUpfront(int n, int k, int x, int d, String[] p) {
		double perAccountCharge = 0;
		for (String am : p) {
			int value = Integer.parseInt(am);
			perAccountCharge += Math.max(k, x * 0.01 * value);
		}
		return perAccountCharge <= d ? "fee" : "upfront";
	}

}
